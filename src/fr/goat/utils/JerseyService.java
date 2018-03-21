/**
 *
 */
package fr.goat.utils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author cnoiray
 */
public class JerseyService {

    public static String jerseyClientGetJsonApli(final String url) {
        final Client client = Client.create();
        final WebResource webResource = client.resource(url);
        final ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        return response.getEntity(String.class);
    }

    public static String jerseyClientGetString(final String url) {
        final Client client = Client.create();

        final WebResource webResource = client.resource(url);
        return webResource.get(String.class);
    }
}
