package jp.co.gfam.gits.integration.dao;

import java.sql.SQLException;
import java.util.List;

import jp.co.gfam.gits.integration.entity.IssueType;

/**
 * 課題種別へのアクセス機能を提供するインターフェースです。
 *
 * @author Kenichi Masuda
 */
public interface IssueTypeDao {

    /**
     * すべての課題種別を検索し、返します。
     *
     * @return 課題種別のリスト
     */
    public List<IssueType> selectAll() throws SQLException;
}
