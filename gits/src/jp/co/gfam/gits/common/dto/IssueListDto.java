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
    private List<IssueDto> _issueList;

    /**
     * 空の <code>IssueListDto</code> を構築します。
     */
    public IssueListDto() {
        _issueList = new ArrayList<IssueDto>();
    }

    /**
     * 指定された課題DTOのリストを元に、 <code>IssueListDto</code> を構築します。
     *
     * @param 課題DTOのリスト
     */
    public IssueListDto(List<IssueDto> issueList) {
        _issueList = new ArrayList<IssueDto>(issueList);
    }

    /**
     * 指定した課題番号の課題を取得します。
     *
     * @param issueId 課題番号
     * @return 課題DTO
     */
    public IssueDto getIssue(int issueId) {
        for (IssueDto issue : _issueList) {
            if (issue.getIssueId() == issueId) {
                return issue;
            }
        }
        return null;
    }

    /**
     * 課題DTOのリストを取得します。
     *
     * @return 課題DTOのリスト
     */
    public List<IssueDto> getIssueList() {
        return new ArrayList<IssueDto>(_issueList);
    }

    /**
     * 指定した課題DTOを課題一覧に追加します。
     *
     * @param issue 課題DTO
     */
    public void addIssue(IssueDto issue) {
        _issueList.add(issue);
    }
}
