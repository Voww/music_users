<%@page import="zaietsv.complextask.mvc.entity.instance_detail.AddressUser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
	<meta http-equiv="cache-control" content="no-cache, no-store, must-revalidate">
<title>Address To User table</title>
</head>
<body>
<h1>Address To User table</h1>
<a href="MandatorWorks?table=address"><button>Backward</button></a><hr>
last action = <%=request.getParameter("action") %>
<h2>Address</h2>
<% AddressUser addressUser = (AddressUser)request.getSession().getAttribute("addressUser"); %>

<table frame="border" border="1">
	<tr bgcolor="magenta"><th>Id</th><th>Postcode</th><th>City</th><th>Street</th><th>House</th><th>Flat</th></tr>
	<%if (addressUser.getInstance().getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
	<td><%=addressUser.getInstance().getId() %></td>
	<td><%=addressUser.getInstance().getPostcode() %></td>
	<td><%=addressUser.getInstance().getCity() %></td>
	<td><%=addressUser.getInstance().getStreet() %></td>
	<td><%=addressUser.getInstance().getHouse() %></td>
	<td><%=addressUser.getInstance().getFlat() %></td>
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
	<%if (addressUser.getDetail() == null) {%>
	<tr><td colspan="6" align="center">Empty list</td></tr>
	<%} else {%>
	<%if (addressUser.getDetail().getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%>
	<tr bgcolor="cyan"><%} %>
		<td><%=addressUser.getDetail().getId() %></td>
		<td><%=addressUser.getDetail().getLogin() %></td>
		<td><%=addressUser.getDetail().getPassword() %></td>
		<td><%=addressUser.getDetail().getEmail() %></td>
		<td><%=addressUser.getDetail().getReg_date() %></td>
		<td>
			<a href="MandatorWorks?table=user_address_role_musics&action=details&id=<%=addressUser.getDetail().getId()%>" title="details on the item"><button>details</button></a>
		</td>
	</tr><%} %>
</table>
<hr><a href="MandatorWorks?table=address"><button>Backward</button></a>
</body>
</html>