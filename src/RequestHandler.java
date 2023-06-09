import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.io.IOException;

public class RequestHandler {
    public String getBody(String url) {
        URI uri = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response;

        try {
            response = client.send(request, BodyHandlers.ofString());
            String body = response.body();
            return body;
        } catch(IOException | InterruptedException  e) {
            System.out.println("Something went wrong! No Data was received.");
            return "";
        }
    }
}