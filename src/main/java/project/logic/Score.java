package project.logic;

public class Score {
    private static int score;
    private static int highScore;

    public static int getScore() {
        updateScore();
        return score;
    }

    public static int getHighScore() {
        updateHighScore();
        return highScore;
    }

    private static void updateScore() {
        score++;
        updateHighScore();
    }

    private static void updateHighScore() {
        if(score>highScore) highScore = score;
    }
}
