package jp.co.gfam.gits.business.core;

import jp.co.gfam.gits.common.dto.IssueSearchConditionDto;
import jp.co.gfam.gits.common.dto.UserListDto;

/**
 * このクラスはユーザ管理のサービスを提供します。
 *
 * @author Kenichi Masuda
 */
public interface UserManagementService {
    /**
     * 指定された検索条件に一致するユーザを検索します。
     *
     * @param condition 検索条件
     * @return ユーザ一覧
     */
    public UserListDto searchIssues(IssueSearchConditionDto condition);

}
