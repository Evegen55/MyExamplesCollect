package other_examples;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * @version 1.33 2007-04-14
 * @author Cay Horstmann
 */
public class FontTestMy
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            public void run()
            {
               JFrame frame = new FontFrame();
               frame.setTitle("FontTest");
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            }
         });
   }
}

/**
 * A frame with a text message component
 */
class FontFrameMy extends JFrame
{
   public FontFrameMy()
   {      
      add(new FontComponent());
      pack();
   }
}

/**
 * A component that shows a centered message in a box.
 */
class FontComponentMy extends JComponent
{
   private static final int DEFAULT_WIDTH = 300;
   private static final int DEFAULT_HEIGHT = 200;
   
   private final String URL_font = "http://www.fonts.com/Wingbats.ttf";

   
   @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        try {
            URL url = new URL (URL_font);
            InputStream in = url.openStream();
            Font F1 = Font.createFont(Font.TRUETYPE_FONT, in);
            Font dF = F1.deriveFont(14.0F);
            g2.setFont(dF);
            String message = "Font from Internet";
            g2.drawString(message, 75, 100);
        } catch (MalformedURLException ex) {
            Logger.getLogger(FontComponentMy.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | FontFormatException ex) {
           Logger.getLogger(FontComponentMy.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
   
   @Override
   public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}
