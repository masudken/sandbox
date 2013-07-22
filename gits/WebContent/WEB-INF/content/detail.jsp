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

  <s:if test="%{message != null && messageType == \"INFO\"}">
  <div><img src="images/spacer.gif" alt="" width="18" height="1"></div>
  <div class="message2"><s:property value="message" /></div>
  </s:if>

  <div><img src="images/spacer.gif" alt="" width="18" height="1"></div>
  <div class="bar">
  <s:property value="issue.issueType.issueTypeName" /> #<s:property value="issue.issueId" />
  </div>
  <div><img src="images/spacer.gif" alt="" width="18" height="1"></div>

  <div class="table3">
    <table>
      <tr>
        <td align="left">タイトル：</td>
        <td align="left"><s:property value="issue.title" /></td>
      </tr>
      <tr>
         <td align="left">ステータス：</td>
         <td align="left"><s:property value="%{getHelper().convertStatus(issue.status)}" /></td>
      </tr>
      <tr>
         <td align="left">優先度：</td>
         <td align="left"><s:property value="%{getHelper().convertPriority(issue.priority)}" /></td>
      </tr>
      <tr>
        <td align="left">起票者：</td>
        <td align="left"><s:property value="issue.registrant.fullName" /></td>
      </tr>
      <tr>
        <td align="left">起票日：</td>
        <td align="left"><s:date name="issue.registerDate" format="yyyy/MM/dd" /></td>
      </tr>
      <tr>
        <td align="left">担当者：</td>
        <td align="left"><s:property value="issue.representative.fullName" /></td>
      </tr>
      <tr>
        <td align="left">開始日：</td>
        <td align="left"><s:date name="issue.startDate" format="yyyy/MM/dd" /></td>
      </tr>
      <tr>
        <td align="left">終了日：</td>
        <td align="left"><s:date name="issue.endDate" format="yyyy/MM/dd"/></td>
      </tr>
      <tr>
        <td align="left">工数：</td>
        <td align="left"><s:property value="issue.cost" />(人日)</td>
      </tr>
      <tr>
        <td align="left">進捗：</td>
        <td align="left"><s:property value="issue.progress" />%</td>
      </tr>
      <tr>
        <td align="left">説明：</td>
        <td align="left"><s:property value="%{issue.description.replaceAll('\\n', '<br />')}" escape="false" /></td>
      </tr>
    </table>
  </div>

  <s:if test="%{dispMode == null}">
  <div class="table1">
    <s:form accept-charset="UTF-8" action="update" method="post" theme="simple">
    <s:hidden name="issueId" value="%{issue.issueId}" />
    <s:hidden name="dispMode" value="UPDATE" />
    <table>
      <tr>
      <td align="left" colspan="2"><img src="images/spacer.gif" alt="" width="0" height="1"></td>
      </tr>
      <tr>
      <td align="left" colspan="2"><input class="button2" type="submit" value="更新"></td>
      </tr>
    </table>
    </s:form>
  </div>
  </s:if>

  <s:if test="%{dispMode == \"UPDATE\"}">
  <div><img src="image/spacer.gif" alt="" width="18" height="1"></div>
  <div class="bar">更新</div>
  <div><img src="image/spacer.gif" alt="" width="18" height="1"></div>

  <div class="table1">
    <s:form accept-charset="UTF-8" action="do-update" method="post" theme="simple">
    <s:hidden name="issueId" value="%{issue.issueId}" />
    <table>
      <tr>
        <td align="left">課題種別</td>
        <td align="left">
        <s:select name="issueType" cssClass= "selectbox1" list="issueTypeMap" size="1" emptyOption="true" value="%{issue.issueType.issueTypeCode}" />
        </td>
      </tr>
      <tr>
        <td align="left">タイトル</td>
        <td align="left">
        <s:textfield id="progress" cssClass="form3" name="title" tabindex="1" value="%{issue.title}" />
        </td>
      </tr>
      <tr>
        <td align="left">説明</td>
        <td align="left">
        <textarea class="textarea1" name="description" cols="100" rows="20"><s:property value="issue.description" /></textarea>
        </td>
      </tr>
      <tr>
        <td align="left">ステータス</td>
        <td align="left">
        <s:select name="status" cssClass= "selectbox1" list="statusMap" size="1" emptyOption="true" value="%{issue.status}" />
        </td>
      </tr>
      <tr>
        <td align="left">優先度</td>
        <td align="left">
        <s:select name="priority" cssClass= "selectbox1" list="priorityMap" size="1" emptyOption="true" value="%{issue.priority}" />
        </td>
      </tr>
      <tr>
        <td align="left">起票者</td>
        <td align="left">
        <s:select name="registrant" cssClass= "selectbox1" list="registrantMap" size="1" emptyOption="true" value="%{issue.registrant.fullName}" />
        </td>
      </tr>
      <tr>
        <td align="left">担当者</td>
        <td align="left">
        <s:select name="representative" cssClass= "selectbox1" list="representativeMap" size="1" emptyOption="true" value="%{issue.representative.fullName}" />
        </td>
      </tr>
      <tr>
        <td align="left">開始日</td>
        <td align="left">
        <s:textfield id="startDate" cssClass="form2" name="startDate" tabindex="1" value="%{getHelper().formatDate(issue.startDate)}" />
        </td>
      </tr>
      <tr>
        <td align="left">終了日</td>
        <td align="left">
        <s:textfield id="endDate" cssClass="form2" name="endDate" tabindex="1" value="%{getHelper().formatDate(issue.endDate)}" />
        </td>
      </tr>
      <tr>
        <td align="left">進捗</td>
        <td align="left">
        <s:textfield id="progress" cssClass="form2" name="progress" tabindex="1" value="%{issue.progress}" />
        </td>
      </tr>
      <tr>
        <td align="left">工数</td>
        <td align="left">
        <s:textfield id="cost" cssClass="form2" name="cost" tabindex="1" value="%{issue.cost}" />
        </td>
      </tr>
      <tr>
        <td align="left" colspan="2"><img src="images/spacer.gif" alt="" width="0" height="1"></td>
      </tr>
      <tr>
        <td align="left" colspan="2"><input class="button2" type="submit" value="更新"></td>
      </tr>
      </table>
    </s:form>
  </div>
  </s:if>
</div>

<!-- <jsp:include page="footer.jsp" /> -->
</body>
</html>
