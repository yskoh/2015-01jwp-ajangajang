<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/users/login" method="post">
	<c:if test="${not empty errorMessage}">
	<div>
		<label>${errorMessage } </label>
	</div>
	</c:if>
		<div>
			<label for="userId">ID here</label>
			<input type="text" id="userId" name="userId" value="" placeholder=""/>
		</div>
		<div>
			<label for="password">Password</label>
			<input type="password" id="password" name="password" value="" placeholder=""/>
		</div>
		<button type="submit">Enter</button>
	</form>
</body>
</html>