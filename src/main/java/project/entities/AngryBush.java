package project.entities;

import de.gurkenlabs.litiengine.Valign;
import de.gurkenlabs.litiengine.entities.CollisionInfo;
import de.gurkenlabs.litiengine.entities.Creature;

@CollisionInfo(collisionBoxWidth = 24, collisionBoxHeight = 39, collision = true, valign = Valign.MIDDLE)
public class AngryBush extends Creature {
    public AngryBush() {
        super("bush-angry");
        setLocation(200, 100);
    }
}
