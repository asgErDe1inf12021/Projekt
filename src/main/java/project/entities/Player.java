package project.entities;

import de.gurkenlabs.litiengine.Align;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.Valign;
import de.gurkenlabs.litiengine.entities.CollisionInfo;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.entities.EntityInfo;
import de.gurkenlabs.litiengine.entities.MovementInfo;
import project.input.KeyboardEntityController;

@EntityInfo(width = 36, height = 39)
@MovementInfo(velocity = 100)
@CollisionInfo(collisionBoxWidth = 36, collisionBoxHeight = 39, collision = true, align = Align.CENTER, valign = Valign.MIDDLE)
public class Player extends Creature {

    public Player() {
        super("bush");
        this.setLocation(300,150);
        Game.world().camera().setFocus(300, 150);
        setVisible(true);
        KeyboardEntityController<Player> keyboard = new KeyboardEntityController<>(this);
        addController(keyboard);
    }
}
