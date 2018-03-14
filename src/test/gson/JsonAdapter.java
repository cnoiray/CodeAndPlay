/**
 *
 */
package test.gson;

import com.google.gson.Gson;

/**
 * @author cnoiray
 */
public abstract class JsonAdapter<T> {

    private final Gson gson;
    private final Class<T> clazz;

    public JsonAdapter(final Class<T> clazzParam) {
        gson = new Gson();
        this.clazz = clazzParam;
    }

    public T toObject(final String json) {
        return (T) gson.fromJson(json, clazz);
    }

    public String toJson(final T object) {
        return gson.toJson(object);
    }
}
