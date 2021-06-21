package project;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.GameListener;
import project.logic.GameState;
import project.config.api.Api;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Api.Api = new project.config.implementation.Api();
        Game.addGameListener(new GameState());
        Game.init(args);
        Game.start();
    }
}
