package project;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.GameListener;
import project.logic.GameState;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Game.addGameListener(new GameState());
        Game.init(args);
        Game.start();
    }
}
