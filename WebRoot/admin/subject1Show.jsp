<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>文章详情</title>
<!-- <link href="images/css3.css" rel="stylesheet" type="text/css" /> -->
<style type="text/css">
<!--
.STYLE3 {
	font-size: 18px;
}

.STYLE4 {
	font-size: 18px;
	font-weight: bold;
	text-align:center;
}

.STYLE5 {
	color: #FF0000
}

-->
.index {
	position: fixed;
	bottom: 0;
}
</style>
</head>

<body class="body">
		<table width="80%" border="0" align="center" cellpadding="0" cellspacing="10" >
			<!--文章开始-->
				<tr>
					<input type="hidden" name="subject1ID"
						value="${subject1.subject1ID}" />
						<td colspan="3" class="STYLE4"><h2><strong><font color=blue>${subject1.subject1Title}</font>
							</strong></h2></td>
				</tr>
				<tr>
					<td colspan="3"><h3>${subject1.subject1Parse}</h3><br></td>
				</tr>
		
				<tr>
					<td align="right"><h2><font color="#0000ff">作者：${subject1.author}</font></h2></td>
				</tr>	
				<tr>
					<td align="right"><h3><font color="#250cad">${subject1.subject1_time}</font><br></h3></td>
				</tr>	
				<!--文章结束-->			
		</table>
		<table width="80%" border="0" align="center" cellpadding="0" cellspacing="10" >
				<!-- 评论区 -->
					<tr><h2 class="STYLE4"><----------评论区----------></h2></tr>
					<s:iterator value="#request.comments" var="comment" status="com">
						<tr><h3 class="STYLE4">&nbsp;&nbsp;&nbsp;${comment_user}: ${comment}</h3></tr>
						<tr><h3 class="STYLE4">&nbsp;&nbsp;&nbsp;${comment_time}</h3></tr> 
						<tr><h2 class="STYLE4">------------------------</h2></tr>
					</s:iterator>
				<!-- 评论区结束 -->
		</table>
</body>
<script type="text/javascript">
</script>
</html>
