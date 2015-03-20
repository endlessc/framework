<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if("/".equals(path))
	path="";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=path%>/js/common/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	window.onload=function(){
		
		window.onclick=function(){
			
			$("#abc").append("点一下</br>");
		}
	}
</script>
</head>
<body>
aaaa

<span id="abc"></span>
</body>
</html>