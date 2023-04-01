import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopTVs.json";
        
        MoviesRequestHandler handler = new MoviesRequestHandler();

        String body = handler.getBody(url);
        
        List<Map<String, String>> moviesList = handler.parseMovieList(body);
        
        int count = 0;
        for (Map<String, String> movie : moviesList) {
            StickerGenerator generator = new StickerGenerator();
            InputStream inputStream = new URL(movie.get("image")).openStream();
            generator.generate(inputStream, movie.get("title"));
            // System.out.println(movie.get("image"));
            count++;
            if (count > 5) {
                break;
            }
        }
    }
    
}

