package jp.co.gfam.gits.common.dto;

import java.util.Date;

/**
 * このクラスはユーザ情報のデータトランスファーオブジェクトです。
 *
 * @author Kenichi Masuda
 */
public class UserDto {

    /**
     * ユーザID
     */
    private int userId;

    /**
     * ユーザ名
     */
    private String userName;

    /**
     * パスワード
     */
    private String password;

    /**
     * パスワード有効期限
     */
    private Date expirationDate;

    /**
     * 名
     */
    private String firstName;

    /**
     * 姓
     */
    private String lastName;

    /**
     * メールアドレス
     */
    private String mailAddress;

    /**
     * 更新日時
     */
    private Date updateDateTime;

    /**
     * ユーザIDを取得します。
     *
     * @return ユーザID
     */
    public int getUserId() {
        return this.userId;
    }

    /**
     * ユーザIDを設定します。
     *
     * @param userId ユーザID
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * ユーザ名を取得します。
     *
     * @return ユーザ名
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * ユーザ名を設定します。
     *
     * @param userName ユーザ名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * パスワードを取得します。
     *
     * @return パスワード
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * パスワードを設定します。
     *
     * @param title パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * パスワード有効期限を取得します。
     *
     * @return パスワード有効期限
     */
    public Date getExpirationDate() {
        return this.expirationDate;
    }

    /**
     * パスワード有効期限を設定します。
     *
     * @param expirationDate パスワード有効期限
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * 名を取得します。
     *
     * @return 名
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * 名を設定します。
     *
     * @param firstName 名
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 姓を取得します。
     *
     * @return 姓
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * 姓を設定します。
     *
     * @param lastName 姓
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * メールアドレスを取得します。
     *
     * @return メールアドレス
     */
    public String getMailAddress() {
        return this.mailAddress;
    }

    /**
     * メールアドレスを設定します。
     *
     * @param mailAddress メールアドレス
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
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
