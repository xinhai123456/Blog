<%@ page language="java" import="java.util.*" pageEncoding="gbk"%> <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>在线博客系统-管理员后台管理</title>
<link href="<%=basePath %>user/images/index.css" rel="stylesheet" type="text/css" />
 </head>
<body>
<div id="container">
	<div id="banner"><img src="<%=basePath %>user/images/logo.png" /></div>
	<div id="globallink">
		<ul>
			<li><a href="<%=basePath %>index.jsp">首页</a></li>
			<li><a href="<%=basePath %>subject1Query.action" target="OfficeMain">所有文章</a></li> 
			<li><a href="<%=basePath %>getRandomSubject1.action" target="OfficeMain">随机文章</a></li>
			<li><a href="subject1Query.jsp" target="OfficeMain">查询文章</a></li>
		</ul>
		<ul>
			<li><a href="userQuery.action" target="OfficeMain">所有用户</a></li>
            <li><a href="userQueryByID.jsp" target="OfficeMain">查找用户</a></li>
		</ul>
		<ul>
			<li><a href="adminCountManagement.jsp" target="_top">密码修改</a></li>
			<li><a href="<%=basePath%>login.jsp"><font color=red>退出登录</font></a></li>
		</ul>
		<br />
	</div> 
	<div id="main">
	 <iframe id="frame1" src="<%=basePath %>desk.jsp" name="OfficeMain" width="100%" height="100%" scrolling="yes" marginwidth=0 marginheight=0 frameborder=0 vspace=0 hspace=0 >
	 </iframe>
	</div>
	<div id="footer">
		<p>&copy;copyright 心海&nbsp;&nbsp;QQ:286346018</p>
	</div>
</div>
</body>
</html>
