package project.database;

import project.render.TestScreen;

import java.sql.*;

public class Database {

    static int score;
    static int highscore;
    static String currentUser;

    public Database() {
        score = 0;
        currentUser = selectUser();
        getHighscore(currentUser);
        updateHighscore(currentUser);
    }

    public static Connection connect() {
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

    public static int getHighscore(String username) {
        try {
            Connection con = connect();
            Statement stm = con.createStatement();
            String sql = "SELECT Highscore FROM Scores WHERE User = '"+username+"'";
            ResultSet res = stm.executeQuery(sql);

            highscore = res.getInt(1);

            res.close();
            stm.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("User nicht vorhanden!");
        }
        return highscore;
    }

    public static void updateHighscore(String username) {
        try {
            if (score > getHighscore(username)) {
                Connection con = connect();
                Statement stm = con.createStatement();
                String sql = "UPDATE Scores SET Highscore = '" + score + "' WHERE User = '" + username + "'";
                stm.execute(sql);

                stm.close();
                con.close();
            } else {
                score = 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertUser(String username) {
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

    public static String getCurrentUser(){
        return currentUser;
    }

    public static void updateScore(int add){
        score = score + add;
    }

    public static String selectUser() {
        return "Nick";
    }
}

