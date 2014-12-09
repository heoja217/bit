<%@page import="java63.servlets.test05.domain.Product"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>jsp:useBean 액션태그 </h1>


<jsp:useBean type="java63.servlets.test05.domain.Product" id="product"
class="java63.servlets.test05.domain.Product" scope="page" />

제품명:<%=product.getName() %><br>
수량:<%=product.getQuantity() %><br>
제조사번호:<%=product.getMakerNo() %><br>


<jsp:useBean 
	id="product2"
	class="java63.servlets.test05.domain.Product" 
	scope="page" />

제품명:<%=product2.getName() %><br>
수량:<%=product2.getQuantity() %><br>
제조사번호:<%=product2.getMakerNo() %><br>


<h2>3. 빈 객체 생성(class 속성 생략)</h2>
<p> </p>
<%-- 
<jsp:useBean 
	id="product3"
	type="java63.servlets.test05.domain.Product" 
	scope="page" />

<!-- 
Product product3 -->

제품명:<%=product3.getName() %><br>
수량:<%=product3.getQuantity() %><br>
제조사번호:<%=product3.getMakerNo() %><br>
 --%>

<h2>4. 빈 객체 찾기</h2>

<%
Product temp = new Product();
temp.setName("ohora");
temp.setQuantity(200);
temp.setMakerNo(2);
pageContext.setAttribute("product4", temp);
%>

<jsp:useBean 
	id="product4"
	type="java63.servlets.test05.domain.Product" 
	scope="page" />

제품명:<%=product4.getName() %><br>
수량:<%=product4.getQuantity() %><br>
제조사번호:<%=product4.getMakerNo() %><br>


</body>
</html>
















