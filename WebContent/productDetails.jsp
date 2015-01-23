<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="header.jsp" />
</head>
<body>
	<table border="1">
		<tr>
			<th>NAME</th>
			<th>BAR_CODE</th>
			<th>DESCRIPTION</th>
			<th>AVERAGE_PRICE</th>
			<th>LOWEST_PRICE</th>
			<th>HIGHEST_PRICE</th>
		</tr>

		<tr>
			<c:choose>
				<c:when test="${not empty product}">
					<td>${product.name}</td>
					<td>${product.barCode}</td>
					<td>${product.description}</td>
					<td>${product.averagePrice}</td>
					<td>${product.lowestPrice}</td>
					<td>${product.highestPrice}</td>
				</c:when>
				<c:otherwise>
					<td colspan="6" align="center">No Records Found.</td>
				</c:otherwise>
			</c:choose>

		</tr>

	</table>
</body>
</html>