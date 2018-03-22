/**
 *
 */
package fr.goat.bo;

/**
 * @author cnoiray
 */
public class Position {

    private int lane;
    private int row;

    public Position() {

    }

    /**
     * @param pLane
     * @param pRow
     */
    public Position(final int pLane, final int pRow) {
        super();
        lane = pLane;
        row = pRow;
    }

    /**
     * Getter du paramètre 'lane'
     *
     * @return Le paramètre 'lane'
     */
    public int getLane() {
        return lane;
    }

    /**
     * Setter du paramètre 'lane'.
     *
     * @param pLane
     *            Le paramètre 'lane' à renseigner.
     */
    public void setLane(final int pLane) {
        lane = pLane;
    }

    /**
     * Getter du paramètre 'row'
     *
     * @return Le paramètre 'row'
     */
    public int getRow() {
        return row;
    }

    /**
     * Setter du paramètre 'row'.
     *
     * @param pRow
     *            Le paramètre 'row' à renseigner.
     */
    public void setRow(final int pRow) {
        row = pRow;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object B) {
        if (B == null || !(B instanceof Position)) {
            return false;
        }

        if (this.getLane() == ((Position) B).getLane() && this.getRow() == ((Position) B).getRow()) {
            return true;
        }
        return false;
    }

}
