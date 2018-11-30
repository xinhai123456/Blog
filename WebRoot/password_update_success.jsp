<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'registerSuccess.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
* {
	font-family: 微软雅黑；
}

.clock {
	width: 100%;
	height: 50px;
	background: #000;
	color: #0f0;
	font-weight: bold;
	border-radius: 50px;
	text-align: center;
	line-height: 50px;
	font-size: 30px;
}
</style>

</head>

<body>
	<div class="clock">
	<span>密码修改成功，您需要重新登录系统，<span id="sid">3</span>秒后跳转到登录页面！</span>
	</div><br>
</body>

<script type="text/javascript">
	sidobj = document.getElementById('sid');
	s = 3;

	sobj = setInterval(function() {
		sidobj.innerHTML = --s;
		if (s == 0) {
			location = 'http://localhost:8080/Blog/login.jsp'; //浏览器地址栏改变
		}
	}, 1000);
</script>
</html>
