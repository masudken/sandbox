package jp.co.gfam.gits.business.dto;

import java.util.ArrayList;
import java.util.List;


/**
 * ユーザ一覧DTO
 *
 * @author Kenichi Masuda
 */
public class UserListDto {

    /**
     * ユーザのリスト
     */
    private List<UserDto> _userList;

    /**
     * 空の {@code UserListDto} を構築します。
     */
    public UserListDto() {
        _userList = new ArrayList<UserDto>();
    }

    /**
     * 指定されたユーザDTOのリストを元に、 {@code UserListDto} を構築します。
     *
     * @param ユーザDTOのリスト
     */
    public UserListDto(List<UserDto> userList) {
        _userList = new ArrayList<UserDto>(userList);
    }

    /**
     * 指定したユーザIDのユーザを取得します。
     *
     * @param userId ユーザID
     * @return ユーザDTO
     */
    public UserDto getUser(int userId) {
        for (UserDto user : _userList) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    /**
     * ユーザDTOのリストを取得します。
     *
     * @return ユーザDTOのリスト
     */
    public List<UserDto> getUserList() {
        return new ArrayList<UserDto>(_userList);
    }

    /**
     * 指定したユーザDTOをユーザ一覧に追加します。
     *
     * @param issue ユーザDTO
     */
    public void addUser(UserDto user) {
        _userList.add(user);
    }
}
