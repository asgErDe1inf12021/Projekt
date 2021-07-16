package project.render;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import project.database.Database;

import java.awt.*;

public class TestScreen extends GameScreen {
    Database database = new Database();


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

        if(database.getScore() > database.getHighscore(database.getCurrentUser())) {
            TextRenderer.render(g, "Highscore: " + database.getScore(), 185, 15);
        } else {
            TextRenderer.render(g, "Highscore: " + database.getHighscore(database.getCurrentUser()),185,15);
        }
    }
}
