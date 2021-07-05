package project.entities;

import de.gurkenlabs.litiengine.entities.CollisionInfo;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.entities.EntityInfo;
import de.gurkenlabs.litiengine.entities.MovementInfo;
import project.input.KeyboardEntityController;

@EntityInfo(width = 132, height = 140)
@MovementInfo(velocity = 100)
@CollisionInfo(collisionBoxWidth = 132, collisionBoxHeight = 140, collision = true)
public class Player extends Creature {

    public Player() {
        super("player");
        setVisible(true);
        KeyboardEntityController<Player> keyboard = new KeyboardEntityController<>(this);
        addController(keyboard);
        //addEntityRenderListener(new PlayerRenderListener());
    }
}
