package jp.co.gfam.gits.integration.dao;

/**
 * このクラスはユーザ情報の検索条件を表現します。
 *
 * @author Kenichi Masuda
 */
public class UserCriteria {

    /**
     * ユーザID
     */
    private Integer _userId;

    /**
     * ユーザ名
     */
    private String _userName;

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
     * 検索条件が空かどうかを判定します。
     *
     * @param 検索条件が空の場合 {@code true} 、それ以外の場合は {@code false}
     */
    public boolean isEmpty() {
        if (_userId != null) {
            return false;
        }
        if (_userName != null) {
            return false;
        }
        if (_firstName != null) {
            return false;
        }
        if (_lastName != null) {
            return false;
        }
        if (_mailAddress != null) {
            return false;
        }
        return true;
    }
}