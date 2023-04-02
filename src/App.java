import java.io.InputStream;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        String source = "imdb";
        // String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        String url = "https://api.nasa.gov/planetary/apod?api_key=3y6BgQvX5uezdZngthGqgWdnj5rdarCTSWnxbkTm&count=10";
        RequestHandler handler = new RequestHandler();

        String body = handler.getBody(url);

        ContentExtractor extractor;
        if (source == "imdb") {
            extractor = new NASAExtractor();
        } else if (source == "nasa") {
            extractor = new IMDBExtractor();
        } else {
            throw new Exception("What!");
        }
        List<Content> contentList = extractor.extract(body);
        
        int count = 0;
        for (Content content : contentList) {
            StickerGenerator generator = new StickerGenerator();
            InputStream inputStream = content.getImageUrl().openStream();
            generator.generate(inputStream, content.getTitle());
            count++;
            if (count > 5) {
                break;
            }
        }
    }
    
}

