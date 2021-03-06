package project.entities;

import de.gurkenlabs.litiengine.Align;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.Valign;
import de.gurkenlabs.litiengine.entities.CollisionInfo;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.entities.EntityInfo;
import de.gurkenlabs.litiengine.entities.MovementInfo;
import project.input.KeyboardEntityController;
import project.save.api.Api;
import project.save.api.Serializable;
import project.save.api.Storage;

import java.util.HashMap;

@EntityInfo(width = 36, height = 39)
@MovementInfo(velocity = 100)
@CollisionInfo(collisionBoxWidth = 36, collisionBoxHeight = 39, collision = true, align = Align.CENTER, valign = Valign.MIDDLE)
public class Player extends Creature implements Serializable {

    public Player() {
        super("bush");
        this.setLocation(300,150);
        Game.world().camera().setFocus(300, 150);
        setVisible(true);
        addController(new KeyboardEntityController<>(this));
    }

    public Player(HashMap<String, Storage> from) {
        this();
        Storage X = from.get("x");
        Storage Y = from.get("y");
        setLocation((Double) X.read(), (Double) Y.read());
        Game.world().camera().setFocus(getLocation());
    }

    @Override
    public HashMap<String, Storage> serialize() {
        HashMap<String, Storage> map = new HashMap<>();
        map.put("x", Api.Api.saveDouble(getLocation().getX()));
        map.put("y", Api.Api.saveDouble(getLocation().getY()));
        return map;
    }

    @Override
    public String getClassName() {
        return "player";
    }
}
