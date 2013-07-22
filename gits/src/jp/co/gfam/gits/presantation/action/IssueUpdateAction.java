package jp.co.gfam.gits.presantation.action;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.gfam.gits.business.core.IssueManagementService;
import jp.co.gfam.gits.business.core.IssueManagementServiceImpl;
import jp.co.gfam.gits.business.core.UserManagementService;
import jp.co.gfam.gits.business.core.UserManagementServiceImpl;
import jp.co.gfam.gits.business.dto.IssueDto;
import jp.co.gfam.gits.business.dto.IssueTypeDto;
import jp.co.gfam.gits.business.dto.UserDto;
import jp.co.gfam.gits.business.dto.UserListDto;
import jp.co.gfam.gits.business.dto.UserSearchConditionDto;
import jp.co.gfam.gits.common.connection.ConnectionContext;
import jp.co.gfam.gits.common.connection.ConnectionManager;
import jp.co.gfam.gits.presantation.util.ViewHelper;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

/**
 * このクラスは課題更新用のアクションクラスです。
 *
 * @author Kenichi Masuda
 */
public class IssueUpdateAction implements SessionAware {

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
     * 優先度マップ
     */
    private Map<String, String> _priorityMap = null;

    /**
     * 起票者マップ
     */
    private Map<String, String> _registrantMap = null;

    /**
     * 担当者マップ
     */
    private Map<String, String> _representativeMap = null;

    /**
     * 表示モード
     */
    private String _dispMode = null;

    /**
     * 課題番号
     */
    private Integer _issueId = null;

    /**
     * 課題
     */
    private IssueDto _issue = null;

    /**
     * 課題種別
     */
    private String _issueType = null;

    /**
     * タイトル
     */
    private String _title = null;

    /**
     * 説明
     */
    private String _description = null;

    /**
     * ステータス
     */
    private String _status = null;

    /**
     * 優先度
     */
    private String _priority = null;

    /**
     * 起票者
     */
    private String _registrant = null;

    /**
     * 担当者
     */
    private String _representative = null;

    /**
     * 開始日
     */
    private Date _startDate = null;

    /**
     * 終了日
     */
    private Date _endDate = null;

    /**
     * 進捗
     */
    private Integer _progress = null;

    /**
     * 工数
     */
    private Integer _cost = null;

    /**
     * メッセージ
     */
    private String _message = null;

    /**
     * メッセージタイプ
     */
    private String _messageType = null;

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
     * 優先度マップを取得します。
     *
     * @return 優先度マップ
     */
    public Map<String, String> getPriorityMap() {
        return _priorityMap;
    }

