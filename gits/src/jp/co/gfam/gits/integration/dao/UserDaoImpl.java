package jp.co.gfam.gits.integration.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jp.co.gfam.gits.common.connection.ConnectionContext;
import jp.co.gfam.gits.integration.entity.User;

/**
 * このクラスはユーザ情報のデータアクセスオブジェクトです。
 *
 * @author Kenichi Masuda
 */
public class UserDaoImpl implements UserDao {

    /**
     * SQLのSELECT文
     */
    private static final String SELECT_STATEMENT = "select * from user";

    /*
     * (非 Javadoc)
     *
     * @see
     * jp.co.gfam.gits.integration.dao.UserDao#search(jp.co.gfam.gits.common
     * .criteria.UserCriteria)
     */
    @Override
    public List<User> select(UserCriteria criteria) throws SQLException {

        // DBコネクションを取得
        Connection connection = ConnectionContext.getContext().getConnection();

        // SQLの生成
        String query = createQuery(criteria);

        // SQLの実行
        List<User> searchedUserList = new ArrayList<User>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            // 結果をエンティティに変換
            while (resultSet.next()) {
                User user = convertToEntity(resultSet);
                searchedUserList.add(user);
            }
        }

        return searchedUserList;
    }

    /**
     * SQL結果セットから値を取得し、ユーザエンティティへ変換します。
     *
     * @param resultSet SQL結果セット
     * @return ユーザエンティティ
     * @throws SQLException SQL結果セットからの値の取得に失敗した場合
     */
    private User convertToEntity(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getObject("user_id", Integer.class));
        user.setUserName(resultSet.getString("user_name"));
        user.setPassword(resultSet.getString("password"));
        user.setExpirationDate(resultSet.getDate("expiration_date"));
        user.setFirstName(resultSet.getString("first_name"));
        user.setLastName(resultSet.getString("last_name"));
        user.setMailAddress(resultSet.getString("mail_address"));
        user.setUpdateDateTime(resultSet.getTimestamp("update_date_time"));
        return user;
    }

    /**
     * ユーザ検索条件を元に、SQLクエリーを生成します。
     *
     * @param criteria ユーザ検索条件
     * @return SQLクエリー
     */
    private String createQuery(UserCriteria criteria) {

        StringBuilder builder = new StringBuilder();
        builder.append(SELECT_STATEMENT);
        if (criteria.isEmpty()) {
            return builder.toString();
        }

        int statementCount = 0;
        builder.append(" where");
        // ユーザID
        if (criteria.getUserId() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" user_id = " + criteria.getUserId().toString());
            statementCount++;
        }
        // ユーザ名
        if (criteria.getUserName() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" user_name = '" + criteria.getUserName() + "'");
            statementCount++;
        }
        // 名
        if (criteria.getFirstName() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" first_name = '" + criteria.getFirstName() + "'");
            statementCount++;
        }
        // 姓
        if (criteria.getLastName() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" last_name = '" + criteria.getLastName() + "'");
            statementCount++;
        }
        // メールアドレス
        if (criteria.getMailAddress() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" mail_address = '" + criteria.getMailAddress()
                    + "'");
            statementCount++;
        }
        return builder.toString();
    }
}
