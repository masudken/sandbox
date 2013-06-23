<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>Gits - GFAM Issue Tracking System</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>
<div id="login" align="center">
<img src="image/spacer.gif" alt="" width="100%" height="50">
  <form accept-charset="UTF-8" action="/gits/login" method="post">
    <table>
      <tr>
        <td align="left"><span class="logintitle">Gits</span></td>
      </tr>
      <tr>
        <td align="left">
        <input id="userName" class="form1" name="userName" type="text" placeholder="ユーザ名" tabindex="1" />
      </td>
      </tr>
      <tr>
        <td align="left">
        <input id="password" class="form1" name="password" type="password" placeholder="パスワード" tabindex="2" />
        </td>
      </tr>
      <tr>
        <td><img src="image/spacer.gif" alt="" height="5"></td>
      </tr>
      <tr>
        <td align="left">
        <input class="button1" type="submit" name="login" value="ログイン" tabindex="3" />
        </td>
      </tr>
    </table>
  </form>
</div>
</body>
</html>