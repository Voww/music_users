<%@page import="zaietsv.complextask.mvc.holder.UserHolder"%>
<%@page import="zaietsv.complextask.mvc.instance.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>User table</title>
</head>
<body>
<h1>User table</h1>
last action = <%=request.getParameter("action") %>
<% UserHolder userHolder = (UserHolder)request.getSession().getAttribute("userHolder"); %>

<table frame="border" border="1">
  <tr bgcolor="magenta">
    <th>Id</th>
    <th>Login</th>
    <th>Password</th>
    <th>Email</th>
    <th>Registration date</th>
    <th>Action</th>
  </tr>
<%String action = request.getParameter("action"); action = action == null ? "" : action;%>
<%Long id = 5L; %>
<%try { %><%id = Long.parseLong(request.getParameter("id"));%> <%} catch (NumberFormatException e) { %><%} %>
  
<%for (User user : userHolder.getList()) {%>
  <%if (user.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>


  <%if (action.matches("edit") && user.getId() == id) { %>
<form action="AdminServlet" method="post" name="action">
		<td><%=user.getId() %>
            <input type="hidden" title="table" name="table" value="user">
            <input type="hidden"  title="id" name="id" value="<%=user.getId() %>"></td>
		<td><input type="text" name="login" value="<%=user.getLogin() %>" title="edit login"></td>
		<td><input type="text" name="password" value="<%=user.getPassword() %>" title="edit password"></td>
		<td><input type="text" name="email" value="<%=user.getEmail() %>" title="edit email"></td>
		<td><%=user.getReg_date() %></td>
		<td><input type="submit" title="update changes" name="action" value="update">
		<input type="submit" title="revert changes" name="action" value="cancel"></td>
</form>
  
  <%} else { %>
    <td><%=user.getId() %></td>
	<td><%=user.getLogin() %></td>
	<td><%=user.getPassword() %></td>
	<td><%=user.getEmail() %></td>
	<td><%=user.getReg_date() %></td>
	<td>
		<form action="AdminServlet" method="get" name="action_<%=user.getId() %>">
            <input type="hidden" title="table" name="table" value="user">
            <input type="hidden" title="id" name="id" value="<%=user.getId() %>">
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
		<td><input type="hidden" title="table" name="table" value="user"></td>
		<td><label>
			Login:
			<input type="text" name="login" value="user_login">
		</label></td>
		<td><label>
			Password:
			<input type="text" name="password" value="user_password">
		</label></td>
		<td><label>
			Email:
			<input type="text" name="email" value="user_email">
		</label></td>
		<td></td>
		<td><input type="submit" title="insert a new item" name="action" value="insert"></td>
	</form>
	</tr>
</table>
<hr>
</body>
</html>