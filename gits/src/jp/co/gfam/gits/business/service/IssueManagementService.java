package jp.co.gfam.gits.business.service;

import jp.co.gfam.gits.common.criteria.IssueCriteria;
import jp.co.gfam.gits.common.dto.IssueListDto;

/**
 * �ۑ�Ǘ��T�[�r�X
 *
 * @author kenichi
 */
public interface IssueManagementService {

    public IssueListDto searchIssues(IssueCriteria criteria);

    public void registerIssue(IssueDto issue);

    public void updateIssue(IssueDto issue);
}
