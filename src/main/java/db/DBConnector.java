package main.java.db;

import main.java.business.kunde.Kunde;

import java.sql.*;

public class DBConnector {
    private static final String DB_URL = "jdbc:mysql://url/dbname";

    private static final String USER = "username";
    private static final String PASS = "password";

    public boolean hatDachgeschoss(int planNummer) {
        boolean hatDachgeschoss = false;

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT Dachgeschoss FROM Bauplan WHERE Plannummer=" + planNummer;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                hatDachgeschoss = rs.getBoolean("Dachgeschoss");
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException ignored) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return hatDachgeschoss;
    }

    public void kundenSpeichern(String vorname, String nachname, String telefonnummer, String email) {

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO Kunden (Vorname, Nachname, Telefonnummer, E-Mail-Adresse) " +
                    "VALUES(" + vorname + ", " + nachname + ", " + telefonnummer + ", " + email + ");";
            ResultSet rs = stmt.executeQuery(sql);

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException ignored) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public Kunde kundenSuchen(String vorname, String nachname, String telefonnummer, String email) {
        Kunde kunde = null;

        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM Kunden WHERE Vorname LIKE '%" + vorname + "%' OR Nachname LIKE '%" + nachname
                    + "%' OR Telefonnummer LIKE '%" + telefonnummer + "%' OR E-Mail-Adresse LIKE '%" + email + "%';";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                kunde = new Kunde();
                kunde.setVorname(rs.getString("Vorname"));
                kunde.setNachname(rs.getString("Nachname"));
                kunde.setTelefonnummer(rs.getString("Telefonnummer"));
                kunde.setEmail(rs.getString("E-Mail-Adresse"));
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException ignored) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return kunde;
    }
}
