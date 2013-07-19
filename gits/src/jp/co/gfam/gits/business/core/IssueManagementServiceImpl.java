package jp.co.gfam.gits.business.core;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.gfam.gits.business.SystemException;
import jp.co.gfam.gits.business.dto.IssueDto;
import jp.co.gfam.gits.business.dto.IssueListDto;
import jp.co.gfam.gits.business.dto.IssueSearchConditionDto;
import jp.co.gfam.gits.business.dto.IssueTypeDto;
import jp.co.gfam.gits.business.dto.UserDto;
import jp.co.gfam.gits.integration.dao.IssueCriteria;
import jp.co.gfam.gits.integration.dao.IssueDao;
import jp.co.gfam.gits.integration.dao.IssueDaoImpl;
import jp.co.gfam.gits.integration.dao.IssueTypeDao;
import jp.co.gfam.gits.integration.dao.IssueTypeDaoImpl;
import jp.co.gfam.gits.integration.dao.UserCriteria;
import jp.co.gfam.gits.integration.dao.UserDao;
import jp.co.gfam.gits.integration.dao.UserDaoImpl;
import jp.co.gfam.gits.integration.entity.Issue;
import jp.co.gfam.gits.integration.entity.IssueType;
import jp.co.gfam.gits.integration.entity.User;

