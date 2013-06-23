package jp.co.gfam.gits.integration.dao;

import java.sql.SQLException;
import java.util.List;

import jp.co.gfam.gits.integration.entity.User;

/**
 * ユーザ情報へのアクセス機能を提供するインターフェースです。
 *
 * @author Kenichi Masuda
 */
public interface UserDao {

    /**
     * 指定された検索条件に一致する課題を検索し、返します。
     *
     * @param criteria 検索条件
     * @return 課題のリスト
     * @throws {@code SQLException} SQL実行例外
     */
    public List<User> select(UserCriteria criteria) throws SQLException;
}
