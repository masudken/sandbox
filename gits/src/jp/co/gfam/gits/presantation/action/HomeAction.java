package jp.co.gfam.gits.presantation.action;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.gfam.gits.business.core.IssueManagementService;
import jp.co.gfam.gits.business.core.IssueManagementServiceImpl;
import jp.co.gfam.gits.business.core.UserManagementService;
import jp.co.gfam.gits.business.core.UserManagementServiceImpl;
import jp.co.gfam.gits.business.dto.IssueTypeDto;
import jp.co.gfam.gits.business.dto.UserDto;
import jp.co.gfam.gits.business.dto.UserListDto;
import jp.co.gfam.gits.business.dto.UserSearchConditionDto;
import jp.co.gfam.gits.common.connection.ConnectionContext;
import jp.co.gfam.gits.common.connection.ConnectionManager;
import jp.co.gfam.gits.presantation.util.ViewHelper;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

/**
 * このクラスはホーム画面表示用のアクションクラスです。
 *
 * @author Kenichi Masuda
 */
public class HomeAction implements SessionAware {

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
     * ホーム画面表示アクションを実行します。
     *
     * @return 遷移先情報
     * @throws Exception 何らかの例外が発生した場合
     */
    @Action(value = "/home", results = { @Result(name = "success",
            location = "home.jsp") })
    public String show() throws Exception {

        // コネクションの取得とトランザクションの開始
        Connection connection = ConnectionManager.getInstance()
                .openConnection();
        connection.setAutoCommit(false);
        ConnectionContext.getContext().SetConnection(connection);

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

        // ステータスを設定
        setStatusMap(ViewHelper.getInstance().getStatusMap());

        // トランザクションのコミット
        connection.commit();

        // 画面遷移
        return "success";
    }
}
