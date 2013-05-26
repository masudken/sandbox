package jp.co.gfam.gits.integration.dao;

import java.util.List;

import jp.co.gfam.gits.common.criteria.IssueCriteria;
import jp.co.gfam.gits.common.entity.Issue;

/**
 * 課題情報へのアクセス機能を提供するインターフェースです。
 *
 * @author Kenichi Masuda
 */
public interface IssueDao {

    /**
     * 指定された課題を登録します。
     *
     * @param issue　課題
     */
    public void insert(Issue issue);

    /**
     * 指定された課題を更新します。
     *
     * @param issue 課題
     */
    public void update(Issue issue);

    /**
     * 指定された検索条件に一致する課題を検索し、返します。
     *
     * @param criteria 検索条件
     * @return 課題のリスト
     */
    public List<Issue> search(IssueCriteria criteria);
}
