<%@page import="zaietsv.complextask.mvc.entity.instance.User"%>
<%@ page import="zaietsv.complextask.mvc.entity.instance_detail.MusicUsers" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="cache-control" content="no-cache, no-store, must-revalidate">
<title>Music To Users table</title>
</head>
<body>
<h1>Music To Users table</h1>
<a href="AdminWorks?table=music"><button>Backward</button></a><hr>
last action = <%=request.getParameter("action") %>
<h2>Music</h2>
<% MusicUsers musicUsers = (MusicUsers)request.getSession().getAttribute("musicUsers"); %>

<table frame="border" border="1">
	<tr bgcolor="magenta"><th>Id</th><th>Name</th><th>Rating</th><th>Action</th></tr>
	<%String action = request.getParameter("action"); action = action == null ? "" : action;%>
	<%String music_id = request.getParameter("music_id");%>
	<%String user_id = request.getParameter("user_id");%>

	<%if (musicUsers.getInstance() == null) { %>
	<tr>

			<td><form action="AdminWorks" method="post" name="action">
				<input type="hidden" title="table" name="table" value="music_users"></td>
			<td><label>Music:<input type="text" name="name" value="music"></label></td>
			<td><label>Rating:<input type="text" name="name" value="rating"></label></td>
			<td><input type="submit" title="insert a new item" name="action" value="insert"></td>
	</tr>
	<% } else if (action.matches("edit") && music_id != null) { %>
	<%if (musicUsers.getInstance().getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
	<form action="AdminWorks" method="post" name="action">
		<td><%=musicUsers.getInstance().getId() %>
			<input type="hidden" title="table" name="table" value="music_users">
			<input type="hidden"  title="id" name="id" value="<%=musicUsers.getInstance().getId() %>">
			<input type="hidden"  title="id" name="music_id" value="<%=musicUsers.getInstance().getId() %>"></td>
		<td><input type="text" name="name" value="<%=musicUsers.getInstance().getName() %>" title="edit name"></td>
		<td><input type="text" name="rating" value="<%=musicUsers.getInstance().getRating() %>" title="edit rating"></td>
		<td><input type="submit" title="update changes" name="action" value="update">
			<input type="submit" title="revert changes" name="action" value="cancel"></td>
	</form>

	<%} else { %>
	<%if (musicUsers.getInstance().getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
	<td><%=musicUsers.getInstance().getId() %></td>
	<td><%=musicUsers.getInstance().getName() %></td>
	<td><%=musicUsers.getInstance().getRating() %></td>
	<td>
		<a href="AdminWorks?table=music_users&action=edit&id=<%=musicUsers.getInstance().getId()%>&music_id=<%=musicUsers.getInstance().getId()%>" title="edit the item"><button>edit</button></a>
		<a href="AdminWorks?table=music_users&action=unlink&id=<%=musicUsers.getInstance().getId()%>" title="unlink the music from the user (without deleting)"><button>unlink</button></a>
		<a href="AdminWorks?table=music_users&action=delete&id=<%=musicUsers.getInstance().getId()%>" title="delete the music"><button>delete</button></a>

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

	<% for (User user : musicUsers.getDetails().getInstances()) {%>
		<!% } else if (action.matches("edit") && user_id != null && user.getId() == user_id) { %!>
		<% if (action.matches("edit") && user_id != null && user.getId() == Long.parseLong(user_id)) { %>
		<%if (user.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
		<form action="AdminWorks" method="post" name="action">
			<td><%=user.getId() %>
			<input type="hidden" title="table" name="table" value="music_users">
			<input type="hidden"  title="id" name="id" value="<%=musicUsers.getInstance().getId() %>">
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
			<a href="AdminWorks?table=music_users&action=edit&id=<%=musicUsers.getInstance().getId()%>&user_id=<%=user.getId()%>" title="edit the item"><button>edit</button></a>
			<a href="AdminWorks?table=music_users&action=unlink&id=<%=musicUsers.getInstance().getId()%>&user_id=<%=user.getId()%>" title="unlink the user from the music (without deleting)"><button>unlink</button></a>
			<a href="AdminWorks?table=music_users&action=delete&id=<%=musicUsers.getInstance().getId()%>&user_id=<%=user.getId()%>" title="delete the user"><button>delete</button></a>
		</td>
		<%} %>
	<%} %>
	</tr>
	<tr>
		<td><%if (musicUsers.getInstance() != null) { %>
			<form action="AdminWorks" method="post" name="action">
				<input type="hidden" title="table" name="table" value="music_users">
				<input type="hidden"  title="id" name="id" value="<%=musicUsers.getInstance().getId()%>"><%}%></td>
		<td><label>Login:<input type="text" name="login" value="user_login"></label></td>
		<td><label>Password:<input type="text" name="password" value="user_password"></label></td>
		<td><label>Email:<input type="text" name="email" value="user_email"></label></td>
		<td></td>
		<td><input type="submit" title="insert a new item" name="action" value="insert">
			</form></td>
	</tr>
</table>
<hr><a href="AdminWorks?table=music"><button>Backward</button></a>
</body>
</html>