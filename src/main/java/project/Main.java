package project;

import de.gurkenlabs.litiengine.Game;
import project.save.api.Api;
import project.logic.GameState;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Api.Api = new project.save.implementation.Api();
        Game.addGameListener(new GameState());
        Game.init(args);
        Game.start();
    }
}
