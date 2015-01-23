<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<jsp:include page="header.jsp" />
<title>Insert title here</title>
</head>
<body>
	<h3 style="color: #ff0000;">${message}</h3>
	<form:form commandName="product" action="saveProduct">
		<table>
			<tr>
				<td>Store Name:</td>
				<td><form:input path="storeName" /></td>
			</tr>
			<tr>
				<td>Bar Code:</td>
				<td><form:input path="barCode" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td>Notes:</td>
				<td><form:input path="notes" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save Product" /></td>
				<td><input type="reset" value="Reset" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>