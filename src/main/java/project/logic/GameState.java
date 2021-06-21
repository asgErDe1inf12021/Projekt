package project.logic;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.GameListener;
import project.render.TestScreen;

public class GameState implements GameListener {
    @Override
    public void initialized(String... args) {
        Game.setInfo("gameInfo.xml");
    }

    @Override
    public void started() {
        Game.screens().add(new TestScreen());
    }

    @Override
    public boolean terminating() {
        return true;
    }

    @Override
    public void terminated() {
        // code
    }
}
