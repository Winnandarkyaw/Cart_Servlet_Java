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
	<hr/>
	<p>
		<a href="index.jsp">Back</a>
	</p>
	<hr />
	<%
	ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
	%>
	<table style="width: 70%">
		<tr>
			<td>Product</td>
			<td>Category</td>
			<td>Unit Price</td>
			<td style="text-align: center;">Count</td>
			<td>Total</td>
		</tr>
		<%
		for (SaleItem item : cart.items()) {
		%>
		<tr>
			<td><%=item.getProduct().getName()%></td>
			<td><%=item.getProduct().getCategory()%></td>
			<td><%=item.getProduct().getPrice()%></td>
			<td style="text-align: center">
				<!-- Minus Count --> <a
				href="cart-minus?product=<%=item.getProduct().getId()%>">-</a> <%=item.getCount()%>
				<!-- Plus Count --> <a
				href="cart-plus?product=<%=item.getProduct().getId()%>">+</a>
			</td>
			
			<td><%=item.getTotal()%></td>
		</tr>
		<%
		}
		%>
		<tr>
			<td colspan="3">Total</td>
			<td style="text-align: center;"><%=cart.itemCount()%></td>
			<td><%=cart.total()%></td>
		</tr>
	</table>

		<hr />
	<h3>Check Out</h3>
	<form action="checkout" method="post">
	 <label for="">Customer Name</label>
	 <input type="text"  placeholder="Enter Customer Name"  name="customer"/>
	 <button type="submit">Check Out</button>
	</form>
</body>
</html>