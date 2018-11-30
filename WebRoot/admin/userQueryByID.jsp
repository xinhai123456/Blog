<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="images/skin.css" rel="stylesheet" type="text/css" />
<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
	}
	#queryForm table  td{
		font-size:12px;
	}
	-->
</style>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="middle"><span class="left_txt">
			<div id="queryForm" align="center"><!--查询表单-->
				<form action="queryUserByID.action" method="post">
				<table border="0" cellspacing="10" cellpadding="0">
				  <tr>
					<td><h2>用户名:</h2></td>
					<td><h2><input type="text" name="userID" size="20" style="border-radius:10px;"></h2></td>
				  </tr>
				  <tr>
				  	<td colspan="2"><div align="center">
				  	  <input type="submit" value="查询" style="width:100px;height:30px;border-radius:9px;">				  	  
				  	  <input type="reset" value="重置" style="width:100px;height:30px;border-radius:9px;">
			  	  </div>				</td>
				  </tr>
			</table>
			</form>	
			</div>
		</td>
        </tr>
      
    </table>
</body>
