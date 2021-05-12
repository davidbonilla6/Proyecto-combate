import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImageComponent extends JPanel{
private BufferedImage image;
    
    ImageComponent(String urlFoto){
        try {
            image = ImageIO.read(new File("foto.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void paint(Graphics g) {

        
          Graphics2D g2d = (Graphics2D)g;
          int x = 0; 
          int y = 0;
          g2d.drawImage(image.getScaledInstance(getWidth(), getHeight(), image.SCALE_SMOOTH), x, y, this);
         
    }
    public void setImage(String urlFoto) {
        System.out.println("establecemos en el panel la foto "+"foto.jpg");
        try {
            this.image = ImageIO.read(new File(urlFoto));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();
    }
}
