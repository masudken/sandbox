package jp.co.gfam.gits.presantation.action;

import java.sql.Connection;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import jp.co.gfam.gits.business.authentication.AuthenticationException;
import jp.co.gfam.gits.business.authentication.AuthenticationService;
import jp.co.gfam.gits.business.authentication.AuthenticationServiceImpl;
import jp.co.gfam.gits.common.connection.ConnectionContext;
import jp.co.gfam.gits.common.connection.ConnectionManager;

/**
 * このクラスはログイン用のアクションクラスです。
 *
 * @author Kenichi Masuda
 */
public class LoginAction implements SessionAware {

    /**
     * 認証サービス
     */
    private AuthenticationService _service = new AuthenticationServiceImpl();

    /**
     * HTTPセッション
     */
    @SuppressWarnings("unused")
    private Map<String, Object> _session = null;

    /**
     * ユーザ名
     */
    private String _userName = null;

    /**
     * パスワード
     */
    private String _password = null;

    /**
     * メッセージ
     */
    private String _message = null;

    /**
     * メッセージタイプ
     */
    private String _messageType = null;

    /**
     * 認証サービスを設定します。
     *
     * @param service 認証サービス
     */
    public void setAuthenticationService(AuthenticationService service) {
        _service = service;
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
     * ユーザ名を取得します。
     *
     * @return ユーザ名
     */
    public String getUserName() {
        return _userName;
    }

    /**
     * ユーザ名を設定します。
     *
     * @param userName ユーザ名
     */
    public void setUserName(String userName) {
        _userName = userName;
    }

    /**
     * パスワードを取得します。
     *
     * @return パスワード
     */
    public String getPassword() {
        return _password;
    }

    /**
     * パスワードを設定します。
     *
     * @param password パスワード
     */
    public void setPassword(String password) {
        _password = password;
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
     * ログイン画面表示アクションを実行します。
     *
     * @return 遷移先情報
     * @throws Exception 何らかの例外が発生した場合
     */
    @Action(value = "/login", results = { @Result(name = "success",
            location = "login.jsp") })
    public String show() throws Exception {
        return "success";
    }

    /**
     * ログインアクションを実行します。
     *
     * @return 遷移先情報
     * @throws Exception 何らかの例外が発生した場合
     */
    @Action(value = "/auth", results = {
            @Result(name = "success", type = "chain", location = "home"),
            @Result(name = "error", location = "login.jsp") })
    public String execute() throws Exception {

        // コネクションの取得とトランザクションの開始
        Connection connection = ConnectionManager.getInstance()
                .openConnection();
        connection.setAutoCommit(false);
        ConnectionContext.getContext().SetConnection(connection);

        try {
            // サービスの実行
            _service.authenticate(_userName, _password);
        } catch (AuthenticationException ae) {

            // メッセージ設定
            setMessage("ユーザ名、もしくはパスワードが異なります。");
            setMessageType("ERROR");

            // トランザクションのロールバック
            connection.rollback();
            return "error";
        }

        // トランザクションのコミット
        connection.commit();
        return "success";
    }
}
