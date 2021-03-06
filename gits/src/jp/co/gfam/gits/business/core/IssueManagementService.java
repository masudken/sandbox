package jp.co.gfam.gits.business.core;

import java.util.List;

import jp.co.gfam.gits.business.dto.IssueDto;
import jp.co.gfam.gits.business.dto.IssueListDto;
import jp.co.gfam.gits.business.dto.IssueSearchConditionDto;
import jp.co.gfam.gits.business.dto.IssueTypeDto;

/**
 * このクラスは課題管理のサービスを提供します。
 *
 * @author Kenichi Masuda
 */
public interface IssueManagementService {

    /**
     * 指定された検索条件に一致する課題を検索します。
     *
     * @param condition 検索条件
     * @return 課題一覧
     */
    public IssueListDto searchIssues(IssueSearchConditionDto condition);

    /**
     * 課題種別を検索します。
     *
     * @return 課題一覧
     */
    public List<IssueTypeDto> searchIssueTypes();

    /**
     * 指定された課題を登録します。
     *
     * @param issue 課題
     */
    public void registerIssue(IssueDto issue);

    /**
     * 指定された課題情報で課題を更新します。
     *
     * @param issue 課題
     */
    public void updateIssue(IssueDto issue);
}
