/**
 *
 */
package fr.goat.bo;

/**
 * @author cnoiray
 */
public class Player {

    private String nom;
    private int nbrDePieces;
    private String dernierMouvement;

    @Override
    public String toString() {
        return "nom:" + nom + " ,nbr de piece:" + nbrDePieces + " ,dernier mvt:" + dernierMouvement;
    }
}
