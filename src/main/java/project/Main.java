package project;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.environment.tilemap.xml.Tileset;
import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.resources.Resources;
import project.entities.Player;
import project.logic.GameState;
import project.save.api.Api;

import java.awt.image.BufferedImage;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Api.Api = new project.save.implementation.Api();
        Game.addGameListener(new GameState());
        Game.init(args);
        Game.world().loadEnvironment("test.tmx");
        Game.start();
        Resources.load("player.tsx");
        Game.world().environment().add(new Player());
        //Game.world().camera().pan(10000, 10000, 1000);
    }
}
