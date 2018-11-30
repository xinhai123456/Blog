<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>文章发布</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script> 
	<script type="text/javascript" src="ckeditor/ckeditor.js"></script>  
    <script type="text/javascript" src="ckeditor/config.js"></script>  
    <script type="text/javascript">
	    $(document).ready(function(){  
	    	CKEDITOR.replace('subject1Parse'); 
	    });  
    </script>
    
    <script type="text/javascript"> 
		var msg="${requestScope.tipMessage}";
		if(msg!=""){
			alert(msg);
		}
	</script>
	
    <style type="text/css">
    .input {
		width: 500px;
		padding: 10px 15px;
		display: block;
		margin: 0 auto 10px auto;
		border-radius: 10px; /*文本框圆角*/
		font-size: 18px;
		font-weight: 300;
		text-align: center;
	}
    </style>
  </head>
  
  <body>
  	<form action="subject1Add.action" method="post">
  	     <span><h3><input type="text" name="subject1Title" class="input" placeholder="输入文章标题"></h3>
    	 <h3>内容：</h3>
    	  <FONT color="red"><s:actionmessage/></FONT>
  		  <FONT color="red"><s:actionerror/></FONT>
    	 <textarea name="subject1Parse"></textarea></span><br>
    	 <input type="hidden" name="author" size="20" value="${sessionScope.userInfo.userID}">
    	 <div colspan="2" align="center">
				<input type="submit" value="录入" > 
				<input type="reset" value="重置">
		</div>
    </form>
  </body>
</html>
