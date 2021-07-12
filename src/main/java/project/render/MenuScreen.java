package project.render;

import de.gurkenlabs.litiengine.gui.screens.Screen;

import javax.swing.*;
import java.awt.*;

public class MenuScreen extends Screen {

    private double height;
    private double width;

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

        this.width = this.getWidth();
        this.height = this. getHeight();

        JFrame menuFrame = new JFrame("Main Menu");
        menuFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        menuFrame.setSize((int) width,(int) height);
        menuFrame.setLayout(null);


        super.initializeComponents();
    }
}
