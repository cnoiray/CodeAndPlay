/**
 *
 */
package fr.goat.bo;

import java.util.List;

/**
 * @author cnoiray
 */
public class Board {

    private int nbrTurnsLeft;
    private Player selfPlayer;

    private List<Player> players;
    private List<Items> items;
    private List<Bonus> bonus;

    /**
     * Getter du paramètre 'nbrTurnsLeft'
     *
     * @return Le paramètre 'nbrTurnsLeft'
     */
    public int getNbrTurnsLeft() {
        return nbrTurnsLeft;
    }

    /**
     * Setter du paramètre 'nbrTurnsLeft'.
     *
     * @param pNbrTurnsLeft
     *            Le paramètre 'nbrTurnsLeft' à renseigner.
     */
    public void setNbrTurnsLeft(final int pNbrTurnsLeft) {
        nbrTurnsLeft = pNbrTurnsLeft;
    }

    /**
     * Getter du paramètre 'selfPlayer'
     *
     * @return Le paramètre 'selfPlayer'
     */
    public Player getSelfPlayer() {
        return selfPlayer;
    }

    /**
     * Setter du paramètre 'selfPlayer'.
     *
     * @param pSelfPlayer
     *            Le paramètre 'selfPlayer' à renseigner.
     */
    public void setSelfPlayer(final Player pSelfPlayer) {
        selfPlayer = pSelfPlayer;
    }

    /**
     * Getter du paramètre 'players'
     *
     * @return Le paramètre 'players'
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * Setter du paramètre 'players'.
     *
     * @param pPlayers
     *            Le paramètre 'players' à renseigner.
     */
    public void setPlayers(final List<Player> pPlayers) {
        players = pPlayers;
    }

    /**
     * Getter du paramètre 'items'
     *
     * @return Le paramètre 'items'
     */
    public List<Items> getItems() {
        return items;
    }

    /**
     * Setter du paramètre 'items'.
     *
     * @param pItems
     *            Le paramètre 'items' à renseigner.
     */
    public void setItems(final List<Items> pItems) {
        items = pItems;
    }

    /**
     * Getter du paramètre 'bonus'
     *
     * @return Le paramètre 'bonus'
     */
    public List<Bonus> getBonus() {
        return bonus;
    }

    /**
     * Setter du paramètre 'bonus'.
     *
     * @param pBonus
     *            Le paramètre 'bonus' à renseigner.
     */
    public void setBonus(final List<Bonus> pBonus) {
        bonus = pBonus;
    }

}
