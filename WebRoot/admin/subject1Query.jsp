<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>����ģ����ѯҳ��</title>
	<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
	}
	#showSubject1 table  td{
		font-size:12px;
	}
	-->
	</style>
	<link href="images/skin.css" rel="stylesheet" type="text/css">
  </head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td valign="middle"><span class="left_txt">
			<div id="showSubject1" align="center"><!--ģ����ѯ����-->
			<form action="subject1LikeQuery.action" method="post">
			<table border="0" cellspacing="10" cellpadding="0">
				  <tr>
					<td><h2>���±���:</h2></td>
					<td><h2><input name="subject1Title" size="50" style="border-radius:10px;"></h2></td>
				  </tr>
				  <tr>
				    <td colspan="2"><div align="center">
				      <input type="submit" name="Submit" value="��ѯ" style="width:100px;height:30px;border-radius:9px;">
				      <input type="reset" name="Submit2" value="����" style="width:100px;height:30px;border-radius:9px;">
			        </div></td>
			    </tr>
			</table>
			</form>
			</div>
		</span>
		</td>
        </tr>
      
    </table>
</body>
</html>
