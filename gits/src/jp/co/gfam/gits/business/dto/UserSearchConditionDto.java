package jp.co.gfam.gits.business.dto;

/**
 * このクラスはユーザ検索条件のデータトランスファーオブジェクトです。
 *
 * @author Kenichi Masuda
 */
public class UserSearchConditionDto {

    /**
     * ユーザID
     */
    private Integer _userId;

    /**
     * ユーザ名
     */
    private String _userName;

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
     * 姓名を取得します。
     *
     * @return 姓名
     */
    public String getFulltName() {
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
