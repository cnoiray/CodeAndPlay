/**
 *
 */
package fr.goat.bo;

/**
 * @author cnoiray
 */
public class Player {

    private String playerName;
    private String inventory;
    private int leaderboardPosition;
    private String lastMove;
    private boolean stunned;
    private PositionPlayer position;

    /**
     * Getter du paramètre 'playerName'
     *
     * @return Le paramètre 'playerName'
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Setter du paramètre 'playerName'.
     *
     * @param pPlayerName
     *            Le paramètre 'playerName' à renseigner.
     */
    public void setPlayerName(final String pPlayerName) {
        playerName = pPlayerName;
    }

    /**
     * Getter du paramètre 'inventory'
     *
     * @return Le paramètre 'inventory'
     */
    public String getInventory() {
        return inventory;
    }

    /**
     * Setter du paramètre 'inventory'.
     *
     * @param pInventory
     *            Le paramètre 'inventory' à renseigner.
     */
    public void setInventory(final String pInventory) {
        inventory = pInventory;
    }

    /**
     * Getter du paramètre 'leaderboardPosition'
     *
     * @return Le paramètre 'leaderboardPosition'
     */
    public int getLeaderboardPosition() {
        return leaderboardPosition;
    }

    /**
     * Setter du paramètre 'leaderboardPosition'.
     *
     * @param pLeaderboardPosition
     *            Le paramètre 'leaderboardPosition' à renseigner.
     */
    public void setLeaderboardPosition(final int pLeaderboardPosition) {
        leaderboardPosition = pLeaderboardPosition;
    }

    /**
     * Getter du paramètre 'lastMove'
     *
     * @return Le paramètre 'lastMove'
     */
    public String getLastMove() {
        return lastMove;
    }

    /**
     * Setter du paramètre 'lastMove'.
     *
     * @param pLastMove
     *            Le paramètre 'lastMove' à renseigner.
     */
    public void setLastMove(final String pLastMove) {
        lastMove = pLastMove;
    }

    /**
     * Getter du paramètre 'stunned'
     *
     * @return Le paramètre 'stunned'
     */
    public boolean isStunned() {
        return stunned;
    }

    /**
     * Setter du paramètre 'stunned'.
     *
     * @param pStunned
     *            Le paramètre 'stunned' à renseigner.
     */
    public void setStunned(final boolean pStunned) {
        stunned = pStunned;
    }

    /**
     * Getter du paramètre 'position'
     *
     * @return Le paramètre 'position'
     */
    public PositionPlayer getPosition() {
        return position;
    }

    /**
     * Setter du paramètre 'position'.
     *
     * @param pPosition
     *            Le paramètre 'position' à renseigner.
     */
    public void setPosition(final PositionPlayer pPosition) {
        position = pPosition;
    }

    // @Override
    // public String toString() {
    // return "nom:" + nom + " ,nbr de piece:" + nbrDePieces + " ,dernier mvt:" + dernierMouvement;
    // }
}
