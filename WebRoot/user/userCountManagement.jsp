<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>�����޸�</title>

<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=UTF-8">

<!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
<style type="text/css">
* {
	magin: 0;
	padding: 0;
} /*ȥ��ҳ����ʽ*/
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
	overflow: hidden; /*���ع�����*/
}

.container {
	max-width: 600px;
	height: 400px;
	padding: 80px;
	text-align: center;
	margin: 0 auto; /*������ʾ*/
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
	border-radius: 10px; /*�ı���Բ��*/
	font-size: 18px;
	font-weight: 300;
	text-align: center;
}

form button {
	background-color: #FFF;
	border: 0;
	padding: 10px 15px;
	color: #0C3;
	border-radius: 8px; /*�ı���Բ��*/
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
		<h1>�����޸�</h1>
	</div>
	<div class="context" style="width: 50%;border-radius: 10px;">
		<div class="container" style="width: 50%; left:25%">
			<form name="userCountManagement_form"
				action="userCountManagement.action" method="post">
				<table>
					<tr>
						<td style="width: 80px; "><h3>��¼�˺ţ�</h3></td>
						<td><input type="text" name="userID" style="width: 180px;"
							readonly="readonly" value="${sessionScope.userInfo.userID}"></td>
					</tr>

					<tr>
						<td style="width: 80px; "><h3>���룺</h3></td>
						<td><input type="password" name="password"
							style="width: 180px; "
							value="${sessionScope.userInfo.password}"></td>
					</tr>
					<tr>
						<td><button type="submit" id="Submit" value="ȷ��"
								style="width: 140px; ">ȷ&nbsp;��</button></td>
						<td>&nbsp;&nbsp;
							<button type="reset" id="Reset" value="����" style="width: 151px; ">��&nbsp;��</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>
