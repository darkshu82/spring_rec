<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>test/sophomore.jsp</h1>
  <h2> 2 학년 정보 목록</h2>
  <p>${sophomoreList }</p>
  <hr>
    <ul class="navbar-nav">
	
    <c:forEach var="sophomore" items="${sophomoreList }">
    <li class="nav-item">
		${sophomore.stdno} - ${sophomore.name} - ${sophomore.grade} - ${sophomore.deptname}
	</li>
    </c:forEach>
    
	</ul>
</body>
</html>