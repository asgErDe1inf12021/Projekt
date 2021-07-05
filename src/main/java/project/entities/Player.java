package project.entities;

import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.entities.EntityInfo;
import project.input.KeyboardEntityController;

@EntityInfo(width = 132, height = 140)
public class Player extends Creature {

    public Player() {
        super("player.tsx");
        setMapId(0);
        setVisible(true);
        KeyboardEntityController<Player> keyboard = new KeyboardEntityController<>(this);
        addController(keyboard);
        //addEntityRenderListener(new PlayerRenderListener());
    }
}
