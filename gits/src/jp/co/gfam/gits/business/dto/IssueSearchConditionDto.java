package jp.co.gfam.gits.business.dto;

/**
 * このクラスは課題検索条件のデータトランスファーオブジェクトです。
 *
 * @author Kenichi Masuda
 */
public class IssueSearchConditionDto {

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
     * 起票者ID
     */
    private Integer _registrantId;

    /**
     * 担当者IDコード
     */
    private Integer _representativeId;

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
