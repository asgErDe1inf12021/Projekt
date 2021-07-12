package project;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;
import project.entities.Player;
import project.logic.GameState;
import project.save.api.Api;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Api.Api = new project.save.implementation.Api();
        Game.addGameListener(new GameState());
        Game.init(args);
        Game.world().loadEnvironment("Stone-Map.tmx");
        Game.start();
        Resources.spritesheets().add("player-idle-down", Resources.spritesheets().load("Player_Model_1.png", 132, 140));
        Resources.spritesheets().add("bush-idle-planted", Resources.spritesheets().load("bush-angry.png", 36, 39));
        Game.world().environment().add(new Player());
        //Game.world().camera().pan(10000, 10000, 1000);
    }
}