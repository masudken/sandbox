package jp.co.gfam.gits.presantation.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

/**
 * このクラスは課題詳細画面表示用のアクションクラスです。
 *
 * @author Kenichi Masuda
 */
public class IssueDetailAction implements SessionAware {

    /** 入力値 */
    private Integer _issueId = null;

    /**
     * このアクションを実行します。
     *
     * @return
     * @throws Exception
     */
    @Action(value = "/detail", results = { @Result(name = "success",
            location = "detail.jsp") })
    public String show() throws Exception {
        return "success";
    }

    @Override
    public void setSession(Map<String, Object> session) {
        // TODO 自動生成されたメソッド・スタブ
    }

    public void setIssueId(Integer issueId) {
        _issueId = issueId;
    }
}
