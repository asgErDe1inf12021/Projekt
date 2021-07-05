package project.render;

import de.gurkenlabs.litiengine.entities.EntityRenderEvent;
import de.gurkenlabs.litiengine.entities.EntityRenderListener;

import java.awt.*;

public class PlayerRenderListener implements EntityRenderListener {
    @Override
    public void rendered(EntityRenderEvent event) {
        event.getGraphics().setColor(Color.BLUE);
        event.getGraphics().drawRect((int) event.getEntity().getX(), (int) event.getEntity().getY(), 10, 10);
    }
}
