package jp.co.gfam.gits.business.service.impl;

import java.sql.SQLException;
import java.util.List;

import jp.co.gfam.gits.business.service.AuthenticationService;
import jp.co.gfam.gits.common.criteria.UserCriteria;
import jp.co.gfam.gits.common.entity.User;
import jp.co.gfam.gits.integration.dao.UserDao;

/**
 * @author Kenichi Masuda
 */
public class AuthenticationServiceImpl implements AuthenticationService {

    private UserDao userDao = null;

    /*
     * (非 Javadoc)
     *
     * @see
     * jp.co.gfam.gits.business.service.AuthenticationService#authenticate(java
     * .lang.String, java.lang.String)
     */
    @Override
    public boolean authenticate(String userName, String password) {

        // 検索条件の生成
        UserCriteria criteria = new UserCriteria();
        criteria.setUserName(userName);

        List<User> users = null;
        try {
            // ユーザー情報の取得
            users = userDao.search(criteria);
        } catch (SQLException se) {

        }

        // 1件のみ取得できるはず
        if (users.size() != 1) {

        }

        User user = users.get(0);

        // TODO 取得したパスワードの復号化
        // 未実装　一旦パスワードは平文としている。

        // パスワード有効期限の確認

        // TODO 自動生成されたメソッド・スタブ
        return false;
    }
}
