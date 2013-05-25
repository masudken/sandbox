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
    private int issueId;

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
    private int registrantId;

    /**
     * 起票日
     */
    private Date registerDate;

    /**
     * 担当者ID
     */
    private int representativeId;

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
    private short progress;

    /**
     * 工数
     */
    private short cost;

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
    public int getIssueId() {
        return this.issueId;
    }

    /**
     * 課題番号を設定します。
     *
     * @param issueId 課題番号
     */
    public void setIssueId(int issueId) {
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
     * �������擾���܂��B
     *
     * @return ����
     */
    public String getDiscription() {
        return this.discription;
    }

    /**
     * ������ݒ肵�܂��B
     *
     * @param discription ����
     */
    public void setDiscription(String discription) {
        this.discription = discription;
    }

    /**
     * �N�[��ID���擾���܂��B
     *
     * @return �N�[��ID
     */
    public int getRegistrantId() {
        return this.registrantId;
    }

    /**
     * �N�[��ID��ݒ肵�܂��B
     *
     * @param registrantId �N�[��ID
     */
    public void setRegistrantId(int registrantId) {
        this.registrantId = registrantId;
    }

    /**
     * �N�[����擾���܂��B
     *
     * @return �N�[��
     */
    public Date getRegisterdDate() {
        return this.registerDate;
    }

    /**
     * �N�[���ݒ肵�܂��B
     *
     * @param regsterDate �N�[��
     */
    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    /**
     * �S����ID���擾���܂��B
     *
     * @return �S����ID
     */
    public int getRepresentativeId() {
        return this.representativeId;
    }

    /**
     * �S����ID��ݒ肵�܂��B
     *
     * @param representativeId �S����ID
     */
    public void setRepresentativeId(int representativeId) {
        this.representativeId = representativeId;
    }

    /**
     * �D��x���擾���܂��B
     *
     * @return �D��x
     */
    public String getPriority() {
        return this.priority;
    }

    /**
     * �D��x��ݒ肵�܂��B
     *
     * @param priority �D��x
     */
    public void setPriority(String priority) {
        this.priority = priority;
    }

    /**
     * �J�n����擾���܂��B
     *
     * @return �J�n��
     */
    public Date getStartDate() {
        return this.startDate;
    }

    /**
     * �J�n���ݒ肵�܂��B
     *
     * @param startDate �J�n��
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * �I������擾���܂��B
     *
     * @return �I����
     */
    public Date getEndDate() {
        return this.endDate;
    }

    /**
     * �I�����ݒ肵�܂��B
     *
     * @param endDate �I����
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * �i�����擾���܂��B
     *
     * @return �i��
     */
    public short getProgress() {
        return this.progress;
    }

    /**
     * �i����ݒ肵�܂��B
     *
     * @param progress �i��
     */
    public void setProgress(short progress) {
        this.progress = progress;
    }

    /**
     * �H�����擾���܂��B
     *
     * @return �H��
     */
    public short getCost() {
        return this.cost;
    }

    /**
     * �H����ݒ肵�܂��B
     *
     * @param cost �H��
     */
    public void setCost(short cost) {
        this.cost = cost;
    }

    /**
     * �X�e�[�^�X���擾���܂��B
     *
     * @return �X�e�[�^�X
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * �X�e�[�^�X��ݒ肵�܂��B
     *
     * @param status �X�e�[�^�X
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * �X�V����擾���܂��B
     *
     * @return �X�V��
     */
    public Date getUpdateDateTime() {
        return this.updateDateTime;
    }

    /**
     * �X�V���ݒ肵�܂��B
     *
     * @param updateDateTime �X�V��
     */
    public void setUpdateDateTime(Date updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
