/**
 *
 */
package fr.goat.adapter;

import fr.goat.bo.Board;

/**
 * @author cnoiray
 */
public class BoardAdapter extends JsonAdapter<Board> {

    public BoardAdapter() {
        super(Board.class);
    }
}
