<%@page import="zaietsv.complextask.mvc.entity.instance.Role"%>
<%@ page import="zaietsv.complextask.mvc.entity.instance.Roles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Role table</title>
</head>
<body>
<h1>Role table</h1>
<a href="AdminInstancesServlet"><button>Backward</button></a><hr>
last action = <%=request.getParameter("action") %>
<% Roles roles = (Roles)request.getSession().getAttribute("roles"); %>

<table frame="border" border="1">
  <tr bgcolor="magenta">
    <th>Id</th>
    <th>Name</th>
    <th>Action</th>
  </tr>
<%String action = request.getParameter("action"); action = action == null ? "" : action;%>
<%Long id = 5L; %>
<%try { %><%id = Long.parseLong(request.getParameter("id"));%> <%} catch (NumberFormatException e) { %><%} %>
  
<%for (Role role : roles.getInstances()) {%>
  <%if (role.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>


  <%if (action.matches("edit") && role.getId() == id) { %>
<form action="AdminInstancesServlet" method="post" name="action">
		<td><%=role.getId() %>
            <input type="hidden" title="table" name="table" value="role">
            <input type="hidden"  title="id" name="id" value="<%=role.getId() %>"></td>
		<td><input type="text" name="name" value="<%=role.getName() %>" title="edit name"></td>
		<td><input type="submit" title="update changes" name="action" value="update">
		<input type="submit" title="revert changes" name="action" value="cancel"></td>
</form>
  
  <%} else { %>
    <td><%=role.getId() %></td>
	<td><%=role.getName() %></td>
	<td>
		<form action="AdminInstancesServlet" method="get" name="action_<%=role.getId() %>">
            <input type="hidden" title="table" name="table" value="role">
            <input type="hidden" title="id" name="id" value="<%=role.getId() %>">
			<input type="submit" title="details of an item" name="action" value="details">
			<input type="submit" title="edit an existing item" name="action" value="edit">
			<input type="submit" title="delete an item" name="action" value="delete">
		</form>
	</td>

<%} %>
  </tr>
<%} %>
	<tr>
	<form action="AdminInstancesServlet" method="post" name="action">
		<td><input type="hidden" title="table" name="table" value="role"></td>
		<td><label>
			Name:
			<input type="text" name="name" value="name">
		</label></td>
		<td><input type="submit" title="insert a new item" name="action" value="insert"></td>
	</form>
	</tr>
</table>
<hr><a href="AdminInstancesServlet"><button>Backward</button></a>
</body>
</html>