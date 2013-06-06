package jp.co.gfam.gits.common.context;

import java.sql.Connection;

public class ConnectionContext {

    /**
     * DBコネクッションを保持した {@code ThreadLocal} オブジェクト
     */
    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();

    public void SetConnection(Connection connection) {
        connectionHolder.set(connection);
    }

    public Connection getConnection() {
        return connectionHolder.get();
    }
}
