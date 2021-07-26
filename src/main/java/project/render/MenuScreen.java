package project.render;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import project.save.api.SaveState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuScreen extends Screen implements ActionListener {

    static Font font = new Font(Font.DIALOG, Font.BOLD, 50);

    JButton newGame;
    JButton loadGame;
    JButton settings;
    JFrame frame;


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
        frame.update(g);
    }

    @Override
    protected void initializeComponents() {
        // This method is called once by the Screen's constructor. Use it to initialize the GuiComponents that will be contained by this screen.
        // Don't forget to call this.getComponents().add(GuiComponent c) so that the components will actually be rendered.

        frame = new JFrame();
        frame.setSize(1920, 1080);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());
        frame.setVisible(true);

        JLabel title = new JLabel("..Title..");
        title.setFont(font);
        //title.setBounds(frame.getContentPane().getWidth() / 2 - 300, 100, 600, 100);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setForeground(Color.decode("#00D115"));

        newGame = new JButton("New Game");
        //newGame.setBounds(frame.getContentPane().getWidth() / 2 - 300, 300, 600, 100);
        newGame.addActionListener(this);
        newGame.setFont(font);
        newGame.setBackground(Color.black);
        newGame.setForeground(Color.decode("#00D115"));
        newGame.setFocusable(false);

        loadGame = new JButton("Load Game");
        //loadGame.setBounds(frame.getContentPane().getWidth() / 2 - 300, 500, 600, 100);
        loadGame.addActionListener(this);
        loadGame.setFont(font);
        loadGame.setBackground(Color.black);
        loadGame.setForeground(Color.decode("#00D115"));
        loadGame.setFocusable(false);

        settings = new JButton("Settings");
        //settings.setBounds(frame.getContentPane().getWidth() / 2 - 300, 700, 600, 100);
        settings.addActionListener(this);
        settings.setFont(font);
        settings.setBackground(Color.black);
        settings.setForeground(Color.decode("#00D115"));
        settings.setFocusable(false);

        frame.add(title);
        frame.add(newGame);
        frame.add(loadGame);
        frame.add(settings);

        frame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newGame) {
            SaveState.newGame("SaveName");
        } else if (e.getSource() == loadGame) {
            SaveState.continueGame("SaveName");
        } else if (e.getSource() == settings) {
            return;
        }
        SaveState.getInstance().initGame();
        Game.start();
        frame.dispose();
    }
}
