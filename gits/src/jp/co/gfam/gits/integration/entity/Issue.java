package jp.co.gfam.gits.integration.entity;

import java.util.Date;

/**
 * このクラスは課題情報を表現するドメインモデルです。
 *
 * @author Kenichi Masuda
 */
public class Issue {

    /**
     * 課題番号
     */
    private Integer _issueId;

    /**
     * 課題種別コード
     */
    private String _issueTypeCode;

    /**
     * タイトル
     */
    private String _title;

    /**
     * 説明
     */
    private String _description;

    /**
     * 起票ID
     */
    private Integer _registrantId;

    /**
     * 起票日
     */
    private Date _registerDate;

    /**
     * 担当者ID
     */
    private Integer _representativeId;

    /**
     * 優先度
     */
    private String _priority;

    /**
     * 開始日
     */
    private Date _startDate;

    /**
     * 終了日
     */
    private Date _endDate;

    /**
     * 進捗
     */
    private Integer _progress;

    /**
     * 工数
     */
    private Integer _cost;

    /**
     * ステータス
     */
    private String _status;

    /**
     * 更新日時
     */
    private Date _updateDateTime;

    /**
     * 課題番号を取得します。
     *
     * @return 課題番号
     */
    public Integer getIssueId() {
        return _issueId;
    }

    /**
     * 課題番号を設定します。
     *
     * @param issueId 課題番号
     */
    public void setIssueId(Integer issueId) {
        _issueId = issueId;
    }

    /**
     * 課題種別コードを取得します。
     *
     * @return 課題種別コード
     */
    public String getIssueTypeCode() {
        return _issueTypeCode;
    }

    /**
     * 課題種別コードを設定します。
     *
     * @param issueTypeCode 課題種別コード
     */
    public void setIssueTypeCode(String issueTypeCode) {
        _issueTypeCode = issueTypeCode;
    }

    /**
     * タイトルを取得します。
     *
     * @return タイトル
     */
    public String getTitle() {
        return _title;
    }

    /**
     * タイトルを設定します。
     *
     * @param title タイトル
     */
    public void setTitle(String title) {
        _title = title;
    }

    /**
     * 説明を取得します。
     *
     * @return 説明
     */
    public String getDescription() {
        return _description;
    }

    /**
     * 説明を設定します。
     *
     * @param description 説明
     */
    public void setDescription(String description) {
        _description = description;
    }

    /**
     * 起票者IDを取得します。
     *
     * @return 起票者ID
     */
    public Integer getRegistrantId() {
        return _registrantId;
    }

    /**
     * 起票者IDを設定します。
     *
     * @param registrantId 起票者ID
     */
    public void setRegistrantId(Integer registrantId) {
        _registrantId = registrantId;
    }

    /**
     * 起票日を取得します。
     *
     * @return 起票日
     */
    public Date getRegisterDate() {
        return _registerDate;
    }

    /**
     * 起票日を設定します。
     *
     * @param regsterDate 起票日
     */
    public void setRegisterDate(Date registerDate) {
        _registerDate = registerDate;
    }

    /**
     * 担当者IDを取得します。
     *
     * @return 担当者ID
     */
    public Integer getRepresentativeId() {
        return _representativeId;
    }

    /**
     * 担当者IDを設定します。
     *
     * @param representativeId 担当者ID
     */
    public void setRepresentativeId(Integer representativeId) {
        _representativeId = representativeId;
    }

    /**
     * 優先度を取得します。
     *
     * @return 優先度
     */
    public String getPriority() {
        return _priority;
    }

    /**
     * 優先度を設定します。
     *
     * @param priority 優先度
     */
    public void setPriority(String priority) {
        _priority = priority;
    }

    /**
     * 開始日を取得します。
     *
     * @return 開始日
     */
    public Date getStartDate() {
        return _startDate;
    }

    /**
     * 開始日を設定します。
     *
     * @param startDate 開始日
     */
    public void setStartDate(Date startDate) {
        _startDate = startDate;
    }

    /**
     * 終了日を取得します。
     *
     * @return 終了日
     */
    public Date getEndDate() {
        return _endDate;
    }

    /**
     * 終了日を設定します。
     *
     * @param endDate 終了日
     */
    public void setEndDate(Date endDate) {
        _endDate = endDate;
    }

    /**
     * 進捗を取得します。
     *
     * @return 進捗
     */
    public Integer getProgress() {
        return _progress;
    }

    /**
     * 進捗を設定します。
     *
     * @param progress 進捗
     */
    public void setProgress(Integer progress) {
        _progress = progress;
    }

    /**
     * 工数を取得します。
     *
     * @return 工数
     */
    public Integer getCost() {
        return _cost;
    }

    /**
     * 工数を設定します。
     *
     * @param cost 工数
     */
    public void setCost(Integer cost) {
        _cost = cost;
    }

    /**
     * ステータスを取得します。
     *
     * @return ステータス
     */
    public String getStatus() {
        return _status;
    }

    /**
     * ステータスを設定します。
     *
     * @param status ステータス
     */
    public void setStatus(String status) {
        _status = status;
    }

    /**
     * 更新日時を取得します。
     *
     * @return 更新日時
     */
    public Date getUpdateDateTime() {
        return _updateDateTime;
    }

    /**
     * 更新日時を設定します。
     *
     * @param updateDateTime 更新日時
     */
    public void setUpdateDateTime(Date updateDateTime) {
        _updateDateTime = updateDateTime;
    }
}
