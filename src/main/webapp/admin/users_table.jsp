<%@page import="zaietsv.complextask.mvc.entity.instance.User"%>
<%@page import="zaietsv.complextask.mvc.entity.instance.Users"%>
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
<title><%=l.tr("userTable")%></title>
</head>
<body>
<h1 style="background-color: gold"><%=l.tr("userTable")%></h1>
<a href="AdminWorks"><button><%=l.tr("backwardButton")%></button></a><hr>
last action = <%=request.getParameter("action") %>
<% Users users = (Users)request.getSession().getAttribute("users"); %>

<table frame="border" border="1">
  <tr bgcolor="magenta"><th><%=l.tr("idHeader")%></th><th><%=l.tr("loginHeader")%></th><th><%=l.tr("passwordHeader")%></th><th><%=l.tr("emailHeader")%></th><th><%=l.tr("regDateHeader")%></th><th><%=l.tr("actionHeader")%></th></tr>

	<%String action = request.getParameter("action"); action = action == null ? "" : action;%>
<%Long id = 5L; %>
<%try { %><%id = Long.parseLong(request.getParameter("id"));%> <%} catch (NumberFormatException e) { %><%} %>
  
<%for (User user : users.getInstances()) {%>
  <%if (user.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>


  <%if (action.matches("edit") && user.getId() == id) { %>
<form action="AdminWorks" method="post" name="action">
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
		<a href="AdminWorks?table=user_address_role_musics&action=details&id=<%=user.getId()%>" title="details on the item"><button><%=l.tr("detailsButton")%></button></a>
		<a href="AdminWorks?table=user&action=edit&id=<%=user.getId()%>" title="edit the item"><button><%=l.tr("editButton")%></button></a>
		<a href="AdminWorks?table=user&action=delete&id=<%=user.getId()%>" title="delete the item"><button><%=l.tr("deleteButton")%></button></a>
	</td>
<%} %>
  </tr>
<%} %>
	<tr>
	<form action="AdminWorks" method="post" name="action">
		<td><input type="hidden" title="table" name="table" value="user"></td>
		<td><label>Login:<input type="text" name="login" value="user_login"></label></td>
		<td><label>Password:<input type="text" name="password" value="user_password"></label></td>
		<td><label>Email:<input type="text" name="email" value="user_email"></label></td>
		<td></td>
		<td><input type="submit" title="insert a new item" name="action" value="insert"></td>
	</form>
	</tr>
</table>
<hr><a href="AdminWorks"><button><%=l.tr("backwardButton")%></button></a>
</body>
</html>