/**
 *
 */
package fr.goat.bo;

/**
 * @author cnoiray
 */
public class Bonus {

    private String type;
    private Position position;

    /**
     * Getter du paramètre 'type'
     *
     * @return Le paramètre 'type'
     */
    public String getType() {
        return type;
    }

    /**
     * Setter du paramètre 'type'.
     *
     * @param pType
     *            Le paramètre 'type' à renseigner.
     */
    public void setType(final String pType) {
        type = pType;
    }

    /**
     * Getter du paramètre 'position'
     *
     * @return Le paramètre 'position'
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Setter du paramètre 'position'.
     *
     * @param pPosition
     *            Le paramètre 'position' à renseigner.
     */
    public void setPosition(final Position pPosition) {
        position = pPosition;
    }

}
