/**
 *
 */
package fr.goat.bo;

/**
 * @author cnoiray
 */
public class MapPOJO {

    private Player player1;
    private Player player2;
    private Player player3;
    private Player player4;

    private int longueur;
    private int largeur;

    @Override
    public String toString() {
        return "player1:" + player1 + " ,player2:" + player2 + " ,player3:" + player3 + " ,player4:" + player4
            + " ,longueur:" + longueur + " ,largeur:" + largeur;
    }
}
