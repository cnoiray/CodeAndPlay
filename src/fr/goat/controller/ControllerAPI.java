/**
 *
 */
package fr.goat.controller;

import java.text.MessageFormat;

import fr.goat.adapter.MapAdapter;
import fr.goat.bo.MapPOJO;
import fr.goat.utils.ConstantAPI;
import fr.goat.utils.ConstantTeam;
import fr.goat.utils.GameStatut;
import fr.goat.utils.JerseyService;
import fr.goat.utils.ResultCoupStatut;
import fr.goat.utils.UrlGenerator;

/**
 * @author cnoiray
 */
public class ControllerAPI {

    private final MapAdapter mapAdapter;
    
    public ControllerAPI() {
        mapAdapter = new MapAdapter();	
    }

    /**
     * Retourne systématiquement "pong".
     *
     * @return pong
     */
    public String pingAPI() {
        return JerseyService.jerseyClientGetString(ConstantAPI.URL + ConstantAPI.PING);
    }

    /**
     * Envoie l'identifiant de l'équipe à partir de son nom et du mot de passe associé
     *
     * @return idTeam
     */
    public String getIdEquipeAPI() {
        final String urlFormat = UrlGenerator.genererUrlAction(ConstantAPI.GET_UTILISATEUR_ID);
        final String url = MessageFormat.format(urlFormat, ConstantTeam.TEAM_NAME, ConstantTeam.TEAM_MDP);
        return JerseyService.jerseyClientGetString(url);
    }

    /**
     * Retourne l’identifiant de la partie à laquelle l’équipe doit participer "NA" si aucune partie n'est
     * ouverte pour cette équipe
     *
     * @return id partie
     */
    public String getNextAdversaireAPI(final String teamId) {
        final String urlFormat = UrlGenerator.genererUrlAction(ConstantAPI.GET_NEXT_ADVERSAIRE);
        final String url = MessageFormat.format(urlFormat, teamId);
        return JerseyService.jerseyClientGetString(url);
    }

    /**
     * Crée une nouvelle partie contre une IA du niveau souhaité pour l’équipe concernée. "NA" si la partie ne
     * peut pas être créée
     *
     * @return
     */
    public String chooseGameAPI(final int lvlIA, final String teamId) {
        final String urlFormat = UrlGenerator.genererUrlAction(ConstantAPI.CREATE_IA_GAME);
        final String url = MessageFormat.format(urlFormat, lvlIA, teamId);
        return JerseyService.jerseyClientGetString(url);
    }

    /**
     * Retourne l’identifiant de la partie en cours ou initialisée à lquelle l’équipe doit participer. "NA" si
     * aucune partie n’est ouverte
     *
     * @param teamId
     * @return
     */
    public String nextGameToPlayVsIaAPI(final String teamId) {
        final String urlFormat = UrlGenerator.genererUrlAction(ConstantAPI.GET_NEXT_IA_GAME_ID);
        final String url = MessageFormat.format(urlFormat, teamId);
        return JerseyService.jerseyClientGetString(url);
    }

    /**
     * Indique si c’est au tour de l'équipe indiquée de jouer dans la partie concernée Retourne : "OUI" si
     * c'est au tour du joueur/ "NON" si ce n'est pas au joueur/ "GAGNE" si le joueur a gagné la partie/
     * "PERDU" si le joueur a perdu la partie/ "ANNULE" si la partie a été annulée (uniquement dans le cas
     * d'une partie contre un bot)
     *
     * @param teamId
     * @param gameId
     * @return Game Statut
     */
    public GameStatut getGameStatutAPI(final String teamId, final String gameId) {
        final String urlFormat = UrlGenerator.genererUrlAction(ConstantAPI.GET_GAME_STATUT);
        final String url = MessageFormat.format(urlFormat, gameId, teamId);
        final String statut = JerseyService.jerseyClientGetString(url);
        return GameStatut.valueOf(statut);
    }

    /**
     * Retourne le plateau de jeu de la partie concernée Si le format n'est pas renseigné ou si le format
     * indiqué est json, la réponse sera au format JSON. Sinon, la réponse sera une String à parser.
     *
     * @param gameId
     * @return
     */
    public MapPOJO getGameAPI(final String gameId) {
        final String urlFormat = UrlGenerator.genererUrlAction(ConstantAPI.GET_GAME_BOARD);
        final String url = MessageFormat.format(urlFormat, gameId);
        final String result = JerseyService.jerseyClientGetJsonApli(url);

        return mapAdapter.toObject(result);
    }

    /**
     * Retourne le dernier coup joué sur le plateau de la partie indiquée "coordX,coordY" (détail pendant le
     * Code & Play)
     *
     * @param gameId
     * @return
     */
    public Object lastMoveAPI(final String gameId) {
        final String urlFormat = UrlGenerator.genererUrlAction(ConstantAPI.GET_LAST_MOVE);
        final String url = MessageFormat.format(urlFormat, gameId);
        final String result = JerseyService.jerseyClientGetString(url);
        
        return result;
    }

    /**
     * Joue un coup dans la partie concernée, pour l’équipe concernée aux coordonnées X et Y données.
     * Retourne: "OK" si le coup est accepté/ "KO" si le coup est refusé/interdit/ "GAGNE" si c'est le dernier
     * coup gagnant/ "PTT" (Pas Ton Tour) si ce n'est pas au tour du joueur
     *
     * @param gameId
     * @param teamId
     * @param coordX
     * @param coordY
     */
    public ResultCoupStatut playAPI(final String gameId, final String teamId, final String coordX,
        final String coordY) {
        final String urlFormat = UrlGenerator.genererUrlAction(ConstantAPI.PLAY);
        final String url = MessageFormat.format(urlFormat, gameId, teamId, coordX, coordY);
        final String result = JerseyService.jerseyClientGetString(url);
        return ResultCoupStatut.valueOf(result);
    }
}