/**
 * このクラスは課題管理のサービスを提供します。
 *
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
     */
    @Override
    public IssueListDto searchIssues(IssueSearchConditionDto condition) {

        List<Issue> issues = null;
        Map<String, IssueType> issueTypeMap = new HashMap<String, IssueType>();
        Map<Integer, User> userMap = new HashMap<Integer, User>();

        try {
            // ユーザの取得(全件)
            List<User> userList = _userDao.select(new UserCriteria());

            // ユーザID検索用マップ
            Map<String, Integer> userIdMap = new HashMap<String, Integer>();
            for (User user : userList) {
                userIdMap.put(user.getLastName() + " " + user.getFirstName(),
                        user.getUserId());
            }

            // 起票者と担当者のID取得
            Integer registrantId = null;
            if (condition.getRegistrant() != null) {
                registrantId = userIdMap.get(condition.getRegistrant());
            }
            Integer representativeId = null;
            if (condition.getRepresentative() != null) {
                representativeId = userIdMap.get(condition.getRepresentative());
            }

            // 検索条件の生成
            IssueCriteria criteria = new IssueCriteria();
            criteria.setIssueId(condition.getIssueId());
            criteria.setIssueTypeCode(condition.getIssueTypeCode());
            criteria.setTitle(condition.getTitle());
            criteria.setRegistrantId(registrantId);
            criteria.setRepresentativeId(representativeId);
            criteria.setStatus(condition.getStatus());

            // 課題情報の取得
            issues = _issueDao.search(criteria);

            // 課題種別の取得
            List<IssueType> issueTypes = _issueTypeDao.selectAll();
            for (IssueType issueType : issueTypes) {
                issueTypeMap.put(issueType.getIssueTypeCode(), issueType);
            }

            // ユーザのマップ
            for (User user : userList) {
                userMap.put(user.getUserId(), user);
            }

        } catch (SQLException sqle) {
            // SQL実行例外はシステム例外へ変換
            new SystemException(sqle.getMessage());
        }

        // DTO変換
        IssueListDto listDto = new IssueListDto();
        for (Issue issue : issues) {
            IssueDto issueDto = new IssueDto();
            issueDto.setIssueId(issue.getIssueId());
            issueDto.setTitle(issue.getTitle());
            issueDto.setDescription(issue.getDescription());
            issueDto.setRegisterDate(issue.getRegisterDate());
            issueDto.setPriority(issue.getPriority());
            issueDto.setStartDate(issue.getStartDate());
            issueDto.setEndDate(issue.getEndDate());
            issueDto.setProgress(issue.getProgress());
            issueDto.setCost(issue.getCost());
            issueDto.setIssueId(issue.getIssueId());
            issueDto.setStatus(issue.getStatus());
            issueDto.setUpdateDateTime(issue.getUpdateDateTime());

            // 課題種別の設定
            IssueType issueType = issueTypeMap.get(issue.getIssueTypeCode());
            if (issueType != null) {
                IssueTypeDto issueTypeDto = new IssueTypeDto();
                issueTypeDto.setIssueTypeCode(issueType.getIssueTypeCode());
                issueTypeDto.setIssueTypeName(issueType.getIssueTypeName());
                issueDto.setIssueType(issueTypeDto);
            }

            // 起票者の設定
            User registrant = userMap.get(issue.getRegistrantId());
            if (registrant != null) {
                UserDto registrantDto = new UserDto();
                registrantDto.setUserId(registrant.getUserId());
                registrantDto.setUserName(registrant.getPassword());
                registrantDto.setPassword(registrant.getPassword());
                registrantDto.setExpirationDate(registrant.getExpirationDate());
                registrantDto.setFullName(registrant.getLastName() + " "
                        + registrant.getFirstName());
                registrantDto.setMailAddress(registrant.getMailAddress());
                issueDto.setRegistrant(registrantDto);
            }

            // 担当者の設定
            User representative = userMap.get(issue.getRepresentativeId());
            if (representative != null) {
                UserDto representativeDto = new UserDto();
                representativeDto.setUserId(representative.getUserId());
                representativeDto.setUserName(representative.getPassword());
                representativeDto.setPassword(representative.getPassword());
                representativeDto.setExpirationDate(representative
                        .getExpirationDate());
                representativeDto.setFullName(representative.getLastName()
                        + " " + representative.getFirstName());
                representativeDto.setMailAddress(representative
                        .getMailAddress());
                issueDto.setRepresentative(representativeDto);
            }

            listDto.addIssue(issueDto);
        }

        return listDto;
    }

    /**
     * 指定された課題を登録します。
     *
     * @param issue 課題
     */
    @Override
    public void registerIssue(IssueDto issue) {

        Date systemDate = new Date();

        try {
            // ユーザの取得(全件)
            List<User> userList = _userDao.select(new UserCriteria());

            // ユーザID検索用マップ
            Map<String, Integer> userIdMap = new HashMap<String, Integer>();
            for (User user : userList) {
                userIdMap.put(user.getLastName() + " " + user.getFirstName(),
                        user.getUserId());
            }

            // DTOをエンティティへ変換
            Issue issueEntity = new Issue();
            issueEntity.setIssueTypeCode(issue.getIssueType()
                    .getIssueTypeCode());
            issueEntity.setTitle(issue.getTitle());
            issueEntity.setDescription(issue.getDescription());
            issueEntity.setPriority(issue.getPriority());
            issueEntity.setStartDate(issue.getStartDate());
            issueEntity.setEndDate(issue.getEndDate());
            issueEntity.setProgress(issue.getProgress());
            issueEntity.setCost(issue.getCost());
            issueEntity.setStatus(issue.getStatus());

            // 起票者と担当者のID取得
            Integer registrantId = null;
            if (issue.getRegistrant().getFullName() != null) {
                registrantId = userIdMap.get(issue.getRegistrant()
                        .getFullName());
            }
            Integer representativeId = null;
            if (issue.getRepresentative().getFullName() != null) {
                representativeId = userIdMap.get(issue.getRepresentative()
                        .getFullName());
            }
            issueEntity.setRegistrantId(registrantId);
            issueEntity.setRepresentativeId(representativeId);

            // IDは自動採番
            issueEntity.setIssueId(null);
            // 登録日、更新日時はシステム日時
            issueEntity.setRegisterDate(systemDate);
            issueEntity.setUpdateDateTime(systemDate);

            // 登録実行
            _issueDao.insert(issueEntity);

        } catch (SQLException sqle) {
            // SQL実行例外はシステム例外へ変換
            new SystemException(sqle.getMessage());
        }
    }

    /**
     * 指定された課題を登録します。
     *
     * @param issue 課題
     */
    @Override
    public void updateIssue(IssueDto issue) {

        // DTOをエンティティへ変換
        Issue issueEntity = new Issue();
        issueEntity.setIssueId(issue.getIssueId());
        issueEntity.setIssueTypeCode(issue.getIssueType().getIssueTypeCode());
        issueEntity.setTitle(issue.getTitle());
        issueEntity.setDescription(issue.getDescription());
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

        } catch (SQLException sqle) {
            // SQL実行例外はシステム例外へ変換
            new SystemException(sqle.getMessage());
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
