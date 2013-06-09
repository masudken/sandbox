<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gits - GFAM Issue Tracking System</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body>

<header>
<div id="menu">
    <table>
        <tr>
            <td width="10%"><div id="menu_title">Gits</div></td>
            <td width="70%"><div id="menu_box">|　<a href="index.html">一覧</a>　|　<a href="input.html">起票</a>　|</div><td>
            <td width="20%"><div id="menu_logout"><a href="login.html">ログアウト</a></div><td>
        </tr>
    </table>
</div>
<header>

<div id="contents">
    <div><img src="image/spacer.gif" alt="" width="18" height="1"></div>
    <div class="bar">検索条件</div>
    <div><img src="image/spacer.gif" alt="" width="18" height="1"></div>

    <div class="table1">
        <form method="POST" action="/gits/issue-search">
        <table>
            <tr>
                <td align="left">課題番号</td>
                <td align="left"><input type="text" class="form2" name="issueId"></td>
            </tr>
            <tr>
                <td align="left">課題種別</td>
                <td align="left">
                    <select class="selectbox1" name="issueType" size="1">
                        <option value="不具合">不具合</option>
                        <option value="仕様変更">仕様変更</option>
                        <option value="障害">障害</option>
                        <option value="調査">調査</option>
                        <option value="問題">問題</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="left">タイトル</td>
                <td align="left"><input type="text" class="form2" name="title"></td>
            </tr>
            <tr>
                <td align="left">起票者</td>
                <td align="left">
                    <select class="selectbox1" name="registrant" size="1">
                        <option value="百田夏菜子">百田夏菜子</option>
                        <option value="玉井詩織">玉井詩織</option>
                        <option value="佐々木彩夏">佐々木彩夏</option>
                        <option value="有安杏果">有安杏果</option>
                        <option value="高城れに">高城れに</option>
                        <option value="早見あかり">早見あかり</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="left">担当者</td>
                <td align="left">
                    <select class="selectbox1" name="representative" size="1">
                        <option value="前田敦子">前田敦子</option>
                        <option value="大島優子">大島優子</option>
                        <option value="渡辺麻友">渡辺麻友</option>
                        <option value="柏木由紀">柏木由紀</option>
                        <option value="小嶋陽菜">小嶋陽菜</option>
                        <option value="高橋みなみ">高橋みなみ</option>
                        <option value="板野友美">板野友美</option>
                        <option value="指原莉乃">指原莉乃</option>
                        <option value="篠田麻里子">篠田麻里子</option>
                        <option value="島崎遥香">島崎遥香</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td align="left">ステータス</td>
                <td align="left">
                    <select class="selectbox1" name="status" size="1">
                        <option value="起票">起票</option>
                        <option value="対応中">対応中</option>
                        <option value="対応済">対応済</option>
                        <option value="ペンディング">ペンディング</option>
                    </select></td>
            </tr>
            <tr>
                <td align="left" colspan="2"><img src="image/spacer.gif" alt="" width="0" height="1"></td>
            </tr>
            <tr>
                <td align="left" colspan="2"><input class="button2" type="submit" value="検索"></td>
            </tr>
        </table>
        </form>
    </div>
    <div><img src="image/spacer.gif" alt="" width="18" height="1"></div>
    <div class="bar">課題一覧</div>
    <div><img src="image/spacer.gif" alt="" width="18" height="1"></div>
</div>

<footer>
<div id="footer">
    <div id="copyright">
    Copyright (C) GFAM Co.,Ltd. All rights reserved.
    </div>
</div>
<footer>

</body>
</html>
