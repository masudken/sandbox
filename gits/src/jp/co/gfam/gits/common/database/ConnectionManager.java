package jp.co.gfam.gits.common.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static ConnectionManager instance = null;

    private ConnectionManager() {
    }

    public static synchronized ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql:@localhost:1521:gits",
                "gfam", "gfam");
    }
}
