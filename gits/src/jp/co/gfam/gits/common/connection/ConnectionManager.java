package jp.co.gfam.gits.common.connection;

import java.sql.Connection;
import java.sql.DriverManager;

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

    public Connection openConnection() throws Exception {

        // TODO JDK7からはこの記述は不要だが、
        // Tomcatから実行した場合 No Such Driverエラーとなるので追加している。
        // クラスパス系の問題らしいが、原因は不明
        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost/gits",
                "gfam", "gfam");
    }
}
