package jp.co.gfam.gits.integration.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jp.co.gfam.gits.common.criteria.IssueCriteria;
import jp.co.gfam.gits.common.entity.Issue;
import jp.co.gfam.gits.integration.dao.IssueDao;

/**
 * このクラスは課題情報のデータアクセスオブジェクトです。
 *
 * @author Kenichi Masuda
 */
public class IssueDaoImpl implements IssueDao {

    /**
     * DBコネクッションを保持した {@code ThreadLocal} オブジェクト
     */
    private static final ThreadLocal<Connection> CONNECTION_HOLDER = new ThreadLocal<Connection>();

    /*
     * (非 Javadoc)
     *
     * @see
     * jp.co.gfam.gits.integration.dao.IssueDao#insert(jp.co.gfam.gits.common
     * .entity.Issue)
     */
    @Override
    public void insert(Issue issue) {
        // TODO 自動生成されたメソッド・スタブ

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * jp.co.gfam.gits.integration.dao.IssueDao#update(jp.co.gfam.gits.common
     * .entity.Issue)
     */
    @Override
    public void update(Issue issue) {
        // TODO 自動生成されたメソッド・スタブ

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * jp.co.gfam.gits.integration.dao.IssueDao#search(jp.co.gfam.gits.common
     * .criteria.IssueCriteria)
     */
    @Override
    public List<Issue> search(IssueCriteria criteria) throws SQLException {

        // DBコネクションを取得
        Connection connection = CONNECTION_HOLDER.get();

        // SQLの生成
        String query = createQuery(criteria);

        // SQLの実行

        List<Issue> searchedIssueList = new ArrayList<Issue>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            // 結果をエンティティに変換
            while (resultSet.next()) {
                Issue issue = new Issue();
                issue.setIssueId(resultSet.getObject("issue_id", Integer.class));
                issue.setIssueType(resultSet.getString("issue_type_code"));
                issue.setTitle(resultSet.getString("title"));
                issue.setDiscription(resultSet.getString("description"));
                issue.setRegistrantId(resultSet.getObject("registrant_id",
                        Integer.class));
                issue.setRegisterDate(resultSet.getDate("register_date"));
                issue.setRegistrantId(resultSet.getObject("representative_id",
                        Integer.class));
                issue.setPriority(resultSet.getString("priority"));
                issue.setStartDate(resultSet.getDate("start_date"));
                issue.setEndDate(resultSet.getDate("end_date"));
                issue.setProgress(resultSet.getObject("progress", Short.class));
                issue.setCost(resultSet.getObject("cost", Short.class));
                issue.setStatus(resultSet.getString("status"));
                issue.setUpdateDateTime(resultSet
                        .getTimestamp("update_date_time"));
                searchedIssueList.add(issue);
            }
        }

        return searchedIssueList;
    }

    private String createQuery(IssueCriteria criteria) {

        StringBuilder builder = new StringBuilder();
        // builder.append(SELECT_STATEMENT);
        // if (criteria.getUserId() != null || criteria.getUserName() != null
        // || criteria.getFirstName() != null
        // || criteria.getLastName() != null
        // || criteria.getMailAddress() != null) {
        // builder.append("WHERE");
        // if (criteria.getUserId() != null) {
        // builder.append(" user_id = " + criteria.getUserId().toString());
        // }
        // if (criteria.getUserName() != null) {
        // builder.append(" AND");
        // builder.append(" user_name = " + criteria.getUserName());
        // }
        // if (criteria.getFirstName() != null) {
        // builder.append(" AND");
        // builder.append(" first_name = " + criteria.getFirstName());
        // }
        // if (criteria.getLastName() != null) {
        // builder.append(" AND");
        // builder.append(" last_name = " + criteria.getLastName());
        // }
        // if (criteria.getMailAddress() != null) {
        // builder.append(" AND");
        // builder.append(" mail_address = " + criteria.getMailAddress());
        // }
        // }
        return builder.toString();
    }
}
