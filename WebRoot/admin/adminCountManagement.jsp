<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>密码修改</title>

<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=UTF-8">

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<style type="text/css">
* {
	magin: 0;
	padding: 0;
} /*去掉页面样式*/
body {
	color: #FFF;
}

.head {
	background: #808080;
	position: absolute;
	left: 0;
	top: 0;
	width: 100%;
	height: 85px;
	margin-top: 10px;
	text-align: center;
}

.context {
	background: #808080;
	position: absolute;
	left: 25%;
	top: 50%;
	width: 40%;
	height: 400px;
	margin-top: -200px;
	overflow: hidden; /*隐藏滚动条*/
}

.container {
	max-width: 600px;
	height: 400px;
	padding: 80px;
	text-align: center;
	margin: 0 auto; /*居中显示*/
	font-size: 18px;
	font-weight: bold;
}

.container h1 {
	font-size: 40px;
	font-weight: 300;
}

form {
	padding: 20px 0;
}

form input {
	border: 1px solid #FFF;
	width: 220px;
	padding: 10px 15px;
	display: block;
	margin: 0 auto 10px auto;
	border-radius: 10px; /*文本框圆角*/
	font-size: 18px;
	font-weight: 300;
	text-align: center;
}

form button {
	background-color: #FFF;
	border: 0;
	padding: 10px 15px;
	color: #0C3;
	border-radius: 8px; /*文本框圆角*/
	width: 120px;
	font-size: 20px;
	font-weight: bold;
}

form button:hover {
	background-color: #CCC;
}
</style>
</head>

<body>
	<div class="head" style="width: 50%;left:25%;border-radius: 10px;">
		<h1>密码修改</h1>
	</div>
	<div class="context" style="width: 50%;border-radius: 10px;">
		<div class="container" style="width: 50%; left:25%">
			<form name="CountManagement_form"
				action="adminCountManagement.action" method="post">
				<table>
					<tr>
						<h3><FONT color="red"><s:actionerror/></FONT></h3><!--显示错误信息 -->
					</tr>
					<tr>
						<td style="width: 80px; "><h3>登录名：</h3></td>
						<td><input type="text" name="adminID"
							style="width: 180px;" readonly="readonly"
							value="${sessionScope.adminInfo.adminID}"></td>
					</tr>
					<tr>
						<td style="width: 80px; "><h3>密码：</h3></td>
						<td><input type="password" name="password" style="width: 180px;"
							value="${sessionScope.adminInfo.password}"></td>
					</tr>
					<tr>
						<td><button type="submit" id="Submit" value="确认"
								style="width: 140px; ">确&nbsp;认</button></td>
						<td>&nbsp;&nbsp;
							<button type="reset" id="Reset" value="重置" style="width: 151px; ">重&nbsp;置</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
