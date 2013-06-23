package jp.co.gfam.gits.business.authentication;

/**
 * この例外は、ユーザ認証で何らかのエラーが発生した場合にスローされます。
 *
 * @author Kenichi Masuda
 */
public class AuthenticationException extends Exception {

    /**
     * シリアライズバージョンID
     */
    private static final long serialVersionUID = -4260644045014200313L;

    /**
     * 指定された詳細メッセージを持つ {@code AuthenticationException} を構築します。
     *
     * @param message 詳細メッセージ
     */
    public AuthenticationException(String message) {
        super(message);
    }
}
