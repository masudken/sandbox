package jp.co.gfam.gits.presantation.action;

import java.sql.Connection;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

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

    // TODO 一旦インスタンスを直接生成
    private AuthenticationService service = new AuthenticationServiceImpl();

    private String _userName = null;

    private String _password = null;

    private String _message = null;

    /**
     * このアクションを実行します。
     *
     * @return
     * @throws Exception
     */
    @Action(value = "/login", results = { @Result(name = "success",
            location = "login.jsp") })
    public String show() throws Exception {
        return "success";
    }

    /**
     * このアクションを実行します。
     *
     * @return
     * @throws Exception
     */
    @Action(value = "/auth", results = { @Result(name = "success",
            type = "chain",
            location = "home") })
    public String execute() throws Exception {

        // TODO サービスにIntercepterを適用する形でトランザクション管理をしたい
        // Action単位ならできるけど・・・
        // コネクションの取得とトランザクションの開始
        Connection connection = ConnectionManager.getInstance()
                .openConnection();
        connection.setAutoCommit(false);
        ConnectionContext.getContext().SetConnection(connection);

        // サービスの実行
        service.authenticate(_userName, _password);

        // トランザクションのコミット
        connection.commit();

        // 画面遷移
        return "success";
    }

    public void setAuthenticationService(AuthenticationService service) {
        this.service = service;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public void setPassword(String password) {
        _password = password;
    }

    public void setMessage(String message) {
        _message = message;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        // TODO 自動生成されたメソッド・スタブ
    }
}
