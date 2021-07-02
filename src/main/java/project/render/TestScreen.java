package project.render;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import project.entities.Block;

import java.awt.*;

public class TestScreen extends GameScreen {
    public TestScreen() {
        super("TEST");
    }

    @Override
    public void render(final Graphics2D g) {
        Block b = new Block(g);
        super.render(g);
        g.setColor(Color.white);
        TextRenderer.render(g, ""+Game.loop().getTickRate(), 5, 15);
    }
}
