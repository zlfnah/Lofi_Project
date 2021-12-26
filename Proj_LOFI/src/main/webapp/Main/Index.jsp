<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>로파이메인페이지</title>
<link rel="stylesheet" href="../style/Style.css">
</head>
<body>
<% // 메인 페이지로 이동했을 때 세션에 값이 담겨있는지 체크 
    String uID = null;
    if(session.getAttribute("uID") != null){
    	uID = (String)session.getAttribute("uID");
    	}
%>
<div id="wrap">
<!-- HTML템플릿(Template, Templet) 헤더 시작 -->
	<header id="header">
    	<% if(uID == null){ /* 로그인 안되있을때 */ %>
		<nav>
			<ul>
		    	<li><a href="../Main/Index.jsp">메인으로</a></li>
				<li><a href="../Account/Login.jsp">로그인</a></li>
				<li><a href="../Account/Join.jsp">회원가입</a></li>
				<li><a href="#">글쓰기</a></li>
				<li><a href="#">자유게시판</a></li>
			</ul>
		</nav>
		<%  }else{ %> <!-- 로그인이 되있을때 -->
    	<h4>반갑습니다! <%=uID %>님!</h4>
		<nav>
			<ul class="flex-container">
		    	<li><a href="../Main/Index.jsp">메인으로</a></li>
				<li><a href="../Account/LogoutAction.jsp">로그아웃</a></li>
				<li><a href="#">글쓰기</a></li>
				<li><a href="#">자유게시판</a></li>
			</ul>
		</nav>
		<% } %>
	</header>
<!-- HTML템플릿(Template, Templet) 헤더 끝 -->

<!-- 본문영역 html템플릿 시작 -->
	<main id="main">

	</main> <!-- 본문영역 html템플릿 끝 -->
 </div>
 <!-- div#wrap -->
 
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>