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
<%for (User user : users.getInstances()) {%>
  <%if (user.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
    <td><%=user.getId() %></td>
	<td><%=user.getLogin() %></td>
	<td><%=user.getPassword() %></td>
	<td><%=user.getEmail() %></td>
	<td><%=user.getReg_date() %></td>
	<td>
		<a href="AdminWorks?table=user_address_role_musics&action=details&id=<%=user.getId()%>" title="details on the item"><button><%=l.tr("detailsButton")%></button></a>
	</td>
  </tr>
<%} %>
</table>
<hr><a href="AdminWorks"><button><%=l.tr("backwardButton")%></button></a>
</body>
</html>