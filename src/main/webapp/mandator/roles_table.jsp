<%@page import="zaietsv.complextask.mvc.entity.instance.Role"%>
<%@ page import="zaietsv.complextask.mvc.entity.instance.Roles" %>
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
<title><%=l.tr("roleTable")%></title>
</head>
<body>
<h1 style="background-color: blueviolet"><%=l.tr("roleTable")%></h1>
<a href="AdminWorks"><button><%=l.tr("backwardButton")%></button></a><hr>
<% Roles roles = (Roles)request.getSession().getAttribute("roles"); %>

<table frame="border" border="1">
  <tr bgcolor="magenta">
    <th><%=l.tr("idHeader")%></th><th><%=l.tr("nameHeader")%></th><th><%=l.tr("actionHeader")%></th>
  </tr>
<%for (Role role : roles.getInstances()) {%>
  <%if (role.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
    <td><%=role.getId() %></td>
	<td><%=role.getName() %></td>
	<td>
		<a href="AdminWorks?table=role_users&action=details&id=<%=role.getId()%>" title="details on the item"><button><%=l.tr("detailsButton")%></button></a>
	</td>
  </tr>
<%} %>
</table>
<hr><a href="AdminWorks"><button><%=l.tr("backwardButton")%></button></a>
</body>
</html>