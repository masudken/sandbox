package jp.co.gfam.gits.presantation.action;

import java.sql.Connection;
import java.util.Map;

import jp.co.gfam.gits.business.core.IssueManagementService;
import jp.co.gfam.gits.business.core.IssueManagementServiceImpl;
import jp.co.gfam.gits.business.dto.IssueDto;
import jp.co.gfam.gits.business.dto.IssueListDto;
import jp.co.gfam.gits.business.dto.IssueSearchConditionDto;
import jp.co.gfam.gits.common.connection.ConnectionContext;
import jp.co.gfam.gits.common.connection.ConnectionManager;
import jp.co.gfam.gits.presantation.util.ViewHelper;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

/**
 * このクラスは課題詳細画面表示用のアクションクラスです。
 *
 * @author Kenichi Masuda
 */
public class IssueDetailAction implements SessionAware {

    /**
     * 課題管理サービス
     */
    private IssueManagementService _issueManagementService = new IssueManagementServiceImpl();

    /**
     * HTTPセッション
     */
    private Map<String, Object> _session = null;

    /**
     * ViewHelper
     */
    private ViewHelper _helper = null;

    /**
     * 課題番号
     */
    private Integer _issueId = null;

    /**
     * 課題
     */
    private IssueDto _issue = null;

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
     * 課題詳細表示アクションを実行します。
     *
     * @return 遷移先情報
     * @throws Exception 何らかの例外が発生した場合
     */
    @Action(value = "/detail", results = { @Result(name = "success",
            location = "detail.jsp") })
    public String show() throws Exception {

        // コネクションの取得とトランザクションの開始
        Connection connection = ConnectionManager.getInstance()
                .openConnection();
        connection.setAutoCommit(false);
        ConnectionContext.getContext().SetConnection(connection);

        // 検索条件の生成
        IssueSearchConditionDto condition = new IssueSearchConditionDto();
        condition.setIssueId(_issueId);

        // サービスの実行
        IssueListDto listDto = _issueManagementService.searchIssues(condition);

        // 課題を取得
        IssueDto issue = listDto.getIssue(_issueId);

        // 課題を設定
        setIssue(issue);

        // 課題をセッションに格納
        _session.put("ISSUE", issue);

        // 表示用のViewHelperを設定しておく
        setHelper(ViewHelper.getInstance());

        return "success";
    }
}
