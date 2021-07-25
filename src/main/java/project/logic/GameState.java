package project.logic;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.GameListener;
import project.database.Database;
import project.render.TestScreen;
import project.save.api.Api;
import project.save.api.SaveState;

public class GameState implements GameListener {

    public GameState(){}

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
        SaveState.getInstance().saveGame();
        return true;
    }

    @Override
    public void terminated() {
        // code
    }
}
