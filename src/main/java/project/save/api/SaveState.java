package project.save.api;

import de.gurkenlabs.litiengine.Game;
import project.entities.Player;

public class SaveState {

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
        Api.Api.registerObject("test", (Api.SerializableFactory<?>) player);
        Api.Api.readObject(Api.Api.saveObject(player));
    }
}
