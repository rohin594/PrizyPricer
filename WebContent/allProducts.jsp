<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Insert title here</title>
<jsp:include page="header.jsp" />
</head>
<body>
	<h3>
		<a href="index">Back to Index Page</a>
	</h3>
	<br>
	<br>
	<table border="1">
		<tr>
			<th>NAME</th>
			<th>BAR_CODE</th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.name}</td>
				<td><a href="javascript:void();"
					onclick="loadData.performAction('productDetails/${product.barCode}')">${product.barCode}</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div id="data" align="center"></div>
</body>
</html>