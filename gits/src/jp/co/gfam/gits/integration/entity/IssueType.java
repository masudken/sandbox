package jp.co.gfam.gits.integration.entity;

import java.util.Date;

/**
 * このクラスは課題種別を表現するドメインモデルです。
 *
 * @author Kenichi Masuda
 */
public class IssueType {

    /**
     * 課題種別コード
     */
    private String _issueTypeCode;

    /**
     * 課題種別名称
     */
    private String _issueTypeName;

    /**
     * 更新日時
     */
    private Date _updateDateTime;

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
     * 課題種別名称を取得します。
     *
     * @return 課題種別名称
     */
    public String getIssueTypeName() {
        return _issueTypeName;
    }

    /**
     * 課題種別名称を設定します。
     *
     * @param issueTypeName 課題種別名称
     */
    public void setIssueTypeName(String issueTypeName) {
        _issueTypeName = issueTypeName;
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
