<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>

<head>
<title>�û���¼</title>

<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=UTF-8">

<link href="user/images/css4.css" rel="stylesheet" type="text/css" />
<style type="text/css">
* {
	magin: 0;
	padding: 0;
} /*ȥ��ҳ����ʽ*/
body {
	color: #FFF;
}

.head {
	/* background: #50A3A2; */
	position: absolute;
	left: 0;
	top: 0;
	width: 100%;
	height: 85px;
	margin-top: 10px;
	text-align: center;
}

.context {
	/* background: #50A3A2; */
	position: absolute;
	left: 0;
	top: 50%;
	width: 100%;
	height: 500px;
	margin-top: -200px;
	overflow: hidden; /*���ع�����*/
}

.container {
	max-width: 600px;
	height: 400px;
	padding: 40px;
	text-align: center;
	margin: 0 auto; /*������ʾ*/
}

.container h1 {
	font-size: 40px;
	font-weight: 300;
}

form {
	padding: 20px 0;
}

.input {
	border: 1px solid #FFF;
	width: 220px;
	padding: 10px 15px;
	display: block;
	margin: 0 auto 10px auto;
	border-radius: 10px; /*�ı���Բ��*/
	font-size: 18px;
	font-weight: 300;
	text-align: center;
}

form button {
	background-color: #FFF;
	border: 0;
	padding: 10px 15px;
	color: #0C3;
	border-radius: 8px; /*�ı���Բ��*/
	width: 120px;
	font-size: 20px;
	font-weight: bold;
}

form button:hover {
	background-color: #CCC;
}
</style>
</head>



<script type="text/javascript">
	// ��֤���벻Ϊ�յĽű�����
	function checkForm(form) {
		if (form.id.value == "") {
			alert("�û�������Ϊ��!");
			form.id.focus();
			return false;
		}
		if (form.password.value == "") {
			alert("���벻��Ϊ��!");
			form.password.focus();
			return false;
		}
		return true;
	}
</script>


<body>
	<div class="head body">
		<h1>���߲���ϵͳ</h1>
	</div>
	<div class="context body">
		<div class="container">
			<h1>Welcome</h1> 
			<h3><FONT color="red"><s:actionerror/></FONT></h3><!--��ʾ������Ϣ -->
			<form name="myform" action="login.action" method="post" onsubmit="return checkForm(this);">
				<input type="text" id="id" name="id" placeholder="�������˺�" class="input" style="ime-mode: disabled;">
				<input type="password" id="password" name="password" placeholder="����������"
					class="input" style="ime-mode: disabled;">
				<table style="height: 62px;margin-left:30%;font-size:20px;">
					<tr>
						<td width="14%" height="35" style="width: 100px; "><span>��¼��ɫ��</span></td>
						<td height="35" colspan="2"><input type="radio" name="role"
							value="admin">����Ա <input type="radio"
							name="role" value="user" checked="checked">��ͨ�û�</td>    	
					</tr>
				</table>
				<button type="submit" id="Submit" value="�� ¼">��&nbsp;¼</button>
				<button type="reset" id="Reset" value="����">��&nbsp;��</button>
				<a href="http://localhost:8080/Blog/user/register.jsp"
					id="aid"><h3>ע���û�</h3></a>
			</form>
		</div>
	</div>
</body>
</html>
