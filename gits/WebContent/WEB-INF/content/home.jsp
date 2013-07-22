<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gits - GFAM Issue Tracking System</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
<jsp:include page="header.jsp" />

<div id="contents">
  <div><img src="image/spacer.gif" alt="" width="18" height="1"></div>
  <div class="bar">検索条件</div>
  <div><img src="image/spacer.gif" alt="" width="18" height="1"></div>

  <div class="table1">
    <s:form accept-charset="UTF-8" action="search" method="post" theme="simple">
      <table>
        <tr>
          <td align="left">課題番号</td>
          <td align="left">
          <s:textfield id="issueId" cssClass="form2" name="issueId" tabindex="1" />
          </td>
        </tr>
        <tr>
          <td align="left">課題種別</td>
          <td align="left">
          <s:select name="issueType" cssClass= "selectbox1" list="issueTypeMap" size="1" emptyOption="true" />
          </td>
        </tr>
        <tr>
          <td align="left">タイトル</td>
          <td align="left">
          <s:textfield id="title" cssClass="form2" name="title" tabindex="3" />
          </td>
        </tr>
        <tr>
          <td align="left">ステータス</td>
          <td align="left">
          <s:select name="status" cssClass= "selectbox1" list="statusMap" size="1" emptyOption="true" />
          </td>
        </tr>
        <tr>
          <td align="left">起票者</td>
          <td align="left">
          <s:select name="registrant" cssClass= "selectbox1" list="registrantMap" size="1" emptyOption="true" />
          </td>
        </tr>
        <tr>
          <td align="left">担当者</td>
          <td align="left">
          <s:select name="representative" cssClass= "selectbox1" list="representativeMap" size="1" emptyOption="true" />
          </td>
        </tr>
        <tr>
          <td align="left" colspan="2"><img src="image/spacer.gif" alt="" width="0" height="1"></td>
        </tr>
        <tr>
          <td align="left" colspan="2">
          <s:submit id="searchButton" cssClass="button2" name="search" value="検索" type="button" tabindex="6" />
          </td>
        </tr>
      </table>
    </s:form>
  </div>

  <div><img src="image/spacer.gif" alt="" width="18" height="1"></div>
  <div class="bar">課題一覧</div>
  <div><img src="image/spacer.gif" alt="" width="18" height="1"></div>

  <s:if test="%{issueList != null && !issueList.getIssueList().isEmpty()}">
  <div class="table2">
  <table>
    <tr>
      <th width="2%">#</th>
      <th width="8%">課題番号</th>
      <th width="8%">課題種別</th>
      <th width="8%">ステータス</th>
      <th width="8%">優先度</th>
      <th width="34%">タイトル</th>
      <th width="8%">起票者</th>
      <th width="8%">担当者</th>
      <th width="16%">更新日時</th>
    </tr>
    <s:iterator value="issueList.getIssueList()">
    <tr>
      <td width="2%"><input type="checkbox" name="check" value="true"></td>
      <td width="8%"><s:property value="issueId" /></td>
      <td width="8%"><s:property value="issueType.issueTypeName" /></td>
      <td width="8%"><s:property value="%{getHelper().convertStatus(status)}" /></td>
      <td width="8%"><s:property value="%{getHelper().convertPriority(priority)}" /></td>
      <td width="34" class="left">
      <a href="/gits/detail?issueId=<s:property value="issueId" />"><s:property value="title" /></a>
      </td>
      <td width="8%"><s:property value="registrant.fullName" /></td>
      <td width="8%"><s:property value="representative.fullName" /></td>
      <td width="16%"><s:date name="updateDateTime" format="yyyy/MM/dd HH:mm"/></td>
    </tr>
    </s:iterator>
  </table>
  </div>
  </s:if>

</div>

<!-- <jsp:include page="footer.jsp" /> -->
</body>
</html>
