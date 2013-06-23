package jp.co.gfam.gits.business.core;

import java.sql.SQLException;
import java.util.List;

import jp.co.gfam.gits.common.dto.IssueDto;
import jp.co.gfam.gits.common.dto.IssueListDto;
import jp.co.gfam.gits.common.dto.IssueSearchConditionDto;
import jp.co.gfam.gits.integration.dao.IssueCriteria;
import jp.co.gfam.gits.integration.dao.IssueDao;
import jp.co.gfam.gits.integration.dao.IssueDaoImpl;
import jp.co.gfam.gits.integration.dao.IssueTypeDao;
import jp.co.gfam.gits.integration.dao.IssueTypeDaoImpl;
import jp.co.gfam.gits.integration.dao.UserCriteria;
import jp.co.gfam.gits.integration.dao.UserDao;
import jp.co.gfam.gits.integration.dao.UserDaoImpl;
import jp.co.gfam.gits.integration.entity.Issue;

/**
 * @author Kenichi Masuda
 */
public class IssueManagementServiceImpl implements IssueManagementService {

    /**
     * 課題DAO
     */
    private IssueDao _issueDao = new IssueDaoImpl();

    /**
     * 課題種別DAO
     */
    private IssueTypeDao _issueTypeDao = new IssueTypeDaoImpl();

    /**
     * ユーザDAO
     */
    private UserDao _userDao = new UserDaoImpl();

    /**
     * 指定された検索条件に一致する課題を検索します。
     *
     * @param condition 検索条件
     * @return 課題一覧
     * @see IssueManagementService#searchIssues(IssueSearchConditionDto)
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

            // 課題種別の取得
            _issueTypeDao.selectAll();

            // ユーザ情報の取得
            _userDao.select(new UserCriteria());

        } catch (SQLException se) {

        }

        // DTO変換
        IssueListDto listDto = new IssueListDto();
        for (Issue issue : issues) {
            IssueDto issueDto = new IssueDto();
            issueDto.setIssueId(issue.getIssueId());
            // issueDto.setIssueType(issue.getIssueTypeCode());
            issueDto.setTitle(issue.getTitle());
            issueDto.setDiscription(issue.getDiscription());
            // issueDto.setRegistrantId(issue.getRegistrantId());
            issueDto.setRegisterDate(issue.getRegisterDate());
            // issueDto.setRepresentativeId(issue.getRepresentativeId());
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

    /**
     * 指定された課題を登録します。
     *
     * @param issue 課題
     * @see IssueManagementService#registerIssue(IssueDto)
     */
    @Override
    public void registerIssue(IssueDto issue) {

        // DTOをエンティティへ変換
        Issue issueEntity = new Issue();
        issueEntity.setIssueId(issue.getIssueId());
        issueEntity.setIssueTypeCode(issue.getIssueType().getIssueTypeCode());
        issueEntity.setTitle(issue.getTitle());
        issueEntity.setDiscription(issue.getDiscription());
        issueEntity.setRegistrantId(issue.getRegistrant().getUserId());
        issueEntity.setRegisterDate(issue.getRegisterdDate());
        issueEntity.setRepresentativeId(issue.getRepresentative().getUserId());
        issueEntity.setPriority(issue.getPriority());
        issueEntity.setStartDate(issue.getStartDate());
        issueEntity.setEndDate(issue.getEndDate());
        issueEntity.setProgress(issue.getProgress());
        issueEntity.setCost(issue.getCost());
        issueEntity.setIssueId(issue.getIssueId());
        issueEntity.setStatus(issue.getStatus());
        issueEntity.setUpdateDateTime(issue.getUpdateDateTime());

        // 登録実行
        try {
            _issueDao.insert(issueEntity);
        } catch (SQLException se) {
        }
    }

    /**
     * 指定された課題を登録します。
     *
     * @param issue 課題
     * @see IssueManagementService#updateIssue(IssueDto)
     */
    @Override
    public void updateIssue(IssueDto issue) {

        // DTOをエンティティへ変換
        Issue issueEntity = new Issue();
        issueEntity.setIssueId(issue.getIssueId());
        issueEntity.setIssueTypeCode(issue.getIssueType().getIssueTypeCode());
        issueEntity.setTitle(issue.getTitle());
        issueEntity.setDiscription(issue.getDiscription());
        issueEntity.setRegistrantId(issue.getRegistrant().getUserId());
        issueEntity.setRegisterDate(issue.getRegisterdDate());
        issueEntity.setRepresentativeId(issue.getRepresentative().getUserId());
        issueEntity.setPriority(issue.getPriority());
        issueEntity.setStartDate(issue.getStartDate());
        issueEntity.setEndDate(issue.getEndDate());
        issueEntity.setProgress(issue.getProgress());
        issueEntity.setCost(issue.getCost());
        issueEntity.setIssueId(issue.getIssueId());
        issueEntity.setStatus(issue.getStatus());
        issueEntity.setUpdateDateTime(issue.getUpdateDateTime());

        // 更新実行
        try {
            _issueDao.update(issueEntity);
        } catch (SQLException se) {
        }
    }

    /**
     * 課題DAOを設定します。
     *
     * @param issueDao 課題DAO
     */
    public void setIssueDao(IssueDao issueDao) {
        _issueDao = issueDao;
    }

    /**
     * 課題種別DAOを設定します。
     *
     * @param issueTypeDao 課題種別DAO
     */
    public void setIssueTypeDao(IssueTypeDao issueTypeDao) {
        _issueTypeDao = issueTypeDao;
    }

    /**
     * ユーザDAOを設定します。
     *
     * @param userDao ユーザDAO
     */
    public void setUserDao(UserDao userDao) {
        _userDao = userDao;
    }
}
