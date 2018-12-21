package main.java.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLAccess {
    private static MySQLAccess instance = null;
    private String host;
    private String database;
    private String user;
    private String passwd;
    private Connection connect = null;

    public MySQLAccess(){

    }

    public Connection getConnection() throws Exception {
        if (connect == null) {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connect = DriverManager
                    .getConnection("jdbc:mysql://" + this.host + ":3306/" + this.database + "?"
                            + "user=" + this.user + "&password=" + this.passwd + "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");

        }
        return connect;
    }

    public static MySQLAccess GetInstance()
    {
        if(instance == null)
            instance = new MySQLAccess();
        return instance;
    }

    private void close() {
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void init(String host, String user, String password, String database) {
        GetInstance().host = host;
        GetInstance().user = user;
        GetInstance().passwd = password;
        GetInstance().database = database;

        try {
            GetInstance().getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}