/**
 *
 */
package fr.goat.adapter;

import fr.goat.bo.MapPOJO;

/**
 * @author cnoiray
 */
public class MapAdapter extends JsonAdapter<MapPOJO> {

    public MapAdapter() {
        super(MapPOJO.class);
    }
}
