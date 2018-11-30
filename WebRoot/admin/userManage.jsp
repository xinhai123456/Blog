<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
#manageSubject table  td{
	font-size:18px;
}
-->
</style>


<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
        <td valign="middle"><span class="left_txt">
			<div id="manageSubject" align="center"><!--管理用户-->
			<table width="80%" cellspacing="0" border="1">
			<tr align="center"><h2>用戶管理</h2></tr>
			  <tr align="center">
			  	<td>序号</td>
				<td>用户账号</td>		
					<td>删除用戶</td>
			  </tr>
			  <s:iterator value="#request.users" var="user" status="sta">
			  <tr align="center">
			  	<td>${sta.index+1}</td>
				<td>${user.userID}</td>
				<td><a href="userDelete?userID=${user.userID}">删除</a></td>
			  </tr>
			  </s:iterator>
			</table>
			</div>
		</span>
</table>
</body>
