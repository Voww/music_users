<%@page import="zaietsv.complextask.mvc.entity.instance.Music"%>
<%@page import="zaietsv.complextask.mvc.entity.instance.Musics"%>
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
<title><%=l.tr("musicTable")%></title>
</head>
<body>
<h1 style="background-color: blue"><%=l.tr("musicTable")%></h1>
<a href="AdminWorks"><button><%=l.tr("backwardButton")%></button></a><hr>
last action = <%=request.getParameter("action") %>
<% Musics musics = (Musics)request.getSession().getAttribute("musics"); %>

<table frame="border" border="1">
  <tr bgcolor="magenta">
    <th><%=l.tr("idHeader")%></th><th><%=l.tr("nameHeader")%></th><th><%=l.tr("ratingHeader")%></th><th><%=l.tr("actionHeader")%></th>
  </tr>
<%for (Music music : musics.getInstances()) {%>
  <%if (music.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
    <td><%=music.getId() %></td>
	<td><%=music.getName() %></td>
	<td><%=music.getRating() %></td>
	<td>
		<a href="AdminWorks?table=music_users&action=details&id=<%=music.getId()%>" title="details on the item"><button><%=l.tr("detailsButton")%></button></a>
	</td>
  </tr>
<%} %>
</table>
<hr><a href="AdminWorks"><button><%=l.tr("backwardButton")%></button></a>
</body>
</html>