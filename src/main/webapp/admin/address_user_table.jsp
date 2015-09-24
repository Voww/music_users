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
<a href="AdminInstancesServlet?table=address"><button>Backward</button></a>
last action = <%=request.getParameter("action") %><hr>

<% AddressUser addressUser = (AddressUser)request.getSession().getAttribute("addressUser"); %>

<form action="AdminInstanceDetailsServlet" method="post" name="action">
<table frame="border" border="1">
	<thead><h2>Address (instance)</h2></thead>
  <tr bgcolor="magenta">
    <th>Id</th><th>Postcode</th><th>City</th><th>Street</th><th>House</th><th>Flat</th><th>Action</th>
  </tr>
	<tr>
		<td><input type="hidden" title="table" name="table" value="address_user"></td>
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
	</tr>
</table>

<table frame="border" border="1">
	<thead><h2>User (detail)</h2></thead>
	<tr bgcolor="magenta">
		<th>Id</th><th>Login</th><th>Password</th><th>Email</th><th>Registration date</th><th>Action</th></tr>
	<tr>
		<td></td>
		<td><label>Login:<input type="text" name="login" value="user_login"></label></td>
		<td><label>Password:<input type="text" name="password" value="user_password"></label></td>
		<td><label>Email:<input type="text" name="email" value="user_email"></label></td>
		<td></td>
	</tr>
</table>
	<h3>Action:</h3>
	<input type="submit" title="insert a new item" name="action" value="insert">
</form>
<hr><a href="AdminInstancesServlet"><button>Backward</button></a>
</body>
</html>