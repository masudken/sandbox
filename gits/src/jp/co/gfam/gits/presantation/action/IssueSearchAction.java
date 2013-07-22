package jp.co.gfam.gits.presantation.action;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import jp.co.gfam.gits.business.core.IssueManagementService;
import jp.co.gfam.gits.business.core.IssueManagementServiceImpl;
import jp.co.gfam.gits.business.core.UserManagementService;
import jp.co.gfam.gits.business.core.UserManagementServiceImpl;
import jp.co.gfam.gits.business.dto.IssueListDto;
import jp.co.gfam.gits.business.dto.IssueSearchConditionDto;
import jp.co.gfam.gits.business.dto.IssueTypeDto;
import jp.co.gfam.gits.business.dto.UserDto;
import jp.co.gfam.gits.business.dto.UserListDto;
import jp.co.gfam.gits.business.dto.UserSearchConditionDto;
import jp.co.gfam.gits.common.connection.ConnectionContext;
import jp.co.gfam.gits.common.connection.ConnectionManager;
import jp.co.gfam.gits.presantation.util.ViewHelper;

/**
 * このクラスは課題検索用のアクションクラスです。
 *
 * @author Kenichi Masuda
 */
public class IssueSearchAction implements SessionAware {

    /**
     * 課題管理サービス
     */
    private IssueManagementService _issueManagementService = new IssueManagementServiceImpl();

    /**
     * ユーザ管理サービス
     */
    private UserManagementService _userManagementService = new UserManagementServiceImpl();

    /**
     * HTTPセッション
     */
    @SuppressWarnings("unused")
    private Map<String, Object> _session = null;

    /**
     * ViewHelper
     */
    private ViewHelper _helper = null;

    /**
     * 課題種別マップ
     */
    private Map<String, String> _issueTypeMap = null;

    /**
     * ステータスマップ
     */
    private Map<String, String> _statusMap = null;

    /**
     * 起票者マップ
     */
    private Map<String, String> _registrantMap = null;

    /**
     * 担当者マップ
     */
    private Map<String, String> _representativeMap = null;

    /**
     * 課題番号
     */
    private Integer _issueId = null;

    /**
     * 課題種別
     */
    private String _issueType = null;

    /**
     * タイトル
     */
    private String _title = null;

    /**
     * ステータス
     */
    private String _status = null;

    /**
     * 起票者
     */
    private String _registrant = null;

    /**
     * 担当者
     */
    private String _representative = null;

    /**
     * 課題一覧
     */
    private IssueListDto _issueList = null;

    /**
     * 課題管理サービスを設定します。
     *
     * @param issueManagementService 課題管理サービス
     */
    public void setIssueManagementService(
            IssueManagementService issueManagementService) {
        _issueManagementService = issueManagementService;
    }

    /**
     * ユーザ管理サービスを設定します。
     *
     * @param userManagementService ユーザ管理サービス
     */
    public void setUserManagementService(
            UserManagementService userManagementService) {
        _userManagementService = userManagementService;
    }

    /**
     * HTTPセッションを設定します。
     *
     * @param session HTTPセッション
     */
    @Override
    public void setSession(Map<String, Object> session) {
        _session = session;
    }

    /**
     * ViewHelperを取得します。
     *
     * @return ViewHelper
     */
    public ViewHelper getHelper() {
        return _helper;
    }

    /**
     * ViewHelperを設定します。
     *
     * @param helper ViewHelper
     */
    public void setHelper(ViewHelper helper) {
        _helper = helper;
    }

    /**
     * 課題種別マップを取得します。
     *
     * @return 課題種別マップ
     */
    public Map<String, String> getIssueTypeMap() {
        return _issueTypeMap;
    }

    /**
     * 課題種別マップを設定します。
     *
     * @param issueTypeMap 課題種別マップ
     */
    public void setIssueTypeMap(Map<String, String> issueTypeMap) {
        _issueTypeMap = issueTypeMap;
    }

    /**
     * ステータスマップを取得します。
     *
     * @return ステータスマップ
     */
    public Map<String, String> getStatusMap() {
        return _statusMap;
    }

    /**
     * ステータスマップを設定します。
     *
     * @param statusMap ステータスマップ
     */
    public void setStatusMap(Map<String, String> statusMap) {
        _statusMap = statusMap;
    }

    /**
     * 起票者マップを取得します。
     *
     * @return 起票者マップ
     */
    public Map<String, String> getRegistrantMap() {
        return _registrantMap;
    }

    /**
     * 起票者マップを設定します。
     *
     * @param registrantMap 起票者マップ
     */
    public void setRegistrantMap(Map<String, String> registrantMap) {
        _registrantMap = registrantMap;
    }

