package graphic;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class View extends JFrame{
    private static final String img1Path = "src/images/img1.jpg";

    public static void main(String args[]){
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {
            // handle exception
        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }
        View frame=new View();
        frame.setTitle("namenloses Spiel");
        frame.setSize(1000, 620);
        frame.setResizable(false);
        frame.setLocation(50, 50);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
        JButton b = new JButton();
        b.setText("OK");
        b.setSize(100, 50);
        frame.add(b);
        try {
            BufferedImage img1 = ImageIO.read(new File(img1Path));
            ImageIcon ic1 = new ImageIcon(img1);
            JLabel label = new JLabel(ic1);
            label.setSize(100,100);
            JOptionPane.showMessageDialog(null, label);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
