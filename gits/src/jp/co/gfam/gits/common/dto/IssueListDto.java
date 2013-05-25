package jp.co.gfam.gits.common.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 課題一覧DTO
 *
 * @author kenichi
 */
public class IssueListDto {

    /**
     * 課題一覧のリスト
     */
    private List<IssueDto> issueList = new ArrayList<IssueDto>();

    /**
     * 指定した課題番号の課題を取得します。
     *
     * @param issueCode 課題番号
     * @return 課題DTO
     */
    public IssueDto getIssue(Long issueCode) {

        // this.issueList.get(index);
        return null;
    }

    /**
     * 指定した課題を課題一覧に追加します。
     *
     * @param issue 課題DTO
     */
    public void addIssue(IssueDto issue) {
        this.issueList.add(issue);
    }
}
