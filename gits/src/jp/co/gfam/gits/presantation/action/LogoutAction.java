package jp.co.gfam.gits.presantation.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

/**
 * @author Kenichi Masuda
 *
 */
public class LogoutAction implements SessionAware {

    /*
     * (非 Javadoc)
     *
     * @see
     * org.apache.struts2.interceptor.SessionAware#setSession(java.util.Map)
     */
    @Override
    public void setSession(Map<String, Object> session) {
        // TODO 自動生成されたメソッド・スタブ
    }

    /**
     * このアクションを実行します。
     *
     * @return
     * @throws Exception
     */
    @Action(value = "/logout", results = { @Result(name = "success",
            location = "login.jsp") })
    public String execute() throws Exception {
        // TODO セッション情報の破棄
        return "success";
    }
}
