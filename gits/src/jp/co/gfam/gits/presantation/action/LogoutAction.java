package jp.co.gfam.gits.presantation.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 * このクラスはログアウト用のアクションクラスです。
 *
 * @author Kenichi Masuda
 */
public class LogoutAction implements SessionAware {

    /**
     * HTTPセッション
     */
    private Map<String, Object> _session = null;

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
     * ログアウトアクションを実行します。
     *
     * @return 遷移先情報
     * @throws Exception 何らかの例外が発生した場合
     */
    @Action(value = "/logout", results = { @Result(name = "success",
            location = "login.jsp") })
    public String execute() throws Exception {

        // セッションを破棄
        if (_session instanceof SessionMap) {
            ((SessionMap<String, Object>) _session).invalidate();
        }

        return "success";
    }
}
