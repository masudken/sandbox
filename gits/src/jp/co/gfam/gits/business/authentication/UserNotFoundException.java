package jp.co.gfam.gits.business.authentication;


/**
 * この例外は、指定されたユーザが存在しない場合にスローされます。
 *
 * @author Kenichi Masuda
 */
public class UserNotFoundException extends AuthenticationException {

    /**
     * シリアライズVersionID
     */
    private static final long serialVersionUID = 2017646430389890284L;

    /**
     * 指定された詳細メッセージを持つ {@code UserNotFoundException} を構築します。
     *
     * @param message 詳細メッセージ
     */
    public UserNotFoundException(String message) {
        super(message);
    }
}
