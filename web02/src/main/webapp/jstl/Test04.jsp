<%@page import="java63.servlets.test05.domain.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Core 태그 사용</h1>
<h2>c:url</h2>
<p>URL을 만들어준다</p>

<c:url var="myUrl" value="http://localhost:8080/web02/test05/product/add">
	<c:param name="name" value="오호라폰"/>
	<c:param name="qty" value="100"/>
	<c:param name="mkno" value="5"/>
</c:url>
${pageScope.myUrl}<br>

<a href="${pageScope.myUrl}">등록</a>

<h2>c:import</h2>
<p>지정된 URL의 콘텐츠를 가져오기</p>
<textarea rows="10" cols="80">
<c:import url="http://www.daum.net"/>
</textarea>


</body>
</html>
















