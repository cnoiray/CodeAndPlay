/**
 *
 */
package fr.goat.bo;

/**
 * @author cnoiray
 */
public class Items {

    private String type;
    private Position position;
    private Player player;

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

    /**
     * Getter du paramètre 'player'
     *
     * @return Le paramètre 'player'
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Setter du paramètre 'player'.
     *
     * @param pPlayer
     *            Le paramètre 'player' à renseigner.
     */
    public void setPlayer(final Player pPlayer) {
        player = pPlayer;
    }
}
