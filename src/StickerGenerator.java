import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import java.util.Map;
import java.util.HashMap;

public class StickerGenerator {
    
    public void generate(InputStream stream, String filename) throws IOException {
        //leitura da imagem
        // InputStream inputStream = new FileInputStream(new File("img/cover.jpg"));
        // InputStream inputStream = new URL("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_8.jpg").openStream();
        BufferedImage original = ImageIO.read(stream);
        // cria nova imagem em memória com transparência e tamanho novo
        int width = original.getWidth();
        int height = original.getHeight();
        int newHeight = (int)((double)height * 1.15); 
        System.out.println(newHeight);
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
        // copiar a imagem original para a nova imagem
        // escrever meme
        // escrever nova imagem em um arquivo
        Graphics2D graphics = (Graphics2D)newImage.getGraphics();
        graphics.drawImage(original, null, 0, 0);
        Map<String,Integer> tuple = StickerGenerator.getCenteredStartingPoint(width, newHeight);
        //configurar fonte
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 256));
        graphics.setColor(Color.MAGENTA);
        graphics.drawString("MEH", tuple.get("x"), tuple.get("y"));
        String coverFilename = String.format("img/%s.png", filename);
        ImageIO.write(newImage, "png", new File(coverFilename));
        System.out.println(coverFilename);
    }

    private static Map<String,Integer> getCenteredStartingPoint(int width, int newHeight) {
        int x = (int)(0.60 * (width / 2.0));
        int originalHeight = (int)(0.85 * newHeight);
        int y = (int)(originalHeight + 0.65 * (newHeight - originalHeight));

        Map<String,Integer> tuple = new HashMap<String,Integer>();
        tuple.put("x", x);
        tuple.put("y", y);
        return tuple;
    }
}
