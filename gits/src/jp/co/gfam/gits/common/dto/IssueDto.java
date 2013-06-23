package jp.co.gfam.gits.common.dto;

import java.util.Date;

/**
 * このクラスは課題情報のデータトランスファーオブジェクトです。
 *
 * @author Kenichi Masuda
 */
public class IssueDto {

    /**
     * 課題番号
     */
    private int _issueId;

    /**
     * 課題種別
     */
    private IssueTypeDto _issueType;

    /**
     * タイトル
     */
    private String _title;

    /**
     * 説明
     */
    private String _discription;

    /**
     * 起票者
     */
    private UserDto _registrant;

    /**
     * 起票日
     */
    private Date _registerDate;

    /**
     * 担当者
     */
    private UserDto _representative;

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
    private short _progress;

    /**
     * 工数
     */
    private short _cost;

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
    public int getIssueId() {
        return _issueId;
    }

    /**
     * 課題番号を設定します。
     *
     * @param issueId 課題番号
     */
    public void setIssueId(int issueId) {
        _issueId = issueId;
    }

    /**
     * 課題種別を取得します。
     *
     * @return 課題種別
     */
    public IssueTypeDto getIssueType() {
        return _issueType;
    }

    /**
     * 課題種別を設定します。
     *
     * @param issueType 課題種別
     */
    public void setIssueType(IssueTypeDto issueType) {
        _issueType = issueType;
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
    public String getDiscription() {
        return _discription;
    }

    /**
     * 説明を設定します。
     *
     * @param discription 説明
     */
    public void setDiscription(String discription) {
        _discription = discription;
    }

    /**
     * 起票者を取得します。
     *
     * @return 起票者
     */
    public UserDto getRegistrant() {
        return _registrant;
    }

    /**
     * 起票者を設定します。
     *
     * @param registrant 起票者
     */
    public void setRegistrant(UserDto registrant) {
        _registrant = registrant;
    }

    /**
     * 起票日を取得します。
     *
     * @return 起票日
     */
    public Date getRegisterdDate() {
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
     * 担当者を取得します。
     *
     * @return 担当者
     */
    public UserDto getRepresentative() {
        return _representative;
    }

    /**
     * 担当者を設定します。
     *
     * @param representative 担当者
     */
    public void setRepresentative(UserDto representative) {
        _representative = representative;
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
    public short getProgress() {
        return _progress;
    }

    /**
     * 進捗を設定します。
     *
     * @param progress 進捗
     */
    public void setProgress(short progress) {
        _progress = progress;
    }

    /**
     * 工数を取得します。
     *
     * @return 工数
     */
    public short getCost() {
        return _cost;
    }

    /**
     * 工数を設定します。
     *
     * @param cost 工数
     */
    public void setCost(short cost) {
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
