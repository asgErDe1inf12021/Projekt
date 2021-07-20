package project.render;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import project.database.Database;

import java.awt.*;

public class TestScreen extends GameScreen {

    public TestScreen() {
        super("TEST");
    }

    @Override
    public void render(final Graphics2D g) {
        super.render(g);
        g.setColor(Color.white);
        TextRenderer.render(g, ""+Game.loop().getTickRate(), 5, 15);

        //Score Anzeige
        TextRenderer.render(g,"Score: " + Database.getScore(),100,15);

        if(Database.getScore() > Database.getHighscore(Database.getCurrentUser())) {
            TextRenderer.render(g, "Highscore: " + Database.getScore(), 185, 15);
        } else {
            TextRenderer.render(g, "Highscore: " + Database.getHighscore(Database.getCurrentUser()),185,15);
        }
    }
}
