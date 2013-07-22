<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
<title>Gits - GFAM Issue Tracking System</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
<div id="login" align="center">
  <img src="image/spacer.gif" alt="" width="100%" height="50">
  <s:form accept-charset="UTF-8" action="auth" method="post" theme="simple">
    <table>
      <tr>
      <td align="left"><span class="logintitle">Gits</span></td>
      </tr>

      <s:if test="%{message != null && messageType == \"ERROR\"}">
      <tr>
      <td align="left"><span class="message1"><s:property value="message" /></span></td>
      </tr>
      </s:if>

      <tr>
      <td align="left">
      <s:textfield id="userName" cssClass="form1" name="userName" placeholder="ユーザ名" tabindex="1" />
      </td>
      </tr>
      <tr>
      <td align="left">
      <s:password id="password" cssClass="form1" name="password" placeholder="パスワード" tabindex="2" />
      </td>
      </tr>
      <tr>
      <td><img src="image/spacer.gif" alt="" height="5"></td>
      </tr>
      <tr>
      <td align="left">
      <s:submit id="loginButton" cssClass="button1" name="login" value="ログイン" type="button" tabindex="3" />
      </td>
      </tr>
    </table>
  </s:form>
</div>
</body>
</html>
