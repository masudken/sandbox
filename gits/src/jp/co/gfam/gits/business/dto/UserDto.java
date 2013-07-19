package jp.co.gfam.gits.business.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * このクラスはユーザ情報のデータトランスファーオブジェクトです。
 *
 * @author Kenichi Masuda
 */
public class UserDto implements Serializable {

    /**
     * シリアライズ用バージョンID
     */
    private static final long serialVersionUID = -2758437838382270883L;

    /**
     * ユーザID
     */
    private int _userId;

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
     * 姓名
     */
    private String _fullName;

    /**
     * メールアドレス
     */
    private String _mailAddress;

    /**
     * ユーザIDを取得します。
     *
     * @return ユーザID
     */
    public int getUserId() {
        return _userId;
    }

    /**
     * ユーザIDを設定します。
     *
     * @param userId ユーザID
     */
    public void setUserId(int userId) {
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
     * 姓名を取得します。
     *
     * @return 姓名
     */
    public String getFullName() {
        return _fullName;
    }

    /**
     * 姓名を設定します。
     *
     * @param fullName 姓名
     */
    public void setFullName(String fullName) {
        _fullName = fullName;
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
}
