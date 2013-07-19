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
  <div class="bar">起票</div>
  <div><img src="images/spacer.gif" alt="" width="18" height="1"></div>

  <div class="table1">
    <s:form accept-charset="UTF-8" action="register" method="post" theme="simple">
    <table>
      <tr>
        <td align="left">課題種別</td>
        <td align="left">
        <select class="selectbox1" name="issueType" size="1">
          <option value=""></option>
          <option value="010">不具合</option>
          <option value="020">仕様変更</option>
          <option value="030">障害</option>
          <option value="040">調査</option>
          <option value="050">問題</option>
        </select>
        </td>
      </tr>
      <tr>
        <td align="left">タイトル</td>
        <td align="left"><input type="text" class="form3" name="title"></td>
      </tr>
      <tr>
        <td align="left">説明</td>
        <td align="left"><textarea class="textarea1" name="description" cols="100" rows="20"></textarea></td>
      </tr>
      <tr>
        <td align="left">ステータス</td>
        <td align="left">
        <select class="selectbox1" name="status" size="1">
          <option value=""></option>
          <option value="01">起票</option>
          <option value="02">対応中</option>
          <option value="03">対応済</option>
          <option value="09">ペンディング</option>
        </select>
        </td>
      </tr>
      <tr>
        <td align="left">優先度</td>
        <td align="left">
        <select class="selectbox1" name="priority" size="1">
          <option value=""></option>
          <option value="1">低め</option>
          <option value="2">通常</option>
          <option value="3">高め</option>
          <option value="4">緊急</option>
        </select>
        </td>
      </tr>
      <tr>
        <td align="left">起票者</td>
        <td align="left">
          <select class="selectbox1" name="registrant" size="1">
            <option value=""></option>
            <option value="百田 夏菜子">百田 夏菜子</option>
            <option value="玉井 詩織">玉井 詩織</option>
            <option value="佐々木 彩夏">佐々木 彩夏</option>
            <option value="有安 杏果">有安 杏果</option>
            <option value="高城 れに">高城 れに</option>
            <option value="早見 あかり">早見 あかり</option>
          </select>
        </td>
      </tr>
      <tr>
        <td align="left">担当者</td>
        <td align="left">
          <select class="selectbox1" name="representative" size="1">
            <option value=""></option>
            <option value="前田 敦子">前田 敦子</option>
            <option value="大島 優子">大島 優子</option>
            <option value="渡辺 麻友">渡辺 麻友</option>
            <option value="柏木 由紀">柏木 由紀</option>
            <option value="小嶋 陽菜">小嶋 陽菜</option>
            <option value="高橋 みなみ">高橋 みなみ</option>
            <option value="板野 友美">板野 友美</option>
            <option value="指原 莉乃">指原 莉乃</option>
            <option value="篠田 麻里子">篠田 麻里子</option>
            <option value="島崎 遥香">島崎 遥香</option>
          </select>
        </td>
      </tr>
      <tr>
        <td align="left">開始日</td>
        <td align="left">
        <s:textfield id="startDate" cssClass="form2" name="startDate" tabindex="1" />
        </td>
      </tr>
      <tr>
        <td align="left">終了日</td>
        <td align="left">
        <s:textfield id="endDate" cssClass="form2" name="endDate" tabindex="1" />
        </td>
      </tr>
      <tr>
        <td align="left">進捗</td>
        <td align="left">
        <s:textfield id="progress" cssClass="form2" name="progress" tabindex="1" />
        </td>
      </tr>
      <tr>
        <td align="left">工数</td>
        <td align="left">
        <s:textfield id="cost" cssClass="form2" name="cost" tabindex="1" />
        </td>
      </tr>
      <tr>
        <td align="left" colspan="2"><img src="images/spacer.gif" alt="" width="0" height="1"></td>
      </tr>
      <tr>
        <td align="left" colspan="2"><input class="button2" type="submit" value="登録"></td>
      </tr>
      </table>
    </s:form>
    </div>
  <div><img src="images/spacer.gif" alt="" width="18" height="1"></div>
</div>

<jsp:include page="footer.jsp" />
</body>
</html>
