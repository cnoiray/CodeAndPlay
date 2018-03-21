/**
 *
 */
package fr.goat.adapter;

import fr.goat.bo.CoordonneePOJO;

/**
 * @author cnoiray
 */
public class CoordonneeAdapter extends JsonAdapter<CoordonneePOJO> {

    public CoordonneeAdapter() {
        super(CoordonneePOJO.class);
    }
}
