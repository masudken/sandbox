package jp.co.gfam.gits.presantation.action;

import java.sql.Connection;

import jp.co.gfam.gits.business.service.AuthenticationService;
import jp.co.gfam.gits.business.service.impl.AuthenticationServiceImpl;
import jp.co.gfam.gits.common.context.ConnectionContext;
import jp.co.gfam.gits.common.database.ConnectionManager;

/**
 * このクラスはログイン用のアクションクラスです。
 *
 * @author Kenichi Masuda
 */
public class LoginAction {

    // TODO 一旦インスタンスを直接生成
    private AuthenticationService service = new AuthenticationServiceImpl();

    private String _userName = null;

    private String _password = null;

    /**
     * このアクションを実行します。
     *
     * @return
     * @throws Exception
     */
    public String execute() throws Exception {

        // TODO サービスにIntercepterを適用する形でトランザクション管理をしたい
        // Action単位ならできるけど・・・
        // コネクションの取得とトランザクションの開始
        Connection connection = ConnectionManager.getInstance()
                .openConnection();
        ConnectionContext.getContext().SetConnection(connection);

        // サービスの実行
        service.authenticate(_userName, _password);

        // トランザクションのコミット

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
}
