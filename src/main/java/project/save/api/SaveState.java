package project.save.api;

import de.gurkenlabs.litiengine.Game;
import project.entities.Player;
import project.save.sql.sqlite.SqliteApi;
import project.save.sql.storage.ObjectStorage;

import java.util.HashMap;

public class SaveState implements Serializable {

    private static SaveState Instance;
    private final String id;
    private Player player;

    private SaveState(String id) {
        this.id = id;
    }

    public static void newGame() {
        Instance = new SaveState(IdentifierProvider.newIdentifier());
        Instance.player = new Player();
    }

    public static void continueGame(String id) {
        Instance = new SaveState(id);
        Instance.player = new Player();//TODO load from database
    }

    public void initGame() {
        Game.world().environment().add(player);
    }

    public static SaveState getInstance() {
        return Instance;
    }

    public void saveGame() {
        ((SqliteApi) Api.Api).saveObjectToDB("", id, (ObjectStorage) Api.Api.saveObject(this));
    }

    @Override
    public HashMap<String, Storage> serialize() {
        HashMap<String, Storage> map = new HashMap<>();
        map.put("player", Api.Api.saveObject(player));
        return map;
    }

    @Override
    public String getIdentifier() {
        return id;
    }

    @Override
    public String getClassName() {
        return "saveState";
    }
}
