/**
 *
 */
package fr.goat.manager;

import org.apache.log4j.Logger;

import fr.goat.bo.MapPOJO;
import fr.goat.controller.ControllerAPI;
import fr.goat.utils.GameStatut;
import fr.goat.utils.MoveEnum;
import fr.goat.utils.ResultCoupStatut;

/**
 * @author cnoiray
 */
public class GameManager {

    private static final Logger LOGGER = Logger.getLogger(GameManager.class);
    private final ControllerAPI controller;
    private final boolean isPractice;
    private final int lvlIA;

    public GameManager(final boolean isPractice, final int lvlIA) {
        controller = new ControllerAPI();
        this.isPractice = isPractice;
        this.lvlIA = lvlIA;

    }

    public void workflow() {
        LOGGER.info("start workflow");
        final String teamId = controller.getIdEquipeAPI();
        String gameId = "";
        GameStatut statutGame = GameStatut.CANPLAY;
        boolean firstMove = true;

        if (isPractice) {
            gameId = practiceNewGame(teamId);
        } else {
            gameId = versusNewGame(teamId);
        }

        ResultCoupStatut result = ResultCoupStatut.OK;
        boolean isFinish = false;

        // on joue la partie
        while (ResultCoupStatut.OK.equals(result) || ResultCoupStatut.NOTYET.equals(result)) {
            statutGame = controller.getGameStatutAPI(teamId, gameId);

            switch (statutGame) {
            case CANTPLAY:
                continue;
            case RANKING:
                isFinish = true;
                break;
            case RANKED:
                isFinish = true;
                break;
            case CANCELLED:
                isFinish = true;
                break;
            }

            if (isFinish) {
                break;
            }

            final MapPOJO map = controller.getGameAPI(gameId, teamId);

            if (firstMove) {
                result = controller.playAPI(gameId, teamId, MoveEnum.LEFT.name());
                firstMove = false;
            } else {
                result = controller.playAPI(gameId, teamId, MoveEnum.FORWARD.name());
            }
        }
        LOGGER.info("end workflow");
    }

    public String practiceNewGame(final String teamId) {
        String gameId = null;
        while (gameId == null || "NA".equals(gameId)) {
            gameId = controller.chooseGameAPI(lvlIA, teamId);
        }
        return gameId;
    }

    public String versusNewGame(final String teamId) {
        String gameId = null;
        while (gameId == null || "NA".equals(gameId)) {
            gameId = controller.getNextAdversaireAPI(teamId);
        }

        return gameId;
    }
}
