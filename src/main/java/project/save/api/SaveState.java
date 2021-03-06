package project.save.api;

import de.gurkenlabs.litiengine.Game;
import project.entities.Player;
import project.logic.Score;
import project.save.sql.SqlApi;
import project.save.sql.sqlite.SqliteApi;
import project.save.sql.storage.ObjectStorage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SaveState implements Serializable {

    private static SaveState Instance;
    private final String id;
    private Player player;

    private SaveState(String id) {
        this.id = id;
    }

    public static void newGame(String name) {
        Instance = new SaveState(name);
        Instance.player = new Player();
        Score.SCORE = new Score();
        loadHighScore();
    }

    public static void continueGame(String id) {
        Instance = new SaveState(id);
        Instance.player = (Player) ((SqliteApi) Api.Api).loadObject(id + ".player");
        Score.SCORE = (Score) ((SqliteApi) Api.Api).loadObject(id + ".score");
        loadHighScore();
    }

    private static void loadHighScore() {
        try {
            ResultSet resultSet = SqlApi.connection().createStatement().executeQuery("SELECT data FROM PrimitiveStorage WHERE Identifier ='HIGHSCORE'");
            if (resultSet.next()) {
                Score.setHighScore(Integer.parseInt(resultSet.getString("data")));
            }
        } catch (SQLException ignored) {
        }
    }

    public void initGame() {
        Game.world().environment().add(player);
    }

    public static SaveState getInstance() {
        return Instance;
    }

    public static List<String> getSaves() {
        List<String> saves = new ArrayList<>();
        try {
            ResultSet resultSet = SqlApi.connection().createStatement().executeQuery("SELECT storedObject FROM ObjectStorageLink WHERE Identifier ='Saves'");
            while (resultSet.next()) {
                saves.add(resultSet.getString("storedObject"));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("failed to load Saves");
        }
        return saves;
    }

    public void saveGame() {
        ((SqliteApi) Api.Api).saveObjectToDB("Saves", id, (ObjectStorage) Api.Api.saveObject(this));
        saveHighScore();
    }

    public static void saveHighScore() {
        try {
            SqlApi.connection().createStatement().execute("REPLACE INTO PrimitiveStorage(Identifier, type, data) VALUES('HIGHSCORE', 'Integer', '"+Score.getHighScore()+"')");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalStateException("failed save HighScore");
        }
    }

    @Override
    public HashMap<String, Storage> serialize() {
        HashMap<String, Storage> map = new HashMap<>();
        map.put("player", Api.Api.saveObject(player));
        map.put("score", Api.Api.saveObject(Score.SCORE));
        return map;
    }

    @Override
    public String getClassName() {
        return "saveState";
    }
}
