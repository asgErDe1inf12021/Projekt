package project.entities;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.IUpdateable;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Block implements IUpdateable {
    private Graphics2D g;
    private Rectangle2D rect;
    private Double x;
    private Double y;

    public Block(Graphics2D g) {
        this.g = g;
        x = 0.0;
        y = 0.0;

        rect = new Rectangle2D.Double(50, 100, 50, 50);
        Game.loop().attach(this);
    }

    @Override
    public void update() {
        Game.graphics().renderShape(g, rect);
    }
}
