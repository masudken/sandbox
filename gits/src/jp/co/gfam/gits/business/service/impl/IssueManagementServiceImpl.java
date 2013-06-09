package jp.co.gfam.gits.business.service.impl;

import java.sql.SQLException;
import java.util.List;

import jp.co.gfam.gits.business.model.Issue;
import jp.co.gfam.gits.business.service.IssueManagementService;
import jp.co.gfam.gits.common.dto.IssueDto;
import jp.co.gfam.gits.common.dto.IssueListDto;
import jp.co.gfam.gits.common.dto.IssueSearchConditionDto;
import jp.co.gfam.gits.integration.dao.IssueCriteria;
import jp.co.gfam.gits.integration.dao.IssueDao;
import jp.co.gfam.gits.integration.dao.impl.IssueDaoImpl;

/**
 * @author Kenichi Masuda
 */
public class IssueManagementServiceImpl implements IssueManagementService {

    // TODO DIで設定できるようにしたいが、とりあえず直接インスタンス生成
    private IssueDao _issueDao = new IssueDaoImpl();

    /*
     * (非 Javadoc)
     *
     * @see
     * jp.co.gfam.gits.business.service.IssueManagementService#searchIssues(
     * jp.co.gfam.gits.common.dto.IssueSearchConditionDto)
     */
    @Override
    public IssueListDto searchIssues(IssueSearchConditionDto condition) {

        // 検索条件の生成
        IssueCriteria criteria = new IssueCriteria();
        criteria.setIssueId(condition.getIssueId());
        // criteria.setUserName(userName);

        List<Issue> issues = null;
        try {
            // ユーザー情報の取得
            issues = _issueDao.search(criteria);
        } catch (SQLException se) {

        }

        // DTO変換
        IssueListDto listDto = new IssueListDto();
        for (Issue issue : issues) {
            IssueDto issueDto = new IssueDto();
            issueDto.setIssueId(issue.getIssueId());
            issueDto.setIssueType(issue.getIssueType());
            issueDto.setTitle(issue.getTitle());
            issueDto.setDiscription(issue.getDiscription());
            issueDto.setRegistrantId(issue.getRegistrantId());
            issueDto.setRegisterDate(issue.getRegisterDate());
            issueDto.setRepresentativeId(issue.getRepresentativeId());
            issueDto.setPriority(issue.getPriority());
            issueDto.setStartDate(issue.getStartDate());
            issueDto.setEndDate(issue.getEndDate());
            issueDto.setProgress(issue.getProgress());
            issueDto.setCost(issue.getCost());
            issueDto.setIssueId(issue.getIssueId());
            issueDto.setStatus(issue.getStatus());
            issueDto.setUpdateDateTime(issue.getUpdateDateTime());
            listDto.addIssue(issueDto);
        }

        return listDto;
    }

    /*
     * (非 Javadoc)
     *
     * @see
     * jp.co.gfam.gits.business.service.IssueManagementService#registerIssue
     * (jp.co.gfam.gits.common.dto.IssueDto)
     */
    @Override
    public void registerIssue(IssueDto issue) {
        // TODO 自動生成されたメソッド・スタブ

    }

    /*
     * (非 Javadoc)
     *
     * @see
     * jp.co.gfam.gits.business.service.IssueManagementService#updateIssue(jp
     * .co.gfam.gits.common.dto.IssueDto)
     */
    @Override
    public void updateIssue(IssueDto issue) {
        // TODO 自動生成されたメソッド・スタブ

    }

    public void setIssueDao(IssueDao issueDao) {
        _issueDao = issueDao;
    }
}
