/**
 *
 */
package fr.goat.bo;

/**
 * @author cnoiray
 */
public class PositionPlayer extends Position {

    private int lap;

    /**
     * Getter du paramètre 'lap'
     *
     * @return Le paramètre 'lap'
     */
    public int getLap() {
        return lap;
    }

    /**
     * Setter du paramètre 'lap'.
     *
     * @param pLap
     *            Le paramètre 'lap' à renseigner.
     */
    public void setLap(final int pLap) {
        lap = pLap;
    }

}
