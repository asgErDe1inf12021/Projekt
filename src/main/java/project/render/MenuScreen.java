package project.render;

import de.gurkenlabs.litiengine.Align;
import de.gurkenlabs.litiengine.Valign;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.GuiComponent;
import de.gurkenlabs.litiengine.gui.TextFieldComponent;
import de.gurkenlabs.litiengine.gui.screens.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuScreen extends Screen {

    TextFieldComponent newGame;

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

        if(newGame.isPressed()){
            System.out.println("Clicked!!!");
        }

    }

    @Override
    protected void initializeComponents() {
        // This method is called once by the Screen's constructor. Use it to initialize the GuiComponents that will be contained by this screen.
        // Don't forget to call this.getComponents().add(GuiComponent c) so that the components will actually be rendered.

        newGame = new TextFieldComponent(0,0,600,100,"New Game");
        super.initializeComponents();
        this.getComponents().add(newGame);

    }
}
