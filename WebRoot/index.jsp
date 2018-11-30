<%@ page language="java" import="java.util.*" pageEncoding="gbk"%> <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>在线博客系统-首页</title>
<link href="<%=basePath %>user/images/index.css" rel="stylesheet" type="text/css" />
 </head>
<body>
<div id="container">
	<div id="banner"><img src="<%=basePath %>user/images/logo.png" /></div>
	<div id="globallink">
		<ul>
			<li><a href="<%=basePath %>index.jsp">首页</a></li>
			<li><a href="<%=basePath %>subjectQuery.action" target="OfficeMain">文章</a></li> 
			<li><a href="<%=basePath %>userQueryFront.action" target="OfficeMain">用户</a></li>
		</ul>
		<ul>
			<li><a href="<%=basePath%>login.jsp"><font color=red>后台登陆</font></a></li>
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
