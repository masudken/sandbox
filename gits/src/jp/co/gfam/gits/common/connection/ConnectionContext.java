package jp.co.gfam.gits.common.connection;

import java.sql.Connection;

public class ConnectionContext {

    private static ConnectionContext instance = null;

    /**
     * DBコネクッションを保持した {@code ThreadLocal} オブジェクト
     */
    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();

    private ConnectionContext() {
    }

    public static synchronized ConnectionContext getContext() {
        if (instance == null) {
            instance = new ConnectionContext();
        }
        return instance;
    }

    public void SetConnection(Connection connection) {
        connectionHolder.set(connection);
    }

    public Connection getConnection() {
        return connectionHolder.get();
    }
}
