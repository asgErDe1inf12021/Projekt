package project;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;
import de.gurkenlabs.litiengine.sound.Sound;
import project.entities.Player;
import project.logic.GameState;
import project.save.api.Api;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.util.function.Supplier;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException {
        Api.Api = new project.save.implementation.Api();
        Game.addGameListener(new GameState());
        Game.init(args);
        Game.world().loadEnvironment("stoneMap.tmx");
        Game.world().camera().setClampToMap(true);
        Game.window().setTitle("The Game without a name");
        AudioInputStream stream = AudioSystem.getAudioInputStream(new File("C:\\Users\\Jansp\\Documents\\GitHub\\Projekt\\src\\main\\resources\\wii-shop-music.mp3"));
        Game.audio().createSound(new Sound(stream, "m1"), new Supplier<Point2D>() {
            @Override
            public Point2D get() {
                return new Point2D.Double(0,0);
            }
        }, true, 0, 1);
        // Game.world().getEnvironment("stoneMap.tmx"). // useful for reading data from tmx
        Game.start();
        Game.audio().playMusic("m1");
        Resources.spritesheets().add("player-idle-down", Resources.spritesheets().load("Player_Model_1.png", 132, 140));
        Resources.spritesheets().add("bush-idle-down", Resources.spritesheets().load("bush-angry.png", 36, 39));
        Game.world().environment().add(new Player());
    }
}