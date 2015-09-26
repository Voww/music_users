<%@page import="zaietsv.complextask.mvc.entity.instance_detail.AddressUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
<title>Address To User table</title>
</head>
<body>
<h1>Address To User table</h1>
<a href="AdminInstancesServlet?table=address"><button>Backward</button></a><hr>
last action = <%=request.getParameter("action") %>
<h2>Address</h2>
<% AddressUser addressUser = (AddressUser)request.getSession().getAttribute("addressUser"); %>

<table frame="border" border="1">
	<tr bgcolor="magenta"><th>Id</th><th>Postcode</th><th>City</th><th>Street</th><th>House</th><th>Flat</th><th>Action</th></tr>
	<%String action = request.getParameter("action"); action = action == null ? "" : action;%>
	<%Long address_id = null; %>
	<%try { %><%address_id = Long.parseLong(request.getParameter("address_id"));%> <%} catch (NumberFormatException e) { %><%} %>


	<%if (addressUser.getInstance() == null) { %>
	<tr>
		<form action="AdminInstanceDetailsServlet" method="post" name="action">
			<td><input type="hidden" title="table" name="table" value="address_user"></td>
			<td><label>Postcode:<input type="text" name="postcode" value="000000"></label></td>
			<td><label>City:<input type="text" name="city" value="city"></label></td>
			<td><label>Street:<input type="text" name="street" value="street"></label></td>
			<td><label>House:<input type="text" name="house" value="0"></label></td>
			<td><label>Flat:<input type="text" name="flat" value="000"></label></td>
			<td><input type="submit" title="insert a new item" name="action" value="insert"></td>
		</form>
	</tr>
	<!% } else if (action.matches("edit") && address_id != null &&  addressUser.getInstance().getId() == address_id) { %!>
	<% } else if (action.matches("edit")) { %>
	<%if (addressUser.getInstance().getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
	<form action="AdminInstanceDetailsServlet" method="post" name="action">
		<td><%=addressUser.getInstance().getId() %>
			<input type="hidden" title="table" name="table" value="address_user">
			<input type="hidden"  title="id" name="address_id" value="<%=addressUser.getInstance().getId() %>">
			<input type="hidden"  title="id" name="user_id" value="<%=addressUser.getDetail().getId() %>"></td>
		<td><input type="text" name="postcode" value="<%=addressUser.getInstance().getPostcode() %>" title="edit postcode"></td>
		<td><input type="text" name="city" value="<%=addressUser.getInstance().getCity() %>" title="edit city"></td>
		<td><input type="text" name="street" value="<%=addressUser.getInstance().getStreet() %>" title="edit address"></td>
		<td><input type="text" name="house" value="<%=addressUser.getInstance().getHouse() %>" title="edit street"></td>
		<td><input type="text" name="flat" value="<%=addressUser.getInstance().getFlat() %>" title="edit flat"></td>
		<td><input type="submit" title="update changes" name="action" value="update">
			<input type="submit" title="revert changes" name="action" value="cancel"></td>
	<!/form>

	<%} else { %>
	<%if (addressUser.getInstance().getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
	<td><%=addressUser.getInstance().getId() %></td>
	<td><%=addressUser.getInstance().getPostcode() %></td>
	<td><%=addressUser.getInstance().getCity() %></td>
	<td><%=addressUser.getInstance().getStreet() %></td>
	<td><%=addressUser.getInstance().getHouse() %></td>
	<td><%=addressUser.getInstance().getFlat() %></td>
	<td>
		<form action="AdminInstanceDetailsServlet" method="get" name="action_<%=addressUser.getInstance().getId() %>">
			<input type="hidden" title="table" name="table" value="address_user">
			<input type="hidden" title="id" name="address_id" value="<%=addressUser.getInstance().getId() %>">
			<input type="hidden"  title="id" name="user_id" value="<%=addressUser.getDetail().getId() %>">
			<!input type="submit" title="details of an item" name="action" value="details">
			<input type="submit" title="edit an existing item" name="action" value="edit">
			<input type="submit" title="delete an item" name="action" value="delete">
		</form>
	</td>

	<%} %>
</tr>
</table>

<h2>User</h2>
<table frame="border" border="1">
	<tr bgcolor="magenta">
		<th>Id</th>
		<th>Login</th>
		<th>Password</th>
		<th>Email</th>
		<th>Registration date</th>
		<th>Action</th>
	</tr>

	<%Long user_id = null; %>
	<%try { %><%user_id = Long.parseLong(request.getParameter("user_id"));%> <%} catch (NumberFormatException e) { %><%} %>
	<%if (addressUser.getDetail() == null) { %>
	<tr>
		<form action="AdminInstanceDetailsServlet" method="post" name="action">
			<td><input type="hidden" title="table" name="table" value="address_user"></td>
			<td><label>Login:<input type="text" name="login" value="user_login"></label></td>
			<td><label>Password:<input type="text" name="password" value="user_password"></label></td>
			<td><label>Email:<input type="text" name="email" value="user_email"></label></td>
			<td></td>
			<td><input type="submit" title="insert a new item" name="action" value="insert"></td>
		</form>
	</tr>
	<!% } else if (action.matches("edit") && user_id != null && addressUser.getDetail().getId() == user_id) { %!>
	<% } else if (action.matches("edit")) { %>
	<%if (addressUser.getDetail().getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
	<!form action="AdminInstanceDetailsServlet" method="post" name="action"!>
		<td><%=addressUser.getDetail().getId() %></td>
		<td><input type="text" name="login" value="<%=addressUser.getDetail().getLogin() %>" title="edit login"></td>
		<td><input type="text" name="password" value="<%=addressUser.getDetail().getPassword() %>" title="edit password"></td>
		<td><input type="text" name="email" value="<%=addressUser.getDetail().getEmail() %>" title="edit email"></td>
		<td><%=addressUser.getDetail().getReg_date() %></td>
		<td><input type="submit" title="update changes" name="action" value="update">
			<input type="submit" title="revert changes" name="action" value="cancel"></td>
	</form>

	<%} else { %>
	<%if (addressUser.getDetail().getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
	<td><%=addressUser.getDetail().getId() %></td>
	<td><%=addressUser.getDetail().getLogin() %></td>
	<td><%=addressUser.getDetail().getPassword() %></td>
	<td><%=addressUser.getDetail().getEmail() %></td>
	<td><%=addressUser.getDetail().getReg_date() %></td>
	<td>
		<form action="AdminInstanceDetailsServlet" method="get" name="action_<%=addressUser.getDetail().getId() %>">
			<input type="hidden" title="table" name="table" value="address_user">
			<input type="hidden" title="id" name="address_id" value="<%=addressUser.getInstance().getId() %>">
			<input type="hidden" title="id" name="user_id" value="<%=addressUser.getDetail().getId() %>">
			<!input type="submit" title="details of an item" name="action" value="details">
			<input type="submit" title="edit an existing item" name="action" value="edit">
			<input type="submit" title="delete an item" name="action" value="delete">
		</form>
	</td>
	<%} %>
</tr>
</table>
<hr><a href="AdminInstancesServlet?table=address"><button>Backward</button></a>
</body>
</html>