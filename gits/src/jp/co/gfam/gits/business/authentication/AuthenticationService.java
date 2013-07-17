package jp.co.gfam.gits.business.authentication;

/**
 * このクラスは認証サービスを提供します。
 *
 * @author Kenichi Masuda
 */
public interface AuthenticationService {

    /**
     * 指定されたユーザ名、パスワードで認証を実施します。
     *
     * @param userName ユーザ名
     * @param password パスワード
     * @throws AuthenticationException 認証に失敗した場合
     */
    public void authenticate(String userName, String password)
            throws AuthenticationException;
}
