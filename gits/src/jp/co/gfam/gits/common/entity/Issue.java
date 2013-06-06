package jp.co.gfam.gits.common.entity;

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
    private Integer issueId;

    /**
     * 課題種別
     */
    private String issueType;

    /**
     * タイトル
     */
    private String title;

    /**
     * 説明
     */
    private String discription;

    /**
     * 起票ID
     */
    private Integer registrantId;

    /**
     * 起票日
     */
    private Date registerDate;

    /**
     * 担当者ID
     */
    private Integer representativeId;

    /**
     * 優先度
     */
    private String priority;

    /**
     * 開始日
     */
    private Date startDate;

    /**
     * 終了日
     */
    private Date endDate;

    /**
     * 進捗
     */
    private Short progress;

    /**
     * 工数
     */
    private Short cost;

    /**
     * ステータス
     */
    private String status;

    /**
     * 更新日時
     */
    private Date updateDateTime;

    /**
     * 課題番号を取得します。
     *
     * @return 課題番号
     */
    public Integer getIssueId() {
        return this.issueId;
    }

    /**
     * 課題番号を設定します。
     *
     * @param issueId 課題番号
     */
    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    /**
     * 課題種別を取得します。
     *
     * @return 課題種別
     */
    public String getIssueType() {
        return this.issueType;
    }

    /**
     * 課題種別を設定します。
     *
     * @param issueType 課題種別
     */
    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    /**
     * タイトルを取得します。
     *
     * @return タイトル
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * タイトルを設定します。
     *
     * @param title タイトル
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 説明を取得します。
     *
     * @return 説明
     */
    public String getDiscription() {
        return this.discription;
    }

    /**
     * 説明を設定します。
     *
     * @param discription 説明
     */
    public void setDiscription(String discription) {
        this.discription = discription;
    }

    /**
     * 起票者IDを取得します。
     *
     * @return 起票者ID
     */
    public Integer getRegistrantId() {
        return this.registrantId;
    }

    /**
     * 起票者IDを設定します。
     *
     * @param registrantId 起票者ID
     */
    public void setRegistrantId(Integer registrantId) {
        this.registrantId = registrantId;
    }

    /**
     * 起票日を取得します。
     *
     * @return 起票日
     */
    public Date getRegisterdDate() {
        return this.registerDate;
    }

    /**
     * 起票日を設定します。
     *
     * @param regsterDate 起票日
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * 担当者IDを取得します。
     *
     * @return 担当者ID
     */
    public Integer getRepresentativeId() {
        return this.representativeId;
    }

    /**
     * 担当者IDを設定します。
     *
     * @param representativeId 担当者ID
     */
    public void setRepresentativeId(Integer representativeId) {
        this.representativeId = representativeId;
    }

    /**
     * 優先度を取得します。
     *
     * @return 優先度
     */
    public String getPriority() {
        return this.priority;
    }

    /**
     * 優先度を設定します。
     *
     * @param priority 優先度
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * 開始日を取得します。
     *
     * @return 開始日
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * 開始日を設定します。
     *
     * @param startDate 開始日
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 終了日を取得します。
     *
     * @return 終了日
     */
    public Date getEndDate() {
        return this.endDate;
    }

    /**
     * 終了日を設定します。
     *
     * @param endDate 終了日
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 進捗を取得します。
     *
     * @return 進捗
     */
    public Short getProgress() {
        return this.progress;
    }

    /**
     * 進捗を設定します。
     *
     * @param progress 進捗
     */
    public void setProgress(Short progress) {
        this.progress = progress;
    }

    /**
     * 工数を取得します。
     *
     * @return 工数
     */
    public Short getCost() {
        return this.cost;
    }

    /**
     * 工数を設定します。
     *
     * @param cost 工数
     */
    public void setCost(Short cost) {
        this.cost = cost;
    }

    /**
     * ステータスを取得します。
     *
     * @return ステータス
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * ステータスを設定します。
     *
     * @param status ステータス
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 更新日時を取得します。
     *
     * @return 更新日時
     */
    public Date getUpdateDateTime() {
        return this.updateDateTime;
    }

    /**
     * 更新日時を設定します。
     *
     * @param updateDateTime 更新日時
     */
    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
