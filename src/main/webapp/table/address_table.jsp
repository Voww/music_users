<%@page import="zaietsv.complextask.mvc.holder.AddressHolder"%>
<%@page import="zaietsv.complextask.mvc.instance.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Address table</title>
</head>
<body>
<h1>Address table</h1>
last action = <%=request.getParameter("action") %>
<% AddressHolder addressHolder = (AddressHolder)request.getSession().getAttribute("addressHolder"); %>

<table frame="border" border="1">
  <tr bgcolor="magenta">
    <th>Id</th>
    <th>Postcode</th>
    <th>City</th>
    <th>Street</th>
    <th>House</th>
	  <th>Flat</th>
    <th>Action</th>
  </tr>
<%String action = request.getParameter("action"); action = action == null ? "" : action;%>
<%Long id = 5L; %>
<%try { %><%id = Long.parseLong(request.getParameter("id"));%> <%} catch (NumberFormatException e) { %><%} %>
  
<%for (Address address : addressHolder.getList()) {%>
  <%if (address.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>


  <%if (action.matches("edit") && address.getId() == id) { %>
<form action="AdminServlet" method="post" name="action">
		<td><%=address.getId() %>
			<input type="hidden" title="table" name="table" value="address">
            <input type="hidden"  title="id" name="id" value="<%=address.getId() %>"></td>
		<td><input type="text" name="postcode" value="<%=address.getPostcode() %>" title="edit postcode"></td>
		<td><input type="text" name="city" value="<%=address.getCity() %>" title="edit city"></td>
		<td><input type="text" name="street" value="<%=address.getStreet() %>" title="edit address"></td>
	<td><input type="text" name="house" value="<%=address.getHouse() %>" title="edit street"></td>
	<td><input type="text" name="flat" value="<%=address.getFlat() %>" title="edit flat"></td>
		<td><input type="submit" title="update changes" name="action" value="update">
		<input type="submit" title="revert changes" name="action" value="cancel"></td>
</form>
  
  <%} else { %>
    <td><%=address.getId() %></td>
	<td><%=address.getPostcode() %></td>
	<td><%=address.getCity() %></td>
	<td><%=address.getStreet() %></td>
	<td><%=address.getHouse() %></td>
	<td><%=address.getFlat() %></td>
	<td>
		<form action="AdminServlet" method="get" name="action_<%=address.getId() %>">
            <input type="hidden" title="table" name="table" value="address">
            <input type="hidden" title="id" name="id" value="<%=address.getId() %>">
			<input type="submit" title="details of an item" name="action" value="details">
			<input type="submit" title="edit an existing item" name="action" value="edit">
			<input type="submit" title="delete an item" name="action" value="delete">
		</form>
	</td>

<%} %>
  </tr>
<%} %>
	<tr>
	<form action="AdminServlet" method="post" name="action">
		<td><input type="hidden" title="table" name="table" value="address"></td>
		<td><label>
			Postcode:
			<input type="text" name="postcode" value="000000">
		</label></td>
		<td><label>
			City:
			<input type="text" name="city" value="city">
		</label></td>
		<td><label>
			Street:
			<input type="text" name="street" value="street">
		</label></td>
		<td><label>
			House:
			<input type="text" name="house" value="0">
		</label></td>
		<td><label>
			Flat:
			<input type="text" name="flat" value="000">
		</label></td>
		<td><input type="submit" title="insert a new item" name="action" value="insert"></td>
	</form>
	</tr>
</table>
<hr>
</body>
</html>