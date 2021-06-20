package graphic;
import java.awt.*;
import javax.swing.*;

public class View extends JFrame{
    public static void main(String args[]){
        View frame=new View();
        frame.setTitle("namenloses Spiel");
        frame.setSize(1000, 620);
        frame.setResizable(false);
        frame.setLocation(50, 50);
        frame.setVisible(true);
    }
}
