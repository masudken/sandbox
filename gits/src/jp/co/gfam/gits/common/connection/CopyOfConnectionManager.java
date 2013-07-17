package jp.co.gfam.gits.common.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CopyOfConnectionManager {

    private static CopyOfConnectionManager instance = null;

    private CopyOfConnectionManager() {
    }

    public static synchronized CopyOfConnectionManager getInstance() {
        if (instance == null) {
            instance = new CopyOfConnectionManager();
        }
        return instance;
    }

    public Connection openConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/gits",
                "gfam", "gfam");
    }
}
