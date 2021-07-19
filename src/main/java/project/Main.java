package project;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;
import project.logic.GameState;
import project.save.api.Api;
import project.save.api.SaveState;
import project.save.sql.sqlite.SqliteApi;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Api.Api = new SqliteApi("gameDb.db");
        Game.addGameListener(new GameState());
        Game.init(args);
        Game.world().loadEnvironment("Stone-Map.tmx");
        Game.start();
        Resources.spritesheets().add("player-idle-down", Resources.spritesheets().load("Player_Model_1.png", 33, 35));
        Resources.spritesheets().add("bush-idle-planted", Resources.spritesheets().load("bush-angry.png", 36, 39));
        SaveState.newGame();
        SaveState.getInstance().initGame();
        SaveState.getInstance().saveGame();
    }
}