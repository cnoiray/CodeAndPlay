/**
 *
 */
package fr.goat.manager;

import fr.goat.bo.MapPOJO;
import fr.goat.controller.ControllerAPI;
import fr.goat.utils.GameStatut;
import fr.goat.utils.ResultCoupStatut;

/**
 * @author cnoiray
 */
public class GameManager {

    private final ControllerAPI controller;
    private final boolean isPractice;

    public GameManager(final boolean isPractice) {
        controller = new ControllerAPI();
        this.isPractice = isPractice;

    }

    public void workflow() {
        final String teamId = controller.getIdEquipeAPI();
        String gameId = "";
        GameStatut statutGame = GameStatut.OUI;

        if (isPractice) {
            gameId = practiceNewGame(teamId);
        } else {
            gameId = versusNewGame(teamId);
        }

        ResultCoupStatut result = ResultCoupStatut.OK;
        boolean isFinish = false;

        // on joue la partie
        while (ResultCoupStatut.OK.equals(result) || ResultCoupStatut.PTT.equals(result)) {
            statutGame = controller.getGameStatutAPI(teamId, gameId);

            switch (statutGame) {
            case NON:
                continue;
            case ANNULE:
                continue;
            case GAGNE:
                isFinish = true;
                break;
            case PERDU:
                isFinish = true;
                break;
            }

            if (isFinish) {
                break;
            }

            final MapPOJO map = controller.getGameAPI(gameId);

            // analyse map

            result = controller.playAPI(gameId, teamId, "1", "2");
        }

    }

    public String practiceNewGame(final String teamId) {
        String gameId = null;
        while (gameId == null || "NA".equals(gameId)) {
            gameId = controller.nextGameToPlayVsIaAPI(teamId);
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
