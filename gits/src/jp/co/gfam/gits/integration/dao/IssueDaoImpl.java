package jp.co.gfam.gits.integration.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jp.co.gfam.gits.common.connection.ConnectionContext;
import jp.co.gfam.gits.integration.entity.Issue;

/**
 * このクラスは課題情報のデータアクセスオブジェクトです。
 *
 * @author Kenichi Masuda
 */
public class IssueDaoImpl implements IssueDao {

    /**
     * SQLのSELECT文
     */
    private static final String SELECT_STATEMENT = "select * from issue";

    /**
     * SQLのINSERT文
     */
    private static final String INSERT_STATEMENT = "insert into issue ("
            + " issue_type_code, title, description, registrant_id, register_date, representative_id,"
            + " priority, start_date, end_date, progress, cost, status, update_date_time )"
            + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    /**
     * SQLのUPDATE文
     */
    private static final String UPDATE_STATEMENT = "update issue set"
            + " issue_type_code = ?, title = ?, description = ?, registrant_id = ?,register_date = ?,"
            + " representative_id = ?, priority = ?,start_date = ?, end_date =?,progress = ?,"
            + " cost = ?,status = ? where issue_id = ?";

    /*
     * (非 Javadoc)
     *
     * @see
     * jp.co.gfam.gits.integration.dao.IssueDao#insert(jp.co.gfam.gits.common
     * .entity.Issue)
     */
    @Override
    public void insert(Issue issue) throws SQLException {

        // DBコネクションを取得
        Connection connection = ConnectionContext.getContext().getConnection();

        try (PreparedStatement statement = connection
                .prepareStatement(INSERT_STATEMENT)) {

            // SQLパラメータの設定
            statement.setString(1, issue.getIssueTypeCode());
            statement.setString(2, issue.getTitle());
            statement.setString(3, issue.getDescription());
            statement.setInt(4, issue.getRegistrantId());
            statement.setDate(5, new Date(issue.getRegisterDate().getTime()));
            statement.setInt(6, issue.getRepresentativeId());
            statement.setString(7, issue.getPriority());
            statement.setDate(8, new Date(issue.getStartDate().getTime()));
            statement.setDate(9, new Date(issue.getEndDate().getTime()));
            statement.setInt(10, issue.getProgress());
            statement.setInt(11, issue.getCost());
            statement.setString(12, issue.getStatus());
            statement.setTimestamp(13, new Timestamp(issue.getUpdateDateTime()
                    .getTime()));

            // SQLの実行
            statement.executeUpdate();
        }
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * jp.co.gfam.gits.integration.dao.IssueDao#update(jp.co.gfam.gits.common
     * .entity.Issue)
     */
    @Override
    public void update(Issue issue) throws SQLException {

        // DBコネクションを取得
        Connection connection = ConnectionContext.getContext().getConnection();

        try (PreparedStatement statement = connection
                .prepareStatement(UPDATE_STATEMENT)) {

            // SQLパラメータの設定
            statement.setString(0, issue.getIssueTypeCode());
            statement.setString(1, issue.getTitle());
            statement.setString(2, issue.getDescription());
            statement.setString(3, issue.getIssueTypeCode());
            statement.setInt(4, issue.getRepresentativeId());
            statement.setDate(5, new Date(issue.getRegisterDate().getTime()));
            statement.setInt(6, issue.getRepresentativeId());
            statement.setString(7, issue.getPriority());
            statement.setDate(8, new Date(issue.getStartDate().getTime()));
            statement.setDate(9, new Date(issue.getEndDate().getTime()));
            statement.setInt(10, issue.getProgress());
            statement.setInt(11, issue.getCost());
            statement.setTimestamp(12, new Timestamp(issue.getUpdateDateTime()
                    .getTime()));
            statement.setInt(13, issue.getIssueId());

            // SQLの実行
            statement.executeUpdate();
        }
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
        Connection connection = ConnectionContext.getContext().getConnection();

        // SQLの生成
        String query = createQuery(criteria);

        List<Issue> searchedIssueList = new ArrayList<Issue>();
        try (Statement statement = connection.createStatement()) {
            // SQLの実行
            ResultSet resultSet = statement.executeQuery(query);
            // 結果をエンティティに変換
            while (resultSet.next()) {
                Issue issue = convertToEntity(resultSet);
                searchedIssueList.add(issue);
            }
        }
        return searchedIssueList;
    }

