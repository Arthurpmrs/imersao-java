import java.net.URL;
import java.net.MalformedURLException;

public class Content {
    private String title;
    private URL image;

    public Content(String title, String imageUrl) {
        try {
            this.image = new URL(imageUrl);
        } catch (MalformedURLException e) {
            this.image = null;
            System.out.println("Invalid URL!");
        }
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public URL getImageUrl() {
        return this.image;
    }
}
