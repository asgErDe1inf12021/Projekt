package project.entities;

import de.gurkenlabs.litiengine.Align;
import de.gurkenlabs.litiengine.Valign;
import de.gurkenlabs.litiengine.entities.CollisionInfo;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.entities.EntityInfo;
import de.gurkenlabs.litiengine.entities.MovementInfo;
import project.input.KeyboardEntityController;

@EntityInfo(width = 132, height = 140)
@MovementInfo(velocity = 100)
@CollisionInfo(collisionBoxWidth = 132/4, collisionBoxHeight = 140/4, collision = true, align = Align.CENTER, valign = Valign.MIDDLE)
public class Player extends Creature {

    public Player() {
        super("player");
        setVisible(true);
        animations().scaleSprite(0.25F);
        KeyboardEntityController<Player> keyboard = new KeyboardEntityController<>(this);
        addController(keyboard);
    }
}
