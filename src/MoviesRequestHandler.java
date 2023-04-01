import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class MoviesRequestHandler {
    public String getBody(String url) {
        URI uri = URI.create(url);
        
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response;

        try {
            response = client.send(request, BodyHandlers.ofString());
            String body  = response.body();
            return body;
        } catch(IOException | InterruptedException  e) {
            System.out.println("Something went wrong! No Data was received.");
            return "";
        }
    }

    public List<Map<String, String>> parseMovieList(String body) {
        JsonParser parser = new JsonParser();
        return parser.parse(body); 
    }

}