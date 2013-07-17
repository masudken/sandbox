package jp.co.gfam.gits.presantation.action;

import java.sql.Connection;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import jp.co.gfam.gits.business.core.IssueManagementService;
import jp.co.gfam.gits.business.dto.IssueListDto;
import jp.co.gfam.gits.business.dto.IssueSearchConditionDto;
import jp.co.gfam.gits.common.connection.ConnectionContext;
import jp.co.gfam.gits.common.connection.ConnectionManager;

/**
 * このクラスは課題検索用のアクションクラスです。
 *
 * @author Kenichi Masuda
 */
public class IssueSearchAction {

    // TODO 一旦インスタンスを直接生成
    private IssueManagementService _issueManagementService = null;

    private Integer _issueId = null;

    private String _issueType = null;

    private String _title = null;

    private String _registrant = null;

    private String _representative = null;

    private String _status = null;

    /**
     * このアクションを実行します。
     *
     * @return
     * @throws Exception
     */
    @Action(value = "/search", results = { @Result(name = "success",
            location = "issue_list.jsp") })
    public String execute() throws Exception {

        // TODO サービスにIntercepterを適用する形でトランザクション管理をしたい
        // Action単位ならできるけど・・・
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

        // トランザクションのコミット
        connection.commit();

        // 画面遷移
        return "success";
    }

    public void setIssueId(Integer issueId) {
        _issueId = issueId;
    }

    public void setIssueType(String issueType) {
        _issueType = issueType;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public void setRegistrant(String registrant) {
        _registrant = registrant;
    }

    public void setRepresentative(String representative) {
        _representative = representative;
    }

    public void setStatus(String status) {
        _status = status;
    }

    public void setIssueManagementService(
            IssueManagementService issueManagementService) {
        _issueManagementService = issueManagementService;
    }
}
