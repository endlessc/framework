<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	window.onload=function(){
		$("#getBtn").click(function(){
			
			$.post("user-userJSON",null,function(json){
				alert(json);	
				
				$("#info").html("name : "+json.name);
			});
		});
		
	}
</script>
</head>
<body>
	<input id="getBtn" type="button" value="get info">
	<div id="info"></div>
</body>
</html>