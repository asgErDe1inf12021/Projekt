package project;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;
import project.entities.Player;
import project.logic.GameState;
import project.logic.Score;
import project.save.api.Api;
import project.save.api.SaveState;
import project.save.sql.sqlite.SqliteApi;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Api.Api = new SqliteApi("gameDb.db");
        registerSerializables();

        Game.addGameListener(new GameState());
        Game.init(args);
        Game.world().loadEnvironment("stoneMap.tmx");
        Game.world().camera().setClampToMap(true);
        Game.window().setTitle("The game without a name");
        // Game.world().getEnvironment("stoneMap.tmx"). // useful for reading data from tmx
        Resources.spritesheets().add("player-idle-down", Resources.spritesheets().load("Player_Model_1.png", 22, 35));
        Resources.spritesheets().add("bush-idle-down", Resources.spritesheets().load("bush-angry.png", 36, 39));

        SaveState.continueGame("SaveName");//would be selected from menu
        //SaveState.newGame("SaveName");
        SaveState.getInstance().initGame();
        Game.start();
    }

    public static void registerSerializables() {
        Api.Api.registerObject("player", Player::new);
        Api.Api.registerObject("score", Score::new);
    }
}