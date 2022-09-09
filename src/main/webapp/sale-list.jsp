<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="com.jdc.shop.model.entity.*"%>
<%@page import="com.jdc.shop.model.*"%>
<%@page import="com.jdc.shop.listener.*"%>
<%@page import="com.jdc.controller.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sale History</title>
</head>
<body>
	<%!String formatDateTime(LocalDateTime date) {
		return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	}%>
	<%
	@SuppressWarnings("unchecked")
	 List<Voucher> list = (List<Voucher>) request.getAttribute("data");
	%>
	<!-- Tile-->
	<h1>Sale History</h1>
	<!-- Sale History -->
	<table style="width: 80%">
		<thead>
			<tr>
				<td>Voucher Id</td>
				<td>Sale Date Time</td>
				<td>Customer Name</td>
				<td>Item count</td>
				<td>Sale Total</td>
			</tr>
		</thead>
		<tbody>
			<%
			for (Voucher v : list) {
			%>
			<tr>
				<td>
				 <a href="sale-details?id=<%=v.getId()%>">	<%=v.getId()%></a>
			
				</td>
				<td><%=formatDateTime(v.getSaleTime())%></td>
				<td><%=v.getCustomer()%></td>
				<td><%=v.itemCount()%></td>
				<td><%=v.total()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>

</body>
</html>