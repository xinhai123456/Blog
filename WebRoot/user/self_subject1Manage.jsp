<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>文章管理页面</title>
	<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
	}
	#manageSubject1 table  td{
		font-size:18px;
	}
	-->
	</style>
	<link href="images/skin.css" rel="stylesheet" type="text/css">
  </head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="middle"><span class="left_txt">
			<div id="manageSubject1" align="center"><!--管理试题-->
			<table width="95%" cellspacing="0" border="1">
				  <tr align="center"><h2>个人文章管理</h2></tr>
				  <tr align="center">
				  	<td>序号</td>
					<td>文章ID</td>
					<td>文章标题</td>
					<td>作者</td>
					<td>删除文章</td>
				  </tr>
				  <s:iterator value="#request.subject1s" var="subject1" status="sta">   
				  	   <tr align="center">
				  	   		<td>${sta.index+1}</td>
							<td>${subject1.subject1ID}</td>
							<td align="center"><a href="subject1Particular.action?subject1ID=${subject1.subject1ID}"><h2><font color=blue>${subject1.subject1Title}</font></h2></a></td>
							<td>${subject1.author}</td>
					 		<td><a href="subject1Delete?subject1ID=${subject1.subject1ID}"><h2><font color=red>删除</font><h2></a></td>
					    </tr> 
				  </s:iterator>	
				  <tr>
				  	<td colspan="6" align="center">
				  		共${page.totalCount}条纪录，当前第${page.currentPage}/${page.totalPage}页，每页${page.everyPage}条纪录
				  	<s:if test="#request.page.hasPrePage">
                		<a href="subject1Query.action?currentPage=1">首页</a> | 
                		<a href="subject1Query.action?currentPage=${page.currentPage - 1}">上一页</a> | 
               		</s:if>
               		<s:else>
               		首页 | 上一页 | 
               		</s:else>
               		<s:if test="#request.page.hasNextPage">
                		<a href="subject1Query.action?currentPage=${page.currentPage + 1}">下一页</a> | 
                		<a href="subject1Query.action?currentPage=${page.totalPage}">尾页</a>
               		</s:if>
               		<s:else>
               		下一页 | 尾页
               		</s:else>
				  	</td>
				  </tr>	  
			</table>	
			</div>
		</td>
        </tr>   
    </table>
</body>
</html>
