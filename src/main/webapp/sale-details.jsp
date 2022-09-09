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
<title>Sale Details</title>
</head>
<body>
    <%!String formatDateTime(LocalDateTime date) {
		return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	}%>
  <%
    Voucher voucher=(Voucher)request.getAttribute("data");
  %>
  <!-- Title -->
  <h1>Sale Details</h1>
  <table>
  	<tr>
  		<td>Voucher ID</td>
  		<td><%=voucher.getId() %></td>
  	</tr>
  	<tr>
  		<td>Customer Name</td>
  		<td><%=voucher.getCustomer() %></td>
  	</tr>
  	<tr>
  		<td>Sale Date Time</td>
  		<td><%=formatDateTime(voucher.getSaleTime()) %></td>
  	</tr>
  </table>
  <h3>Sale Items</h3>
  <table>
    <thead>
    	<tr>
    		<td>Product</td>
    		<td>Category</td>
    		<td>Unit Price</td>
    		<td>Qty</td>
    		<td>Total</td>
    	</tr>
    </thead>
    <tbody>
      <%for(SaleItem item:voucher.getSales()){ %>
      <tr>
      	<td><%=item.getProduct().getName() %></td>
      	<td><%=item.getProduct().getCategory() %></td>
      	<td><%=item.getProduct().getPrice() %></td>
      	<td><%=item.getCount() %></td>
      	<td><%=item.getTotal() %></td>
      </tr>
      <%} %>
    </tbody>
  </table>
  <hr/>
  <a href="index.jsp">Home</a>
</body>
</html>