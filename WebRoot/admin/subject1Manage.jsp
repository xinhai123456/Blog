<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>���¹���ҳ��</title>
	<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		font-size : 3em;
	}
	#manageSubject1 table  td{
		font-size:18px;
	}
	</style>
  </head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
        <td valign="middle"><span class="left_txt">
			<div id="manageSubject1" align="center"><!--��������-->
			<table width="80%" cellspacing="0" border="1">
				<tr align="center"><h2>���¹���</h2></tr>
				  <tr align="center">
				  	<td>���</td>
					<td>����ID</td>
					<td>���±���</td>
					<td>����</td>
					<td>ɾ������</td>		
				  </tr>
				  <s:iterator value="#request.subject1s" var="subject1" status="sta">
				  	 <tr align="center">
				  	 		<td>${sta.index+1}</td>
							<td>${subject1.subject1ID}</td>
							<td align="center"><a href="subject1Particular.action?subject1ID=${subject1.subject1ID}">${subject1.subject1Title}</a></td>
							<td>${subject1.author}</td>
					 	    <td><a href="subject1Delete?subject1ID=${subject1.subject1ID}">ɾ��</a></td>
					  </tr>
				  </s:iterator>	
				  <tr>
				  	<td colspan="6" align="center">
				  		��${page.totalCount}����¼����ǰ��${page.currentPage}/${page.totalPage}ҳ��ÿҳ${page.everyPage}����¼
				  	<s:if test="#request.page.hasPrePage">
                		<a href="subject1Query.action?currentPage=1">��ҳ</a> | 
                		<a href="subject1Query.action?currentPage=${page.currentPage - 1}">��һҳ</a> | 
               		</s:if>
               		<s:else>
               		��ҳ | ��һҳ | 
               		</s:else>
               		<s:if test="#request.page.hasNextPage">
                		<a href="subject1Query.action?currentPage=${page.currentPage + 1}">��һҳ</a> | 
                		<a href="subject1Query.action?currentPage=${page.totalPage}">βҳ</a>
               		</s:if>
               		<s:else>
               		��һҳ | βҳ
               		</s:else>
				  	</td>
				  </tr>	  
			</table>
			</div>
		</span>
</table>
</body>
</html>
