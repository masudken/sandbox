package jp.co.gfam.gits.business.authentication;

/**
 * この例外は、指定されたユーザのパスワードが不正な値の場合にスローされます。
 *
 * @author Kenichi Masuda
 */
public class BadPasswordException extends AuthenticationException {

    /**
     * シリアライズバージョンID
     */
    private static final long serialVersionUID = 2709819352482145170L;

    /**
     * 指定された詳細メッセージを持つ {@code BadPasswordException} を構築します。
     *
     * @param message 詳細メッセージ
     */
    public BadPasswordException(String message) {
        super(message);
    }
}
