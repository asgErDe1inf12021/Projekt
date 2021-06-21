package project.render;

import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;

import java.awt.*;

public class TestScreen extends GameScreen {
    public TestScreen() {
        super("TEST");
    }

    @Override
    public void render(final Graphics2D g) {
        super.render(g);
        g.setFont(g.getFont().deriveFont(50f));
        g.setColor(Color.white);
        TextRenderer.render(g, "Test text", 100, 100);
    }
}
