package jp.co.gfam.gits.common.dto;

import static org.junit.Assert.*;
import jp.co.gfam.gits.business.dto.IssueDto;

import org.junit.Test;

/**
 * @author Kenichi Masuda
 */
public class IssueDtoTest {

    /**
     * {@link IssueDto} のsetter/getterのテスト
     */
    @Test
    public void testAccessor001() {

        IssueDto issue = new IssueDto();
        issue.setIssueId(101);
        issue.setIssueTypeCode("003");
        issue.setTitle("単体テスト実装");
        issue.setDescription("このテストメソッドはアクセサメソッドのテストです。");
        issue.setRegistrantId(201);
//        issue.setRegisterDate(registerDate);
        issue.setRepresentativeId(301);
        issue.setPriority("1");
//       issue.setStartDate(startDate);
//        issue.setEndDate(endDate);
//        issue.setProgress(94);
//        issue.setCost(cost);
        issue.setStatus("01");
//        issue.setUpdateDateTime(updateDateTime);

        fail("まだ実装されていません");
    }
}
