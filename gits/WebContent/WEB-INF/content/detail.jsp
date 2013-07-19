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
  <div><img src="images/spacer.gif" alt="" width="18" height="1"></div>
  <div class="bar">問題 #1234</div>
  <div><img src="images/spacer.gif" alt="" width="18" height="1"></div>

  <form method="post" action="search.html">
    <div class="table3">
    <table>
      <tr>
        <td align="left">課題種別</td>
        <td align="left">問題</td>
      </tr>
      <tr>
        <td align="left">タイトル</td>
        <td align="left">節子それドロップやない、チェンジアップや！</td>
      </tr>
      <tr>
        <td align="left">起票者</td>
        <td align="left">佐々木彩夏</td>
      </tr>
      <tr>
        <td align="left">内容</td>
        <td align="left">
        あいうえおかきくけこ<br/>
        さしすせそ<br/>
        うわぁあああああああああああああああああああああああああああああああ
        </td>
      </tr>
      <tr>
        <td align="left">担当者</td>
        <td align="left">壇蜜</td>
      </tr>
      <tr>
         <td align="left">ステータス</td>
         <td align="left">対応済</td>
      </tr>
    </table>
  </div>
  <div class="table1">
  <table>
    <tr>
      <td align="left" colspan="2"><img src="images/spacer.gif" alt="" width="0" height="1"></td>
    </tr>
    <tr>
      <td align="left" colspan="2"><input class="button2" type="submit" value="更新"></td>
    </tr>
  </table>
  </div>
  </form>
  <div><img src="images/spacer.gif" alt="" width="18" height="1"></div>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>
