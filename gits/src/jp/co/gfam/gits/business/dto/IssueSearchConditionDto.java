package jp.co.gfam.gits.business.dto;

import java.io.Serializable;

/**
 * このクラスは課題検索条件のデータトランスファーオブジェクトです。
 *
 * @author Kenichi Masuda
 */
public class IssueSearchConditionDto implements Serializable {

    /**
     * シリアライズ用バージョンID
     */
    private static final long serialVersionUID = -3322369183123195706L;

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
     * 起票者
     */
    private String _registrant;

    /**
     * 担当者
     */
    private String _representative;

    /**
     * ステータス
     */
    private String _status;

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
     * 起票者を取得します。
     *
     * @return 起票者
     */
    public String getRegistrant() {
        return _registrant;
    }

    /**
     * 起票者を設定します。
     *
     * @param registrant 起票者
     */
    public void setRegistrant(String registrant) {
        _registrant = registrant;
    }

    /**
     * 担当者を取得します。
     *
     * @return 担当者
     */
    public String getRepresentative() {
        return _representative;
    }

    /**
     * 担当者を設定します。
     *
     * @param representativeId 担当者
     */
    public void setRepresentative(String representative) {
        _representative = representative;
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
}
