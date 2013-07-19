package jp.co.gfam.gits.presantation.action;

import java.sql.Connection;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import jp.co.gfam.gits.business.core.IssueManagementService;
import jp.co.gfam.gits.business.core.IssueManagementServiceImpl;
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

    /**
     * 課題管理サービス
     */
    private IssueManagementService _service = new IssueManagementServiceImpl();

    /** 入力値 */
    private Integer _issueId = null;
    private String _issueType = null;
    private String _title = null;
    private String _registrant = null;
    private String _representative = null;
    private String _status = null;

    /** 設定値 */
    private IssueListDto _issueList = null;

    /**
     * このアクションを実行します。
     *
     * @return
     * @throws Exception
     */
    @Action(value = "/search", results = { @Result(name = "success",
            location = "home.jsp") })
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
        condition.setIssueTypeCode(StringUtils.trimToNull(_issueType));
        condition.setTitle(StringUtils.trimToNull(_title));
        condition.setRegistrant(StringUtils.trimToNull(_registrant));
        condition.setRepresentative(StringUtils.trimToNull(_representative));
        condition.setStatus(StringUtils.trimToNull(_status));

        // サービスの実行
        IssueListDto listDto = _service.searchIssues(condition);

        // 検索結果を設定
        _issueList = listDto;

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

    public IssueListDto getIssueList() {
        return _issueList;
    }

    public void setIssueManagementService(IssueManagementService service) {
        _service = service;
    }
}
