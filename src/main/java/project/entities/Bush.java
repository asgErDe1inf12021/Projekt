package project.entities;

import de.gurkenlabs.litiengine.Valign;
import de.gurkenlabs.litiengine.entities.CollisionInfo;
import de.gurkenlabs.litiengine.entities.Creature;

@CollisionInfo(collisionBoxWidth = 24, collisionBoxHeight = 8, collision = true, valign = Valign.MIDDLE_DOWN)
public class Bush extends Creature {
    public Bush() {
        super("bush");
        setLocation(100, 100);
    }
}
