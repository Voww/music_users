<%@page import="zaietsv.complextask.mvc.entity.UserAddressRoleMusics"%>
<%@ page import="zaietsv.complextask.mvc.entity.instance.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
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
<h1 style="background-color: darkred">User to Address, Role, Musics table</h1>
<a href="AdminWorks"><button>Backward</button></a><hr>
<%String action = request.getParameter("action"); action = action == null ? "" : action;%>
<% UserAddressRoleMusics uarm = (UserAddressRoleMusics)request.getSession().getAttribute("loggedUser"); %>
<% User user = uarm.getUser(); %>
<% Address address = uarm.getAddress(); %>
<% Role role = uarm.getRole(); %>
<% Musics musics = uarm.getMusics(); %>

<h2>User</h2>
<table frame="border" border="1">
	<tr bgcolor="magenta"><th>Id</th><th>Login</th><th>Password</th><th>Email</th><th>Registration date</th><th>Action</th></tr>
	<%String id = request.getParameter("id");%>
	<%if (user == null) { %>
	<tr>
		<td>
			<form action="AdminWorks" method="post" name="action">
				<input type="hidden" title="table" name="table" value="user_address_role_musics">
				<td><label>Login:<input type="text" name="login" value="user_login"></label></td>
				<td><label>Password:<input type="text" name="password" value="user_password"></label></td>
				<td><label>Email:<input type="text" name="email" value="user_email"></label></td>
				<td></td>
				<td><input type="submit" title="insert a new item" name="action" value="insert">
			</form>
		</td>
	</tr>
	<%} else if (action.matches("edit") && id != null && user.getId() == Long.parseLong(id)) { %>
		<%if (user.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
		<form action="AdminWorks" method="post" name="action">
			<td><%=user.getId() %>
			<input type="hidden" title="table" name="table" value="user_address_role_musics">
			<input type="hidden"  title="id" name="id" value="<%=user.getId() %>">
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
			<a href="AdminWorks?table=user_address_role_musics&action=edit&id=<%=user.getId()%>" title="edit the item"><button>edit</button></a>
			<a href="AdminWorks?table=user_address_role_musics&action=delete&id=<%=user.getId()%>" title="delete the user and it's parameters"><button>delete</button></a>
		</td>
		<%} %>
	</tr>
</table>

<h2>Address</h2>
<table frame="border" border="1">
	<tr bgcolor="magenta"><th>Id</th><th>Postcode</th><th>City</th><th>Street</th><th>House</th><th>Flat</th><th>Action</th></tr>
	<%String address_id = request.getParameter("address_id");%>

	<%if (address == null) { %>
	<tr>
		<form action="AdminWorks" method="post" name="action">
		<td><input type="hidden" title="table" name="table" value="user_address_role_musics">
			<input type="hidden" title="id" name="id" value="<%=user.getId()%>"></td>
		<td><label>Postcode:<input type="text" name="postcode" value="000000"></label></td>
		<td><label>City:<input type="text" name="city" value="city"></label></td>
		<td><label>Street:<input type="text" name="street" value="street"></label></td>
		<td><label>House:<input type="text" name="house" value="0"></label></td>
		<td><label>Flat:<input type="text" name="flat" value="000"></label></td>
		<td><input type="submit" title="insert a new item" name="action" value="insert_address"></td>
		</form>
	</tr>
	<% } else if (action.matches("edit") && address_id != null) { %>
	<%if (address.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
	<form action="AdminWorks" method="post" name="action">
		<td><%=address.getId() %>
			<input type="hidden" title="table" name="table" value="user_address_role_musics">
			<input type="hidden"  title="id" name="id" value="<%=user.getId()%>">
			<input type="hidden"  title="id" name="address_id" value="<%=address.getId() %>"></td>
		<td><input type="text" name="postcode" value="<%=address.getPostcode() %>" title="edit postcode"></td>
		<td><input type="text" name="city" value="<%=address.getCity() %>" title="edit city"></td>
		<td><input type="text" name="street" value="<%=address.getStreet() %>" title="edit address"></td>
		<td><input type="text" name="house" value="<%=address.getHouse() %>" title="edit street"></td>
		<td><input type="text" name="flat" value="<%=address.getFlat() %>" title="edit flat"></td>
		<td><input type="submit" title="update changes" name="action" value="update">
			<input type="submit" title="revert changes" name="action" value="cancel"></td>
	</form>

		<%} else { %>
	<%if (address.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
	<td><%=address.getId() %></td>
	<td><%=address.getPostcode() %></td>
	<td><%=address.getCity() %></td>
	<td><%=address.getStreet() %></td>
	<td><%=address.getHouse() %></td>
	<td><%=address.getFlat() %></td>
	<td>
		<a href="AdminWorks?table=user_address_role_musics&action=edit&id=<%=user.getId()%>&address_id=<%=address.getId()%>" title="edit the item"><button>edit</button></a>
		<a href="AdminWorks?table=user_address_role_musics&action=delete_address&id=<%=user.getId()%>&address_id=<%=address.getId()%>" title="delete the address"><button>delete</button></a>
	</td>
	<%} %>
</tr>
</table>

<h2>Role</h2>
<table frame="border" border="1">
	<tr bgcolor="magenta"><th>Id</th><th>Name</th></tr>
	<%if (role.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
		<td><%=role.getId() %></td>
		<td><%=role.getName() %></td>
	</tr>
</table>

<h2>Musics</h2>

<table frame="border" border="1">
	<tr bgcolor="magenta"><th>Id</th><th>Name</th><th>Rating</th><th>Action</th></tr>
	<%String music_id = request.getParameter("music_id");%>
	<%if (musics != null) { %>
	<%for (Music music : musics.getInstances()) {%>
	<%if (action.matches("edit") && music_id != null) { %>
	<%if (music.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
	<form action="AdminWorks" method="post" name="action">
		<td><%=music.getId() %>
			<input type="hidden" title="table" name="table" value="user_address_role_musics">
			<input type="hidden"  title="id" name="id" value="<%=music.getId() %>">
			<input type="hidden"  title="id" name="music_id" value="<%=music.getId() %>"></td>
		<td><input type="text" name="name" value="<%=music.getName() %>" title="edit name"></td>
		<td><input type="text" name="name" value="<%=music.getRating() %>" title="edit rating"></td>
		<td><input type="submit" title="update changes" name="action" value="update">
			<input type="submit" title="revert changes" name="action" value="cancel"></td>
	</form>

<%} else { %>
	<%if (music.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
	<td><%=music.getId() %></td>
	<td><%=music.getName() %></td>
	<td><%=music.getRating() %></td>
	<td>
		<a href="AdminWorks?table=user_address_role_musics&action=unlink_music&id=<%=user.getId()%>&music_id=<%=music.getId()%>" title="unlink the music from the user (without deleting)"><button>unlink</button></a>
	</td>
	<%} %>
	<%} %>
	<%} %>
	</tr>

	<tr>
		<td colspan="3"></td>
		<td><a href="AdminWorks?table=user_address_role_musics&action=change_music&id=<%=user.getId()%>" title="change musics of the user"><button>change</button></a></td>
	</tr>
</table>

<% if (action.matches("change_music")) { %>
<h3>Change Music</h3>
<% Musics listedMusics = (Musics)request.getSession().getAttribute("listed_musics"); %>
<% ArrayList<Long> selectedMusics = (ArrayList<Long>) request.getSession().getAttribute("selected_musics"); %>
<form action="AdminWorks" method="post" name="action">
	<input type="hidden" title="table" name="table" value="user_address_role_musics">
	<input type="hidden"  title="id" name="id" value="<%=user.getId()%>">
	<table frame="border" border="1">
		<tr bgcolor="magenta">
			<th>Id</th><th>Name</th><th>Rating</th><th>Action</th>
		</tr>
		<%for (Music selector : listedMusics.getInstances()) {%>
		<%if (selector.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
		<td><%=selector.getId() %></td>
		<td><%=selector.getName() %></td><td>
			<%=selector.getRating() %></td>
		<td>
			<input type="checkbox" name="musics_id" value="<%=selector.getId() %>"
				   <% if (Collections.binarySearch(selectedMusics, selector.getId()) >= 0) { %>checked<% } %>>
		</td>
	</tr>
		<%} %>
		<tr>
			<td></td>
			<td><label>Name:<input type="text" name="name" value="name"></label></td>
			<td><label>Rating:<input type="text" name="rating" readonly value="0"></label></td>
			<td><input type="submit" title="insert a new item" name="action" value="insert_music"></td>
		</tr>
		<tr>
			<td colspan="3"></td>
			<td>
				<input type="submit" title="confirm selection" name="action" value="confirm_musics">
				<input type="submit" title="cancel selection" name="action" value="cancel">
			</td>
		</tr>
	</table>
</form>
<% } %>

<hr><a href="AdminWorks"><button>Backward</button></a>
</body>
</html>