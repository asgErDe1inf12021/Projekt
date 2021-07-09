package project.database;

import java.sql.*;

public class Database {

    static int score;
    static int highscore;
    static String currentUser;

    public Database() {
        score = 0;
        currentUser = "Nick";
        getHighscore(currentUser);
        updateHighscore(currentUser);
        updateScore(1);
    }

    public Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection("JDBC:sqlite:gameDb.db");
            System.out.println("Connected!");
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getHighscore(String user) {
        try {
            Connection con = connect();
            Statement stm = con.createStatement();
            String sql = "SELECT Highscore FROM Scores WHERE User = '"+user+"'";
            ResultSet res = stm.executeQuery(sql);

            highscore = res.getInt(1);

            res.close();
            stm.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("User nicht vorhanden!");
        }
        return highscore;
    }

    public void updateHighscore(String User) {
        try {
            if (score > getHighscore(User)) {
                Connection con = connect();
                Statement stm = con.createStatement();
                String sql = "UPDATE Scores SET Highscore = '" + score + "' WHERE User = '" + User + "'";
                stm.executeQuery(sql);

                stm.close();
                con.close();
            } else {
                score = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertUser(String username) {
        try {
            Connection con = connect();
            Statement stm = con.createStatement();
            String sql = "INSERT INTO Scores(User) VALUES('" + username +"')";
            stm.executeQuery(sql);

            stm.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getScore(){
        updateScore(1);
        return score;
    }

    public static void updateScore(int add){
        score = score + add;
    }

    public void selectUser() {

    }
}

