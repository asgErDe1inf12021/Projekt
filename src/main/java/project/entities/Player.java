package project.entities;

import de.gurkenlabs.litiengine.Align;
import de.gurkenlabs.litiengine.Valign;
import de.gurkenlabs.litiengine.entities.CollisionInfo;
import de.gurkenlabs.litiengine.entities.Creature;
import de.gurkenlabs.litiengine.entities.EntityInfo;
import de.gurkenlabs.litiengine.entities.MovementInfo;
import project.input.KeyboardEntityController;
import project.save.api.Api;
import project.save.api.IdentifierProvider;
import project.save.api.Serializable;
import project.save.api.Storage;

import java.util.HashMap;

@EntityInfo(width = 33, height = 35)
@MovementInfo(velocity = 100)
@CollisionInfo(collisionBoxWidth = 33, collisionBoxHeight = 35, collision = true, align = Align.CENTER, valign = Valign.MIDDLE)
public class Player extends Creature implements Serializable {
    private final String Identifier;

    public Player(String Identifier) {
        super("player");
        this.Identifier = Identifier;
        KeyboardEntityController<Player> keyboard = new KeyboardEntityController<>(this);
        addController(keyboard);
    }

    public Player(HashMap<String, Storage> from) {
        this((String) from.get("Identifier").read());
        Storage X = from.get("x");
        Storage Y = from.get("y");
        setLocation((Double) X.read(), (Double) Y.read());
    }

    public Player() {
        this(IdentifierProvider.newIdentifier());
    }

    @Override
    public HashMap<String, Storage> serialize() {
        HashMap<String, Storage> map = new HashMap<>();
        map.put("X", Api.Api.saveDouble(getLocation().getX()));
        map.put("Y", Api.Api.saveDouble(getLocation().getY()));
        map.put("Identifier", Api.Api.saveString(Identifier));
        return map;
    }

    @Override
    public String getIdentifier() {
        return Identifier;
    }

    @Override
    public void load(HashMap<String, Storage> from) {
        Storage X = from.get("x");
        Storage Y = from.get("y");
        setLocation((Double) X.read(), (Double) Y.read());
    }
}
