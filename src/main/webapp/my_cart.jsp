<%@page import="com.jdc.shop.model.ShoppingCart"%>
<%@page import="com.jdc.shop.model.*"%>
<%@page import="com.jdc.shop.model.entity.*"%>
<%@page import="com.jdc.shop.listener.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Cart</title>
</head>
<body>
	<h1>My Cart</h1>
	<p>Item Details in shopping Cart</p>
	<%
	ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
	%>
	<table style="width:70%">
		<tr>
			<td>Product</td>
			<td>Category</td>
			<td>Unit Price</td>
			<td></td>
			<td>Count</td>
			<td></td>
			<td>Total</td>
		</tr>
		<%
		for (SaleItem item : cart.items()) {
		%>
		<tr>
			<td><%=item.getProduct().getName()%></td>
			<td><%=item.getProduct().getCategory()%></td>
			<td><%=item.getProduct().getPrice()%></td>
			<td></td>
			<td><%=item.getCount()%></td>
			<td></td>
			<td><%=item.getTotal()%></td>
		</tr>
		<%
		}
		%>
		<tr>
			<td colspan="6">Total</td>
			<td><%=cart.total()%></td>
		</tr>
	</table>
	<p>
	  <a href="index.jsp">Back</a>
	</p>
</body>
</html>