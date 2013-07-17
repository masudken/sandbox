package jp.co.gfam.gits.business.core;

import java.sql.SQLException;
import java.util.List;

import jp.co.gfam.gits.business.SystemException;
import jp.co.gfam.gits.business.dto.UserDto;
import jp.co.gfam.gits.business.dto.UserListDto;
import jp.co.gfam.gits.business.dto.UserSearchConditionDto;
import jp.co.gfam.gits.integration.dao.UserCriteria;
import jp.co.gfam.gits.integration.dao.UserDao;
import jp.co.gfam.gits.integration.dao.UserDaoImpl;
import jp.co.gfam.gits.integration.entity.User;

/**
 * このクラスはユーザ管理のサービスを提供します。
 *
 * @author Kenichi Masuda
 */
public class UserManagementServiceImpl implements UserManagementService {

    /**
     * ユーザDAO
     */
    private UserDao _userDao = new UserDaoImpl();

    /**
     * 指定された検索条件に一致するユーザを検索します。
     *
     * @param condition 検索条件
     * @return ユーザ一覧
     */
    @Override
    public UserListDto searchUsers(UserSearchConditionDto condition) {

        List<User> users = null;

        try {
            // 検索条件の生成
            UserCriteria criteria = new UserCriteria();
            criteria.setUserId(condition.getUserId());
            criteria.setUserName(condition.getUserName());
            String fullName = condition.getFulltName();
            if (fullName != null) {
                String[] names = fullName.split(" ");
                criteria.setFirstName(names[1]);
                criteria.setFirstName(names[0]);
            }
            criteria.setMailAddress(condition.getMailAddress());

            // ユーザ情報の取得
            users = _userDao.select(criteria);

        } catch (SQLException sqle) {
            // SQL実行例外はシステム例外へ変換
            new SystemException(sqle.getMessage());
        }

        // DTO変換
        UserListDto listDto = new UserListDto();
        for (User user : users) {
            UserDto userDto = new UserDto();
            userDto.setUserId(user.getUserId());
            userDto.setUserName(user.getUserName());
            userDto.setPassword(user.getPassword());
            userDto.setExpirationDate(user.getExpirationDate());
            userDto.setFullName(user.getLastName() + " " + user.getFirstName());
            userDto.setMailAddress(user.getMailAddress());
            listDto.addUser(userDto);
        }

        return listDto;
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
