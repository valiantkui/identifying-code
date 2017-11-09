<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">


</script>
</head>
<body>
<%--

	谨记：不能用js来检验验证码是否正确
		当一个jsp加载时默认先执行java代码，然后再加载页面内容

 --%>
<form action="checkimg" onsubmit="return checkImgCode();">

	<input type="text"  name="imgCode" id="code" value="">
	<%-- 当用户点击图片验证码时，重新生成一张图片验证码，onclick事件中的代码中的src地址后随机数是告诉浏览器图片地址发生改变，
	重新加载，否则如果更改的地址不变的话，浏览器不会重新加载图片
	--%>
	<img src="checkcode" alt="验证码" onclick="this.src='checkcode?p='+Math.random();"/>
	<input type="submit"  value="提交"><span id="message" style="color: red;"></span>
</form>

</body>
</html>