package jp.co.gfam.gits.business.authentication;

import java.sql.SQLException;
import java.util.List;

import jp.co.gfam.gits.business.SystemException;
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
     */
    @Override
    public void authenticate(String userName, String password)
            throws AuthenticationException {

        List<User> users = null;
        try {
            // 検索条件の生成
            UserCriteria criteria = new UserCriteria();
            criteria.setUserName(userName);

            // ユーザー情報の検索
            users = _userDao.select(criteria);

        } catch (SQLException sqle) {
            // SQL実行例外はシステム例外へ変換
            new SystemException(sqle.getMessage());
        }

        // ユーザが取得できない場合
        if (users.isEmpty()) {
            throw new UserNotFoundException("指定されたユーザは存在しません。");
        }

        // 一意キーで検索するため、1件のみ取得される前提
        User user = users.get(0);

        // TODO 取得したパスワードの復号化
        // 未実装　一旦パスワードは平文としている。

        // パスワードが一致しない場合
        if (!password.equals(user.getPassword())) {
            throw new BadPasswordException("パスワードが異なります。");
        }

        // TODO パスワード有効期限の確認
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
