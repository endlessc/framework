<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if("/".equals(path))
	path = "";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function changImage(){
		document.getElementById("ImagesServlet").src="<%=path%>/ImageServlet?r=" + Math.random();
	}
</script>
</head>
<body>
<table>
	<tr>
		<td align="center"><span class="inputname">验证码:</span></td>
		<td width="133"><input type="text" name="rand" id="rand" class="input6" /></td>
		<td width="165" align="center">
			<img src="<%=path %>/ImageServlet" id="ImagesServlet" onclick="changImage()" />
			<span onclick="changImage()">换一张</span>
		</td>
	</tr>
</table>
</body>
</html>