    /**
     * 優先度マップを設定します。
     *
     * @param priorityMap 優先度マップ
     */
    public void setPriorityMap(Map<String, String> priorityMap) {
        _priorityMap = priorityMap;
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
     * 表示モードを取得します。
     *
     * @return 表示モード
     */
    public String getDispMode() {
        return _dispMode;
    }

    /**
     * 表示モードを設定します。
     *
     * @param dispMode 表示モード
     */
    public void setDispMode(String dispMode) {
        _dispMode = dispMode;
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
     * 課題を取得します。
     *
     * @return 課題
     */
    public IssueDto getIssue() {
        return _issue;
    }

    /**
     * 課題を設定します。
     *
     * @param issue 課題
     */
    public void setIssue(IssueDto issue) {
        _issue = issue;
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
     * 説明を取得します。
     *
     * @return 説明
     */
    public String getDescription() {
        return _title;
    }

    /**
     * 説明を設定します。
     *
     * @param description 説明
     */
    public void setDescription(String description) {
        _description = description;
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
     * 優先度を取得します。
     *
     * @return 優先度
     */
    public String getPriority() {
        return _priority;
    }

    /**
     * 優先度を設定します。
     *
     * @param priority 優先度
     */
    public void setPriority(String priority) {
        _priority = priority;
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
     * 開始日を取得します。
     *
     * @return 開始日
     */
    public Date getStartDate() {
        return _startDate;
    }

    /**
     * 開始日を設定します。
     *
     * @param startDate 開始日
     */
    public void setStartDate(Date startDate) {
        _startDate = startDate;
    }

    /**
     * 終了日を取得します。
     *
     * @return 終了日
     */
    public Date getEndDate() {
        return _endDate;
    }

    /**
     * 終了日を設定します。
     *
     * @param endDate 終了日
     */
    public void setEndDate(Date endDate) {
        _endDate = endDate;
    }

    /**
     * 進捗を取得します。
     *
     * @return 進捗
     */
    public Integer getProgress() {
        return _progress;
    }

    /**
     * 進捗を設定します。
     *
     * @param progress 進捗
     */
    public void setProgress(Integer progress) {
        _progress = progress;
    }

    /**
     * 工数を取得します。
     *
     * @return 工数
     */
    public Integer getCost() {
        return _cost;
    }

    /**
     * 工数を設定します。
     *
     * @param cost 工数
     */
    public void setCost(Integer cost) {
        _cost = cost;
    }

    /**
     * メッセージを取得します。
     *
     * @return メッセージ
     */
    public String getMessage() {
        return _message;
    }

    /**
     * メッセージを設定します。
     *
     * @param message メッセージ
     */
    public void setMessage(String message) {
        _message = message;
    }

    /**
     * メッセージタイプを取得します。
     *
     * @return メッセージタイプ
     */
    public String getMessageType() {
        return _messageType;
    }

    /**
     * メッセージタイプを設定します。
     *
     * @param messageType メッセージタイプ
     */
    public void setMessageType(String messageType) {
        _messageType = messageType;
    }

    /**
     * 課題更新画面表示アクションを実行します。
     *
     * @return 遷移先情報
     * @throws Exception 何らかの例外が発生した場合
     */
    @Action(value = "/update", results = { @Result(name = "success",
            location = "detail.jsp") })
    public String show() throws Exception {

        // コネクションの取得とトランザクションの開始
        Connection connection = ConnectionManager.getInstance()
                .openConnection();
        connection.setAutoCommit(false);
        ConnectionContext.getContext().SetConnection(connection);

        // セッションから課題を取得
        IssueDto issue = (IssueDto) _session.get("ISSUE");

        // 課題を設定
        setIssue(issue);

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

        // 優先度を設定
        setPriorityMap(helper.getPriorityMap());

        // トランザクションのコミット
        connection.commit();

        return "success";
    }

    /**
     * 課題更新アクションを実行します。
     *
     * @return 遷移先情報
     * @throws Exception 何らかの例外が発生した場合
     */
    @Action(value = "/do-update", results = { @Result(name = "success",
            type = "chain",
            location = "detail") })
    public String execute() throws Exception {

        // コネクションの取得とトランザクションの開始
        Connection connection = ConnectionManager.getInstance()
                .openConnection();
        connection.setAutoCommit(false);
        ConnectionContext.getContext().SetConnection(connection);

        IssueDto issue = new IssueDto();
        issue.setIssueId(_issueId);
        issue.setTitle(StringUtils.trimToNull(_title));
        issue.setDescription(StringUtils.trimToNull(_description));
        issue.setStatus(StringUtils.trimToNull(_status));
        issue.setPriority(StringUtils.trimToNull(_priority));
        issue.setStartDate(_startDate);
        issue.setEndDate(_endDate);
        issue.setProgress(_progress);
        issue.setCost(_cost);

        IssueTypeDto issueType = new IssueTypeDto();
        issueType.setIssueTypeCode(StringUtils.trimToNull(_issueType));
        issue.setIssueType(issueType);

        UserDto registrant = new UserDto();
        registrant.setFullName(StringUtils.trimToNull(_registrant));
        issue.setRegistrant(registrant);

        UserDto representative = new UserDto();
        representative.setFullName(StringUtils.trimToNull(_representative));
        issue.setRepresentative(representative);

        // サービスの実行
        _issueManagementService.updateIssue(issue);

        // メッセージ設定
        setMessage("課題 " + issue.getIssueId() + " を更新しました。");
        setMessageType("INFO");

        // トランザクションのコミット
        connection.commit();

        return "success";
    }
}
