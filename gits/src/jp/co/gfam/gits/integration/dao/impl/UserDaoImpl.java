package jp.co.gfam.gits.integration.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jp.co.gfam.gits.common.criteria.UserCriteria;
import jp.co.gfam.gits.common.entity.User;
import jp.co.gfam.gits.integration.dao.UserDao;

/**
 * このクラスはユーザ情報のデータアクセスオブジェクトです。
 *
 * @author Kenichi Masuda
 */
public class UserDaoImpl implements UserDao {

    /**
     * DBコネクッションを保持した {@code ThreadLocal} オブジェクト
     */
    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();

    private static final String SELECT_STATEMENT = "SELECT * FROM user";

    /*
     * (非 Javadoc)
     *
     * @see
     * jp.co.gfam.gits.integration.dao.UserDao#search(jp.co.gfam.gits.common
     * .criteria.UserCriteria)
     */
    @Override
    public List<User> search(UserCriteria criteria) throws SQLException {

        // DBコネクションを取得
        Connection connection = connectionHolder.get();

        // SQLの生成
        String query = createQuery(criteria);

        // SQLの実行
        List<User> searchedUserList = new ArrayList<User>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            // 結果をエンティティに変換
            while (resultSet.next()) {
                User user = new User();
                user.setUserId(resultSet.getObject("user_id", Integer.class));
                user.setUserName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("password"));
                user.setExpirationDate(resultSet.getDate("expiration_date"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setMailAddress(resultSet.getString("mail_address"));
                user.setUpdateDateTime(resultSet
                        .getTimestamp("update_date_time"));
                searchedUserList.add(user);
            }
        }

        return searchedUserList;
    }

    private String createQuery(UserCriteria criteria) {

        StringBuilder builder = new StringBuilder();
        builder.append(SELECT_STATEMENT);
        if (criteria.getUserId() != null || criteria.getUserName() != null
                || criteria.getFirstName() != null
                || criteria.getLastName() != null
                || criteria.getMailAddress() != null) {
            builder.append(" WHERE");
            if (criteria.getUserId() != null) {
                builder.append(" user_id = " + criteria.getUserId().toString());
            }
            if (criteria.getUserName() != null) {
                builder.append(" AND");
                builder.append(" user_name = " + criteria.getUserName());
            }
            if (criteria.getFirstName() != null) {
                builder.append(" AND");
                builder.append(" first_name = " + criteria.getFirstName());
            }
            if (criteria.getLastName() != null) {
                builder.append(" AND");
                builder.append(" last_name = " + criteria.getLastName());
            }
            if (criteria.getMailAddress() != null) {
                builder.append(" AND");
                builder.append(" mail_address = " + criteria.getMailAddress());
            }
        }
        return builder.toString();
    }
}
