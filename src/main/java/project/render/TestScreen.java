package project.render;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import project.logic.Score;

import java.awt.*;

public class TestScreen extends GameScreen {

    public TestScreen() {
        super("TEST");
    }

    @Override
    public void render(final Graphics2D g) {
        super.render(g);
        g.setColor(Color.white);
        TextRenderer.render(g, "" + Game.loop().getTickRate(), 5, 15);

        //Score Anzeige
        TextRenderer.render(g, "Score: " + Score.SCORE.getScore(), 100, 15);
        TextRenderer.render(g, "Highscore: " + Score.getHighScore(), 185, 15);
    }
}
