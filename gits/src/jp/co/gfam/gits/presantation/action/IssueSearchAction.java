package jp.co.gfam.gits.presantation.action;

import java.sql.Connection;

import jp.co.gfam.gits.business.core.IssueManagementService;
import jp.co.gfam.gits.common.context.ConnectionContext;
import jp.co.gfam.gits.common.database.ConnectionManager;
import jp.co.gfam.gits.common.dto.IssueListDto;
import jp.co.gfam.gits.common.dto.IssueSearchConditionDto;

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
    public String execute() throws Exception {

        // TODO サービスにIntercepterを適用する形でトランザクション管理をしたい
        // Action単位ならできるけど・・・
        // コネクションの取得とトランザクションの開始
        Connection connection = ConnectionManager.getInstance()
                .openConnection();
        ConnectionContext.getContext().SetConnection(connection);

        // 検索条件の生成
        IssueSearchConditionDto condition = new IssueSearchConditionDto();
        condition.setIssueId(_issueId);

        // サービスの実行
        IssueListDto listDto = _issueManagementService.searchIssues(condition);

        // トランザクションのコミット

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
