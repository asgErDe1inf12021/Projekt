package project;

import de.gurkenlabs.litiengine.Game;
import project.config.api.Api;
import project.database.Database;
import project.logic.GameState;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Api.Api = new project.config.implementation.Api();
        Game.addGameListener(new GameState());
        Game.init(args);
        Game.start();
        //Database db = new Database();
    }
}
