import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IMDBExtractor implements ContentExtractor {
    public List<Content> extract(String body) {
        JsonParser parser = new JsonParser();
        List<Map<String, String>> jsonMap = parser.parse(body);

        List<Content> contentList = new ArrayList<>();
        for (Map<String, String> item : jsonMap) {
            Content newContent = new Content(item.get("title"), item.get("image"));
            contentList.add(newContent);
        }

        return contentList;
    }
}
