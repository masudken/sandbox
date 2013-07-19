package jp.co.gfam.gits.presantation.action;

import java.sql.Connection;
import java.util.Date;
import java.util.Map;

import jp.co.gfam.gits.business.core.IssueManagementService;
import jp.co.gfam.gits.business.core.IssueManagementServiceImpl;
import jp.co.gfam.gits.business.dto.IssueDto;
import jp.co.gfam.gits.business.dto.IssueTypeDto;
import jp.co.gfam.gits.business.dto.UserDto;
import jp.co.gfam.gits.common.connection.ConnectionContext;
import jp.co.gfam.gits.common.connection.ConnectionManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

/**
 * このクラスは課題登録用のアクションクラスです。
 *
 * @author Kenichi Masuda
 */
public class IssueRegisterAction implements SessionAware {

    /**
     * 課題管理サービス
     */
    private IssueManagementService _service = new IssueManagementServiceImpl();

    /** 入力値 */
    private String _issueType = null;
    private String _title = null;
    private String _description = null;
    private String _status = null;
    private String _priority = null;
    private String _registrant = null;
    private String _representative = null;
    private Date _startDate = null;
    private Date _endDate = null;
    private Integer _progress = null;
    private Integer _cost = null;

    @Override
    public void setSession(Map<String, Object> session) {
    }

    /**
     * このアクションを実行します。
     *
     * @return
     * @throws Exception
     */
    @Action(value = "/input", results = { @Result(name = "success",
            location = "input.jsp") })
    public String show() throws Exception {
        return "success";
    }

    /**
     * このアクションを実行します。
     *
     * @return
     * @throws Exception
     */
    @Action(value = "/register", results = { @Result(name = "success",
            location = "detail.jsp") })
    public String execute() throws Exception {

        // コネクションの取得とトランザクションの開始
        Connection connection = ConnectionManager.getInstance()
                .openConnection();
        connection.setAutoCommit(false);
        ConnectionContext.getContext().SetConnection(connection);

        IssueDto issue = new IssueDto();
        issue.setTitle(StringUtils.trimToNull(_title));
        issue.setDescription(StringUtils.trimToNull(_description));
        issue.setStatus(StringUtils.trimToNull(_status));
        issue.setPriority(StringUtils.trimToNull(_priority));
        issue.setStartDate(_startDate);
        issue.setEndDate(_endDate);
        issue.setProgress(_progress);
        issue.setCost(_cost);

        IssueTypeDto issueType = new IssueTypeDto();
        issueType.setIssueTypeCode(StringUtils.trimToNull(_issueType));
        issue.setIssueType(issueType);

        UserDto registrant = new UserDto();
        registrant.setFullName(StringUtils.trimToNull(_registrant));
        issue.setRegistrant(registrant);

        UserDto representative = new UserDto();
        representative.setFullName(StringUtils.trimToNull(_representative));
        issue.setRepresentative(representative);

        // サービスの実行
        _service.registerIssue(issue);

        // トランザクションのコミット
        connection.commit();

        return "success";
    }

    public void setIssueType(String issueType) {
        _issueType = issueType;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public void setStatus(String status) {
        _status = status;
    }

    public void setPriority(String priority) {
        _priority = priority;
    }

    public void setRegistrant(String registrant) {
        _registrant = registrant;
    }

    public void setRepresentative(String representative) {
        _representative = representative;
    }

    public void setStartDate(Date startDate) {
        _startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        _endDate = endDate;
    }

    public void setProgress(Integer progress) {
        _progress = progress;
    }

    public void setCost(Integer cost) {
        _cost = cost;
    }

    public void setIssueManagementService(IssueManagementService service) {
        _service = service;
    }
}
