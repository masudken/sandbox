package jp.co.gfam.gits.integration.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jp.co.gfam.gits.common.connection.ConnectionContext;
import jp.co.gfam.gits.integration.entity.IssueType;

/**
 * このクラスは課題種別情報のデータアクセスオブジェクトです。
 *
 * @author Kenichi Masuda
 */
public class IssueTypeDaoImpl implements IssueTypeDao {

    /**
     * SQLのSELECT文
     */
    private static final String SELECT_STATEMENT = "select * from issue_type";

    /*
     * (非 Javadoc)
     *
     * @see jp.co.gfam.gits.integration.dao.IssueTypeDao#selectAll()
     */
    @Override
    public List<IssueType> selectAll() throws SQLException {

        // DBコネクションを取得
        Connection connection = ConnectionContext.getContext().getConnection();

        // SQLの生成
        String query = SELECT_STATEMENT;

        // SQLの実行
        List<IssueType> searchedIssueTypeList = new ArrayList<IssueType>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            // 結果をエンティティに変換
            while (resultSet.next()) {
                IssueType issueType = convertToEntity(resultSet);
                searchedIssueTypeList.add(issueType);
            }
        }

        return searchedIssueTypeList;
    }

    /**
     * SQL結果セットから値を取得し、課題種別エンティティへ変換します。
     *
     * @param resultSet SQL結果セット
     * @return 課題種別エンティティ
     * @throws SQLException SQL結果セットからの値の取得に失敗した場合
     */
    private IssueType convertToEntity(ResultSet resultSet) throws SQLException {
        IssueType issueType = new IssueType();
        issueType.setIssueTypeCode(resultSet.getString("issue_type_code"));
        issueType.setIssueTypeName(resultSet.getString("issue_type_name"));
        issueType.setUpdateDateTime(resultSet.getTimestamp("update_date_time"));
        return issueType;
    }
}
