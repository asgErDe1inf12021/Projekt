package project;

import de.gurkenlabs.litiengine.Game;
import project.save.api.Api;
import project.database.Database;
import project.logic.GameState;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Api.Api = new project.save.implementation.Api();
        Game.addGameListener(new GameState());
        Game.init(args);
        Game.world().loadEnvironment("test.tmx");
        Game.start();
        Database db = new Database();
        Game.world().camera().pan(10000, 10000, 1000);
    }
}
