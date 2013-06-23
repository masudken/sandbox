package jp.co.gfam.gits.common.dto;

/**
 * このクラスは課題種別情報のデータトランスファーオブジェクトです。
 *
 * @author Kenichi Masuda
 */
public class IssueTypeDto {

    /**
     * 課題種別コード
     */
    private String _issueTypeCode;

    /**
     * 課題種別名
     */
    private String _issueTypeName;

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
     * 課題種別名を取得します。
     *
     * @return 課題種別名
     */
    public String getIssueTypeName() {
        return _issueTypeName;
    }

    /**
     * 課題種別名を設定します。
     *
     * @param issueTypeName 課題種別名
     */
    public void setIssueTypeName(String issueTypeName) {
        _issueTypeName = issueTypeName;
    }
}
