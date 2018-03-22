/**
 *
 */
package fr.goat.controller;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import fr.goat.manager.GameManager;

/**
 * @author cnoiray
 */
public class TestAPI {

    private static final Logger LOGGER = Logger.getLogger(TestAPI.class);

    ControllerAPI controller;

    public TestAPI() {
        // TODO Auto-generated constructor stub
    }

    @Before
    public void setup() {
        System.setProperty("http.proxyHost", "marc.proxy.corp.sopra");
        System.setProperty("http.proxyPort", "8080");
        controller = new ControllerAPI();
    }

    /*
     * @Test public void test() { LOGGER.info("Debut test"); final String teamId =
     * controller.getIdEquipeAPI(); assertTrue(teamId != null); // if versus final String nextAdversaireId =
     * controller.getNextAdversaireAPI(teamId); assertTrue(nextAdversaireId != null &&
     * !"NA".equals(nextAdversaireId)); // end if versus // if practisse final String nextIAAdversaireId =
     * controller.chooseGameAPI(1, teamId); assertTrue(nextIAAdversaireId != null &&
     * !"NA".equals(nextIAAdversaireId)); final String gameId = controller.nextGameToPlayVsIaAPI(teamId);
     * assertTrue(gameId != null); // end if practisse final GameStatut statutGame =
     * controller.getGameStatutAPI(teamId, gameId); assertEquals(GameStatut.OUI, statutGame); final MapPOJO
     * map = controller.getGameAPI(gameId); assertEquals("player1:nom:Bob ,nbr de piece:12 ,dernier mvt:2D4 ,"
     * + "player2:nom:Nelly ,nbr de piece:9 ,dernier mvt:VP ," +
     * "player3:nom:Jack ,nbr de piece:1 ,dernier mvt:6D2 ," +
     * "player4:nom:Viper ,nbr de piece:25 ,dernier mvt:CD3 ," + "longueur:125 ," + "largeur:99", map
     * .toString()); final Object coord = controller.lastMoveAPI(gameId); assertEquals("coordX,coordY",
     * coord); final ResultCoupStatut result = controller.playAPI(gameId, teamId, "10", "1");
     * assertEquals(ResultCoupStatut.OK, result); LOGGER.info("Fin test"); }
     */
    @Test
    public void test() {
        LOGGER.info("Debut test");
        final String result = controller.pingAPI();
        LOGGER.info(result);
        LOGGER.info("Fin test");
    }

    @Test
    public void testWorkFlow() {
        final GameManager manager = new GameManager(true, 1);

        manager.workflow();
    }
}