    /**
     * 担当者マップを取得します。
     *
     * @return 担当者マップ
     */
    public Map<String, String> getRepresentativeMap() {
        return _representativeMap;
    }

    /**
     * 担当者マップを設定します。
     *
     * @param representativeMap 担当者マップ
     */
    public void setRepresentativeMap(Map<String, String> representativeMap) {
        _representativeMap = representativeMap;
    }

    /**
     * 課題番号を取得します。
     *
     * @return 課題番号
     */
    public Integer getIssueId() {
        return _issueId;
    }

    /**
     * 課題番号を設定します。
     *
     * @param issueId 課題番号
     */
    public void setIssueId(Integer issueId) {
        _issueId = issueId;
    }

    /**
     * 課題種別を取得します。
     *
     * @return 課題種別
     */
    public String getIssueType() {
        return _issueType;
    }

    /**
     * 課題種別を設定します。
     *
     * @param issueType 課題種別
     */
    public void setIssueType(String issueType) {
        _issueType = issueType;
    }

    /**
     * タイトルを取得します。
     *
     * @return タイトル
     */
    public String getTitle() {
        return _title;
    }

    /**
     * タイトルを設定します。
     *
     * @param title タイトル
     */
    public void setTitle(String title) {
        _title = title;
    }

    /**
     * ステータスを取得します。
     *
     * @return ステータス
     */
    public String getStatus() {
        return _status;
    }

    /**
     * ステータスを設定します。
     *
     * @param status ステータス
     */
    public void setStatus(String status) {
        _status = status;
    }

    /**
     * 起票者を取得します。
     *
     * @return 起票者
     */
    public String getRegistrant() {
        return _registrant;
    }

    /**
     * 起票者を設定します。
     *
     * @param registrant 起票者
     */
    public void setRegistrant(String registrant) {
        _registrant = registrant;
    }

    /**
     * 担当者を取得します。
     *
     * @return 担当者
     */
    public String getRepresentative() {
        return _representative;
    }

    /**
     * 担当者を設定します。
     *
     * @param representative 担当者
     */
    public void setRepresentative(String representative) {
        _representative = representative;
    }

    /**
     * 課題一覧を取得します。
     *
     * @return 課題一覧
     */
    public IssueListDto getIssueList() {
        return _issueList;
    }

    /**
     * 課題一覧を設定します。
     *
     * @param issueList 課題一覧
     */
    public void setIssueList(IssueListDto issueList) {
        _issueList = issueList;
    }

    /**
     * 課題検索アクションを実行します。
     *
     * @return 遷移先情報
     * @throws Exception 何らかの例外が発生した場合
     */
    @Action(value = "/search", results = { @Result(name = "success",
            location = "home.jsp") })
    public String execute() throws Exception {

        // コネクションの取得とトランザクションの開始
        Connection connection = ConnectionManager.getInstance()
                .openConnection();
        connection.setAutoCommit(false);
        ConnectionContext.getContext().SetConnection(connection);

        // 検索条件の生成
        IssueSearchConditionDto condition = new IssueSearchConditionDto();
        condition.setIssueId(_issueId);
        condition.setIssueTypeCode(StringUtils.trimToNull(_issueType));
        condition.setTitle(StringUtils.trimToNull(_title));
        condition.setRegistrant(StringUtils.trimToNull(_registrant));
        condition.setRepresentative(StringUtils.trimToNull(_representative));
        condition.setStatus(StringUtils.trimToNull(_status));

        // サービスの実行
        IssueListDto listDto = _issueManagementService.searchIssues(condition);

        // 検索結果を設定
        setIssueList(listDto);

        // 課題種別を設定
        List<IssueTypeDto> issueTypeList = _issueManagementService
                .searchIssueTypes();
        Map<String, String> issueTypes = new HashMap<String, String>();
        for (IssueTypeDto issueType : issueTypeList) {
            issueTypes.put(issueType.getIssueTypeCode(),
                    issueType.getIssueTypeName());
        }
        setIssueTypeMap(issueTypes);

        // ユーザ情報を設定
        UserListDto userList = _userManagementService
                .searchUsers(new UserSearchConditionDto());
        Map<String, String> users = new HashMap<String, String>();
        for (UserDto user : userList.getUserList()) {
            users.put(user.getFullName(), user.getFullName());
        }
        setRegistrantMap(users);
        setRepresentativeMap(users);

        // 表示用のViewHelperを設定しておく
        ViewHelper helper = ViewHelper.getInstance();
        setHelper(helper);

        // ステータスを設定
        setStatusMap(helper.getStatusMap());

        // トランザクションのコミット
        connection.commit();

        // 画面遷移
        return "success";
    }
}
