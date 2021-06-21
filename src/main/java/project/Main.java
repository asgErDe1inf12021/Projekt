package project;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.GameListener;

public class Main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Game.addGameListener(new GameListener() {
            @Override
            public void initialized(String... args) {
                // do sth when game is initialized
            }
            @Override
            public void started() {
                // do sth when game started
            }

            @Override
            public void terminated() {
                // do sth when game terminated
            }
        });
        Game.init(args);
        Game.start();
    }
}
