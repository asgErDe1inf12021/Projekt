package project.render;

import de.gurkenlabs.litiengine.Align;
import de.gurkenlabs.litiengine.Valign;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuScreen extends Screen {


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

        g.setFont(new Font(Font.SERIF,Font.PLAIN,60));
        TextRenderer.render(g,"Title", Align.CENTER, Valign.TOP,0,50);

        Button newGame = new Button("New Game");
        newGame.setBounds((int) this.getWidth()/2, 200, 800,200);
        newGame.addActionListener(newGameListener);
        //wie render???


    }

    @Override
    protected void initializeComponents() {
        // This method is called once by the Screen's constructor. Use it to initialize the GuiComponents that will be contained by this screen.
        // Don't forget to call this.getComponents().add(GuiComponent c) so that the components will actually be rendered.

        JFrame menuFrame;

        super.initializeComponents();
    }
}
