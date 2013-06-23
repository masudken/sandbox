package jp.co.gfam.gits.integration.entity;

import java.util.Date;

/**
 * このクラスはユーザ情報を表現するドメインモデルです。
 *
 * @author Kenichi Masuda
 */
public class User {

    /**
     * ユーザID
     */
    private Integer _userId;

    /**
     * ユーザ名
     */
    private String _userName;

    /**
     * パスワード
     */
    private String _password;

    /**
     * パスワード有効期限
     */
    private Date _expirationDate;

    /**
     * 名
     */
    private String _firstName;

    /**
     * 姓
     */
    private String _lastName;

    /**
     * メールアドレス
     */
    private String _mailAddress;

    /**
     * 更新日時
     */
    private Date _updateDateTime;

    /**
     * ユーザIDを取得します。
     *
     * @return ユーザID
     */
    public Integer getUserId() {
        return _userId;
    }

    /**
     * ユーザIDを設定します。
     *
     * @param userId ユーザID
     */
    public void setUserId(Integer userId) {
        _userId = userId;
    }

    /**
     * ユーザ名を取得します。
     *
     * @return ユーザ名
     */
    public String getUserName() {
        return _userName;
    }

    /**
     * ユーザ名を設定します。
     *
     * @param userName ユーザ名
     */
    public void setUserName(String userName) {
        _userName = userName;
    }

    /**
     * パスワードを取得します。
     *
     * @return パスワード
     */
    public String getPassword() {
        return _password;
    }

    /**
     * パスワードを設定します。
     *
     * @param title パスワード
     */
    public void setPassword(String password) {
        _password = password;
    }

    /**
     * パスワード有効期限を取得します。
     *
     * @return パスワード有効期限
     */
    public Date getExpirationDate() {
        return _expirationDate;
    }

    /**
     * パスワード有効期限を設定します。
     *
     * @param expirationDate パスワード有効期限
     */
    public void setExpirationDate(Date expirationDate) {
        _expirationDate = expirationDate;
    }

    /**
     * 名を取得します。
     *
     * @return 名
     */
    public String getFirstName() {
        return _firstName;
    }

    /**
     * 名を設定します。
     *
     * @param firstName 名
     */
    public void setFirstName(String firstName) {
        _firstName = firstName;
    }

    /**
     * 姓を取得します。
     *
     * @return 姓
     */
    public String getLastName() {
        return _lastName;
    }

    /**
     * 姓を設定します。
     *
     * @param lastName 姓
     */
    public void setLastName(String lastName) {
        _lastName = lastName;
    }

    /**
     * メールアドレスを取得します。
     *
     * @return メールアドレス
     */
    public String getMailAddress() {
        return _mailAddress;
    }

    /**
     * メールアドレスを設定します。
     *
     * @param mailAddress メールアドレス
     */
    public void setMailAddress(String mailAddress) {
        _mailAddress = mailAddress;
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
