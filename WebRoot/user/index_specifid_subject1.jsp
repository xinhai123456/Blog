<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>文章详情</title>
<!-- <link href="images/css2.css" rel="stylesheet" type="text/css" /> -->
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
		<table width="80%" border="0" align="center" cellpadding="0" cellspacing="10">
			<!--文章开始-->
				<s:iterator value="#request.subject1s" var="subject1" status="sta">
				<tr>
					<input type="hidden" name="subject1ID"
						value="${subject1.subject1ID}" />
						<td colspan="3" class="STYLE4"><h2><strong><font color=blue>${subject1.subject1Title}</font>
							</strong></h2></td>
				</tr>
				<tr>
					<td colspan="3"><h3>${subject1.subject1Parse}</h3></td>
				</tr>
							
				<tr>
					<td align="right"><h2><font color="#0000ff">作者：${subject1.author}</font></h2></td>
				</tr>	
				<tr>
					<td align="right"><h3><font color="#250cad">${subject1.subject1_time}</font><br></h3></td>
				</tr>	
				</s:iterator>
				<!--文章结束-->			
		</table>
		<table width="80%" border="0" align="center" cellpadding="0" cellspacing="10">
				<!-- 评论区 -->
					<tr><h2 class="STYLE4"><----------评论区----------></h2></tr>
					<s:iterator value="#request.comments" var="comment" status="com">
						<tr><h3 class="STYLE4">&nbsp;&nbsp;&nbsp;${comment_user}: ${comment}</h3></tr>
						<tr><h3 class="STYLE4">&nbsp;&nbsp;&nbsp;${comment_time}</h3></tr> 
						<tr><h2 class="STYLE4">------------------------</h2></tr>
					</s:iterator>
					<form action="commentAdd.action" method="post">
						<tr >
							<input type="hidden" name="subject1ID" value="${subject1.subject1ID}" />
							<input type="hidden"  name="comment_user" value="${sessionScope.userInfo.userID}"/>
						</tr>
						<tr>
 							<td><h2>评论:</h2></td>
 							<td><textarea rows="4" cols="80" name="comment"></textarea></td>
 						</tr>
 						<tr>
							<td colspan="2"><div align="center">
								<input type="submit" value="录入" style="width:100px;height:30px;border-radius:9px;"> 
								<input type="reset" value="重置" style="width:100px;height:30px;border-radius:9px;">
							</div>
							</td>
					 	</tr>
					</form>
				<!-- 评论区结束 -->
		</table>
</body>
<script type="text/javascript">
</script>
</html>
