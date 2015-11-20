<%@page import="zaietsv.complextask.mvc.entity.UserAddressRoleMusics"%>
<%@ page import="zaietsv.complextask.mvc.entity.instance.*" %>
<%@ page import="zaietsv.complextask.mvc.localization.Localization" %>
<%@ page import="zaietsv.complextask.mvc.localization.MusicUsersLocalization" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="cache-control" content="no-cache, no-store, must-revalidate">
	<% Localization l = MusicUsersLocalization.getInstance(request); %>
<title><%=l.tr("musicUsersTable")%></title>
</head>
<body>
<h1 style="background-color: crimson"><%=l.tr("userAddressRoleMusicsTable")%></h1>
<a href="AdminWorks?table=user"><button><%=l.tr("backwardButton")%></button></a><hr>
<%String action = request.getParameter("action"); action = action == null ? "" : action;%>
last action = <%=action %>
<% UserAddressRoleMusics uarm = (UserAddressRoleMusics)request.getSession().getAttribute("userAddressRoleMusics"); %>
<%String id = request.getParameter("id");%>
<% User user = uarm.getUser(); %>
<% Address address = uarm.getAddress(); %>
<% Role role = uarm.getRole(); %>
<% Musics musics = uarm.getMusics(); %>

<h2><%=l.tr("userHeader")%></h2>
<table frame="border" border="1">
	<tr bgcolor="magenta"><th><%=l.tr("idHeader")%></th><th><%=l.tr("loginHeader")%></th><th><%=l.tr("passwordHeader")%></th><th><%=l.tr("emailHeader")%></th><th><%=l.tr("regDateHeader")%></th></tr>
	<%if (user == null) { %>
		<tr><td colspan="6" align="center">Empty list</td></tr>
	<%} else { %>
		<%if (user.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%>
		<tr bgcolor="cyan"><%} %>
		<td><%=user.getId() %></td>
		<td><%=user.getLogin() %></td>
		<td><%=user.getPassword() %></td>
		<td><%=user.getEmail() %></td>
		<td><%=user.getReg_date() %></td>
	</tr>
	<%} %>
</table>

<h2><%=l.tr("addressHeader")%></h2>
<table frame="border" border="1">
	<tr bgcolor="magenta"><th><%=l.tr("idHeader")%></th><th><%=l.tr("postcodeHeader")%></th><th><%=l.tr("cityHeader")%></th><th><%=l.tr("streetHeader")%></th><th><%=l.tr("houseHeader")%></th><th><%=l.tr("flatHeader")%></th><th><%=l.tr("actionHeader")%></th></tr>
	<%if (address == null) { %>
		<tr><td colspan="7" align="center">Empty list</td></tr>
	<%} else { %>
		<%if (address.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
		<td><%=address.getId() %></td>
		<td><%=address.getPostcode() %></td>
		<td><%=address.getCity() %></td>
		<td><%=address.getStreet() %></td>
		<td><%=address.getHouse() %></td>
		<td><%=address.getFlat() %></td>
		<td>
			<a href="AdminWorks?table=address_user&id=<%=address.getId()%>" title="details on the item"><button><%=l.tr("detailsButton")%></button></a>
		</td>
	<%} %>
</tr>
</table>

<h2><%=l.tr("roleHeader")%></h2>
<table frame="border" border="1">
	<tr bgcolor="magenta"><th><%=l.tr("idHeader")%></th><th><%=l.tr("nameHeader")%></th><th><%=l.tr("actionHeader")%></th></tr>
	<%if (role == null) { %>
	<tr><td colspan="3" align="center">Empty list</td></tr>
	<% } else { %>
	<%if (role.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
		<td><%=role.getId() %></td>
		<td><%=role.getName() %></td>
		<td>
			<a href="AdminWorks?table=role_users&action=details&id=<%=role.getId()%>" title="details on the item"><button><%=l.tr("detailsButton")%></button></a>
		</td>
	</tr>
	<%} %>
</table>

<h2><%=l.tr("musicsHeader")%></h2>
<table frame="border" border="1">
	<tr bgcolor="magenta"><th><%=l.tr("idHeader")%></th><th><%=l.tr("nameHeader")%></th><th><%=l.tr("ratingHeader")%></th><th><%=l.tr("actionHeader")%></th></tr>
	<%String music_id = request.getParameter("music_id");%>
	<%if (musics.getInstances().isEmpty()) { %>
	<tr><td colspan="4" align="center">Empty list</td></tr>
	<% } else { %>
	<%for (Music music : musics.getInstances()) {%>
	<%if (music.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
	<td><%=music.getId() %></td>
	<td><%=music.getName() %></td>
	<td><%=music.getRating() %></td>
	<td>
		<a href="AdminWorks?table=music_users&action=details&id=<%=music.getId()%>" title="details on the item"><button><%=l.tr("detailsButton")%></button></a>
	</td>
	<%} %>
	</tr>
	<%} %>
</table>
<hr><a href="AdminWorks?table=user"><button><%=l.tr("backwardButton")%></button></a>
</body>
</html>