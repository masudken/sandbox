package jp.co.gfam.gits.business.authentication;

import java.sql.SQLException;
import java.util.List;

import jp.co.gfam.gits.integration.dao.UserCriteria;
import jp.co.gfam.gits.integration.dao.UserDao;
import jp.co.gfam.gits.integration.dao.UserDaoImpl;
import jp.co.gfam.gits.integration.entity.User;

/**
 * このクラスは認証サービスを提供します。
 *
 * @author Kenichi Masuda
 */
public class AuthenticationServiceImpl implements AuthenticationService {

    /**
     * ユーザDAO
     */
    private UserDao _userDao = new UserDaoImpl();

    /**
     * 指定されたユーザ名、パスワードで認証を実施します。
     *
     * @param userName ユーザ名
     * @param password パスワード
     * @throws AuthenticationException 認証に失敗した場合
     * @see AuthenticationService#authenticate(String, String)
     */
    @SuppressWarnings("unused")
    @Override
    public void authenticate(String userName, String password)
            throws AuthenticationException {

        // 検索条件の生成
        UserCriteria criteria = new UserCriteria();
        criteria.setUserName(userName);

        List<User> users = null;
        try {
            // ユーザー情報の取得
            users = _userDao.select(criteria);
        } catch (SQLException se) {

        }

        // 1件のみ取得できるはず
        if (users.size() != 1) {
            throw new UserNotFoundException("指定されたユーザは存在しません。");
        }

        User user = users.get(0);

        // TODO 取得したパスワードの復号化
        // 未実装　一旦パスワードは平文としている。
        if (!password.equals(user.getPassword())) {
            throw new BadPasswordException("パスワードが異なります。");
        }

        // パスワード有効期限の確認
        if (false) {
            throw new PasswordExpiredException("パスワードが異なります。");
        }
    }

    /**
     * ユーザDAOを設定します。
     *
     * @param userDao ユーザDAO
     */
    public void setUserDao(UserDao userDao) {
        _userDao = userDao;
    }
}
