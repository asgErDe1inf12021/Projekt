package project.logic;

import project.save.api.Api;
import project.save.api.Serializable;
import project.save.api.Storage;

import java.util.HashMap;

public class Score implements Serializable {

    public static Score SCORE;
    private int score;
    private static int highScore;

    public int getScore() {
        updateScore();
        return score;
    }

    public static int getHighScore() {
        return highScore;
    }

    private void updateScore() {
        score++;
        updateHighScore();
    }

    public Score(HashMap<String, Storage> from) {
        score = (int) from.get("score").read();
    }

    public Score() {
        score = 0;
    }

    private void updateHighScore() {
        if (score > highScore) highScore = score;
    }

    @Override
    public HashMap<String, Storage> serialize() {
        HashMap<String, Storage> map = new HashMap<>();
        map.put("score", Api.Api.saveInt(score));
        return map;
    }

    @Override
    public String getClassName() {
        return "score";
    }
}
