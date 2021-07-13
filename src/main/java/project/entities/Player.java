package project.entities;

import de.gurkenlabs.litiengine.Align;
import de.gurkenlabs.litiengine.Valign;
import de.gurkenlabs.litiengine.entities.CollisionInfo;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.entities.EntityInfo;
import de.gurkenlabs.litiengine.entities.MovementInfo;
import project.input.KeyboardEntityController;

@EntityInfo(width = 33, height = 35)
@MovementInfo(velocity = 100)
@CollisionInfo(collisionBoxWidth = 33, collisionBoxHeight = 35, collision = true, align = Align.CENTER, valign = Valign.MIDDLE)
public class Player extends Creature {

    public Player() {
        super("player");
        KeyboardEntityController<Player> keyboard = new KeyboardEntityController<>(this);
        addController(keyboard);
    }
}
