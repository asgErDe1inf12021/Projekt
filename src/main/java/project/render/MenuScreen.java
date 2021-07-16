package project.render;

import de.gurkenlabs.litiengine.GameListener;
import de.gurkenlabs.litiengine.gui.screens.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class MenuScreen extends Screen {

    private double height;
    private double width;

    private ActionListener newGameListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

    private ActionListener loadGameListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

    private ActionListener settingsListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    };

    public MenuScreen() {
        super("MENU");
    }

    @Override
    public void prepare() {
        // This method will be called right before the screen is displayed
        super.prepare();
    }

    @Override
    public void render(Graphics2D g) {
        // This method is called on every tick and lets you draw shapes, text, images etc. explicitly.
        // Calling super.render(g) also renders all GuiComponents in this.getComponents()
        super.render(g);
    }

    @Override
    protected void initializeComponents() {
        // This method is called once by the Screen's constructor. Use it to initialize the GuiComponents that will be contained by this screen.
        // Don't forget to call this.getComponents().add(GuiComponent c) so that the components will actually be rendered.

        this.width = 1920;
        this.height = 1080;

        JFrame menuFrame = new JFrame("Main Menu");
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setSize(1920,1080);
        menuFrame.setLayout(null);

        JLabel title = new JLabel("...Title...");
        title.setBounds(960-350,100,700,100);
        title.setFont(new Font(Font.SERIF,Font.PLAIN,100));

        JButton newGame = new JButton("New Game");
        newGame.setBounds(960 - 350, 300,700,100);
        newGame.addActionListener(newGameListener);

        JButton loadGame = new JButton("Load Game");
        loadGame.setBounds(960-350, 500,700,100);
        loadGame.addActionListener(loadGameListener);

        JButton settings = new JButton("Settings");
        settings.setBounds(960 - 350, 700,700,100);
        settings.addActionListener(settingsListener);

        menuFrame.add(title);
        menuFrame.add(newGame);
        menuFrame.add(loadGame);
        menuFrame.add(settings);

        menuFrame.setVisible(true);

        super.initializeComponents();
    }
}
