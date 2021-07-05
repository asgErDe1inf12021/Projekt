package project.database;

import java.sql.*;

public class Database {

    int score = 0;
    int highscore;
    String currentUser;

    public Database() {

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

    public int getHighscore(String User) {
        try {
            Connection con = connect();
            Statement stm = con.createStatement();
            String sql = "SELECT Highscore FROM Scores WHERE User = " + User;
            ResultSet res = stm.executeQuery(sql);

            highscore = res.getInt("Highscore");

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
            if (score > getHighscore(currentUser)) {
                Connection con = connect();
                Statement stm = con.createStatement();
                String sql = "UPDATE Highscore FROM Scores WHERE User = " + User;
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
            String sql = "INSERT INTO Scores(User) VALUES(" + username + ", 0)";
            stm.executeQuery(sql);

            stm.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectUser() {

    }
}

