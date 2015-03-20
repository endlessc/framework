<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if("/".equals(path))
	path="";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=path%>/js/jquery/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery/jquery.form.js"></script>
<script type="text/javascript">
	window.onload=function(){
		var btn = document.getElementById("ajaxsubmitbtn");
		btn.onclick=function(){
			var form = document.getElementById("testForm");
			var options = {
					success:function(data){
						alert("aa");
					},
					error:function(){
						alert("错误");
					}
			};
			$('#testForm').ajaxSubmit(options);
		}
	}
</script>
</head>
<body>


<form action="<%=path%>/message/get" method="post" id="testForm">
	用户名：<input type="text" name="name"/> <br />
	用户密码：<input type="password" name="password" /><br />
	<input type="submit" value="提交"/>
	<input id="ajaxsubmitbtn" type="button" value="AjaxSubmit提交" />
</form>


-----------------------------------------------------------------------


</body>
</html>