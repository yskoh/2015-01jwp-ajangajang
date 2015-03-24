<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/users/save" method="post">
		<div>
			<label>아이디</label>
			<input type="text" id="userId" name="userId" value="" placeholder=""/>
		</div>
		<div>
			<label>비밀번호</label>
			<input type="password" id="password" name="password" value="" placeholder=""/>
		</div>
		<div>
			<label>이름</label>
			<input type="text" id="name" name="name" value="" placeholder=""/>
		</div>
		<div>
			<label>이메일</label>
			<input type="text" id="email" name="email" value="" placeholder=""/>
		</div>
		<div>
			<button>회원 가입</button>
		</div>
	</form>
</body>
</html>