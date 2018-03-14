package test.api.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author cnoiray
 */
public class JerseyClientGet {

    public static void main(final String[] args) {
        try {

            final Client client = Client.create();

            final WebResource webResource = client.resource("http://informations.codeandplay.date/test-ws/ping");
            final String output = webResource.get(String.class);

            /*
             * final ClientResponse response =
             * webResource.accept("application/json").get(ClientResponse.class); if (response.getStatus() !=
             * 200) { throw new RuntimeException("Failed : HTTP error code : " + response.getStatus()); }
             * final String output = response.getEntity(String.class);
             */

            System.out.println("Output from Server .... \n");
            System.out.println(output);

        } catch (final Exception e) {

            e.printStackTrace();

        }
    }

    public void jerseyClientGetJsonApli(final String url) {
        final Client client = Client.create();
        final WebResource webResource = client.resource(url);
        final ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }

        final String output = response.getEntity(String.class);

        System.out.println("Output from Server .... \n");
        System.out.println(output);
    }

    public void jerseyClientGetString(final String url) {
        final Client client = Client.create();

        final WebResource webResource = client.resource(url);
        final String output = webResource.get(String.class);
        System.out.println("Output from Server .... \n");
        System.out.println(output);
    }
}
