<%@page import="zaietsv.complextask.mvc.entity.instance.User"%>
<%@ page import="zaietsv.complextask.mvc.entity.instance_detail.RoleUsers" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="cache-control" content="no-cache, no-store, must-revalidate">
<title>Role To Users table</title>
</head>
<body>
<h1>Role To Users table</h1>
<a href="AdminWorks?table=role"><button>Backward</button></a><hr>
last action = <%=request.getParameter("action") %>
<h2>Role</h2>
<% RoleUsers roleUsers = (RoleUsers)request.getSession().getAttribute("roleUsers"); %>

<table frame="border" border="1">
	<tr bgcolor="magenta"><th>Id</th><th>Name</th><th>Action</th></tr>
	<%String action = request.getParameter("action"); action = action == null ? "" : action;%>
	<%String role_id = request.getParameter("role_id");%>
	<%String user_id = request.getParameter("user_id");%>

	<%if (roleUsers.getInstance() == null) { %>
	<tr>

			<td><form action="AdminWorks" method="post" name="action">
				<input type="hidden" title="table" name="table" value="role_users"></td>
			<td><label>Role:<input type="text" name="name" value="user"></label></td>
			<td><input type="submit" title="insert a new item" name="action" value="insert"></td>
	</tr>
	<% } else if (action.matches("edit") && role_id != null) { %>
	<%if (roleUsers.getInstance().getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
	<form action="AdminWorks" method="post" name="action">
		<td><%=roleUsers.getInstance().getId() %>
			<input type="hidden" title="table" name="table" value="role_users">
			<input type="hidden"  title="id" name="id" value="<%=roleUsers.getInstance().getId() %>">
			<input type="hidden"  title="id" name="role_id" value="<%=roleUsers.getInstance().getId() %>"></td>
		<td><input type="text" name="name" value="<%=roleUsers.getInstance().getName() %>" title="edit name"></td>
		<td><input type="submit" title="update changes" name="action" value="update">
			<input type="submit" title="revert changes" name="action" value="cancel"></td>
	</form>

	<%} else { %>
	<%if (roleUsers.getInstance().getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
	<td><%=roleUsers.getInstance().getId() %></td>
	<td><%=roleUsers.getInstance().getName() %></td>
	<td>
		<a href="AdminWorks?table=role_users&action=edit&id=<%=roleUsers.getInstance().getId()%>&role_id=<%=roleUsers.getInstance().getId()%>" title="edit the item"><button>edit</button></a>
		<a href="AdminWorks?table=role_users&action=unlink&id=<%=roleUsers.getInstance().getId()%>" title="unlink the role from the user (without deleting)"><button>unlink</button></a>
		<a href="AdminWorks?table=role_users&action=delete&id=<%=roleUsers.getInstance().getId()%>" title="delete the role"><button>delete</button></a>

	</td>

	<%} %>
</tr>
</table>

<h2>Users</h2>
<table frame="border" border="1">
	<tr bgcolor="magenta">
		<th>Id</th>
		<th>Login</th>
		<th>Password</th>
		<th>Email</th>
		<th>Registration date</th>
		<th>Action</th>
	</tr>

	<% for (User user : roleUsers.getDetails().getInstances()) {%>
		<!% } else if (action.matches("edit") && user_id != null && user.getId() == user_id) { %!>
		<% if (action.matches("edit") && user_id != null && user.getId() == Long.parseLong(user_id)) { %>
		<%if (user.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
		<form action="AdminWorks" method="post" name="action">
			<td><%=user.getId() %>
			<input type="hidden" title="table" name="table" value="role_users">
			<input type="hidden"  title="id" name="id" value="<%=roleUsers.getInstance().getId() %>">
			<input type="hidden"  title="id" name="user_id" value="<%=user.getId() %>"></td>
			<td><input type="text" name="login" value="<%=user.getLogin() %>" title="edit login"></td>
			<td><input type="text" name="password" value="<%=user.getPassword() %>" title="edit password"></td>
			<td><input type="text" name="email" value="<%=user.getEmail() %>" title="edit email"></td>
			<td><%=user.getReg_date() %></td>
			<td><input type="submit" title="update changes" name="action" value="update">
				<input type="submit" title="revert changes" name="action" value="cancel"></td>
		</form>

		<%} else { %>
		<%if (user.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%>
		<tr bgcolor="cyan"><%} %>
		<td><%=user.getId() %></td>
		<td><%=user.getLogin() %></td>
		<td><%=user.getPassword() %></td>
		<td><%=user.getEmail() %></td>
		<td><%=user.getReg_date() %></td>
		<td>
			<a href="AdminWorks?table=user_address_role_musics&action=details&id=<%=user.getId()%>" title="details on the item"><button>details</button></a>
			<a href="AdminWorks?table=role_users&action=edit&id=<%=roleUsers.getInstance().getId()%>&user_id=<%=user.getId()%>" title="edit the item"><button>edit</button></a>
			<a href="AdminWorks?table=role_users&action=unlink&id=<%=roleUsers.getInstance().getId()%>&user_id=<%=user.getId()%>" title="unlink the user from the role (without deleting)"><button>unlink</button></a>
		</td>
		<%} %>
	<%} %>
	</tr>
	<tr>
		<td><%if (roleUsers.getInstance() != null) { %>
			<form action="AdminWorks" method="post" name="action">
				<input type="hidden" title="table" name="table" value="role_users">
				<input type="hidden"  title="id" name="id" value="<%=roleUsers.getInstance().getId()%>"><%}%></td>
		<td><label>Login:<input type="text" name="login" value="user_login"></label></td>
		<td><label>Password:<input type="text" name="password" value="user_password"></label></td>
		<td><label>Email:<input type="text" name="email" value="user_email"></label></td>
		<td></td>
		<td><input type="submit" title="insert a new item" name="action" value="insert">
			</form></td>
	</tr>
</table>
<hr><a href="AdminWorks?table=role"><button>Backward</button></a>
</body>
</html>