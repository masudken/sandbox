package jp.co.gfam.gits.integration.dao;

public class UserCriteria {

    /**
     * ユーザID
     */
    private Integer userId;

    /**
     * ユーザ名
     */
    private String userName;

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
     * ユーザIDを取得します。
     *
     * @return ユーザID
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * ユーザIDを設定します。
     *
     * @param userId ユーザID
     */
    public void setUserId(Integer userId) {
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
}