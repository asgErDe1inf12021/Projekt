package project.logic;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.GameListener;
import project.database.Database;
import project.render.MenuScreen;
import project.render.TestScreen;

public class GameState implements GameListener {

    static Database database;

    public GameState(){
        database = new Database();
    }

    @Override
    public void initialized(String... args) {
        Game.setInfo("gameInfo.xml");
    }

    @Override
    public void started() {
        Game.screens().add(new MenuScreen());
        //Game.screens().add(new TestScreen());
    }

    @Override
    public boolean terminating() {
        database.updateHighscore(database.getCurrentUser(),database.getScore());
        return true;
    }

    @Override
    public void terminated() {
        // code
    }
}