    /**
     * SQL結果セットから値を取得し、課題エンティティへ変換します。
     *
     * @param resultSet SQL結果セット
     * @return 課題エンティティ
     * @throws SQLException SQL結果セットからの値の取得に失敗した場合
     */
    private Issue convertToEntity(ResultSet resultSet) throws SQLException {
        Issue issue = new Issue();
        issue.setIssueId(resultSet.getObject("issue_id", Integer.class));
        issue.setIssueTypeCode(resultSet.getString("issue_type_code"));
        issue.setTitle(resultSet.getString("title"));
        issue.setDescription(resultSet.getString("description"));
        issue.setRegistrantId(resultSet.getObject("registrant_id",
                Integer.class));
        issue.setRegisterDate(resultSet.getDate("register_date"));
        issue.setRepresentativeId(resultSet.getObject("representative_id",
                Integer.class));
        issue.setPriority(resultSet.getString("priority"));
        issue.setStartDate(resultSet.getDate("start_date"));
        issue.setEndDate(resultSet.getDate("end_date"));
        issue.setProgress(resultSet.getObject("progress", Integer.class));
        issue.setCost(resultSet.getObject("cost", Integer.class));
        issue.setStatus(resultSet.getString("status"));
        issue.setUpdateDateTime(resultSet.getTimestamp("update_date_time"));
        return issue;
    }

    /**
     * 課題検索条件を元に、SQLクエリーを生成します。
     *
     * @param criteria 課題検索条件
     * @return SQLクエリー
     */
    private String createQuery(IssueCriteria criteria) {

        StringBuilder builder = new StringBuilder();
        builder.append(SELECT_STATEMENT);
        if (criteria.isEmpty()) {
            return builder.toString();
        }

        int statementCount = 0;
        builder.append(" where");
        // 課題ID
        if (criteria.getIssueId() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" issue_id = " + criteria.getIssueId().toString());
            statementCount++;
        }
        // 課題種別コード
        if (criteria.getIssueTypeCode() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" issue_type_code = '" + criteria.getIssueTypeCode()
                    + "'");
            statementCount++;
        }
        // タイトル (部分一致)
        if (criteria.getTitle() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" title like '%" + criteria.getTitle() + "%'");
            statementCount++;
        }
        // 説明 (部分一致)
        if (criteria.getDiscription() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" discription like '%" + criteria.getDiscription()
                    + "%'");
            statementCount++;
        }
        // 起票者ID
        if (criteria.getRegistrantId() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" registrant_Id = " + criteria.getRegistrantId());
            statementCount++;
        }
        // 起票日
        if (criteria.getRegisterDate() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" register_date = " + criteria.getRegisterDate());
            statementCount++;
        }
        // 担当者ID
        if (criteria.getRepresentativeId() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" representative_id = "
                    + criteria.getRepresentativeId());
            statementCount++;
        }
        // 優先度
        if (criteria.getPriority() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" priority = " + criteria.getPriority());
            statementCount++;
        }
        // 開始日
        if (criteria.getStartDate() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" start_date = " + criteria.getStartDate());
            statementCount++;
        }
        // 終了日
        if (criteria.getEndDate() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" end_date = " + criteria.getEndDate());
            statementCount++;
        }
        // 進捗
        if (criteria.getProgress() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" progress = " + criteria.getProgress());
            statementCount++;
        }
        // 工数
        if (criteria.getCost() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" cost = " + criteria.getCost());
            statementCount++;
        }
        // ステータス
        if (criteria.getStatus() != null) {
            if (statementCount != 0) {
                builder.append(" and");
            }
            builder.append(" status = '" + criteria.getStatus() + "'");
            statementCount++;
        }
        return builder.toString();
    }
}
