package jp.co.gfam.gits.business.service;

import jp.co.gfam.gits.common.dto.IssueDto;
import jp.co.gfam.gits.common.dto.IssueListDto;
import jp.co.gfam.gits.common.dto.IssueSearchConditionDto;

/**
 * このクラスは課題管理のサービスを提供します。
 *
 * @author Kenichi Masuda
 */
public interface IssueManagementService {

    public IssueListDto searchIssues(IssueSearchConditionDto condition);

    public void registerIssue(IssueDto issue);

    public void updateIssue(IssueDto issue);
}
