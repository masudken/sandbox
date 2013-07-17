package jp.co.gfam.gits.business.authentication;

/**
 * この例外は、指定されたユーザのパスワードが有効期限切れの場合にスローされます。
 *
 * @author Kenichi Masuda
 */
public class PasswordExpiredException extends AuthenticationException {

    /**
     * シリアライズバージョンID
     */
    private static final long serialVersionUID = 3280197829384681227L;

    /**
     * 指定された詳細メッセージを持つ {@code PasswordExpiredException} を構築します。
     *
     * @param message 詳細メッセージ
     */
    public PasswordExpiredException(String message) {
        super(message);
    }
}
