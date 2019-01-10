package db;

import business.kunde.Kunde;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

public class DBConnector {
  
//    private static final String DB_URL = "jdbc:mysql://localhost/bautraegerfx";
//    
//    private static final String USER = "root";
//    private static final String PASS = "root";
  
    public static String user, pass, db_url;
	
    
    public boolean hatDachgeschoss(int planNummer) {
        boolean hatDachgeschoss = false;
        
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(db_url, user, pass);

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
            conn = DriverManager.getConnection(db_url, user, pass);

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
            conn = DriverManager.getConnection(db_url, user, pass);

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

    public String getBildVonHaus(int id){
        //Laed Bild zu Haus mit entsprechender ID in den Bilder-Ordner und gibt den Speicherpfad zurueck.

        FileOutputStream image;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet res = null;
        StringBuffer query=null;
        String driverName = "com.mysql.jdbc.Driver";
        String path = "";

        try{
            Class.forName(driverName);
            con = DriverManager.getConnection(db_url, user, pass);

            //Datenbank hat noch keine Tabelle/Spalte fuer Bilder!
            String sql = "SELECT Bild FROM Bauplan WHERE Plannummer = ?";

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs=pstmt.executeQuery();
            if (rs.next()) {
                Blob test=rs.getBlob("bild");
                InputStream x=test.getBinaryStream();
                int size=x.available();
                path = "resources/BilderVonHaeusern/" + id + ".jpg";
                OutputStream out=new FileOutputStream(path);
                byte b[]= new byte[size];
                x.read(b);
                out.write(b);
            }
        }
        catch(NullPointerException ne){
            throw new NullPointerException();
        }
        catch(Exception e){
            System.out.println("Exception :"+e);
        }
        finally{
            try{
                pstmt.close();
                con.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }

        return path;
    }
}
