<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="user/login" method="post">
		<label><span>姓名：</span><input name="name" type="text"/></label>
		<label><span>密码：</span><input name="password" type="password"/></label>
		<label><span>备注：</span><input name="beizhu" type="name"/></label>
		<input type="submit" value="登陆" />
	</form>
	
	<hr/>
	
	<form action="user-add" method="post">
		<label><span>姓名：</span><input name="user.name" type="text"/></label>
		<label><span>密码：</span><input name="user.password" type="password"/></label>
		<label><span>备注：</span><input name="beizhu" type="name"/></label>
		<input type="submit" value="添加用户" />
	</form>
</body>
</html>