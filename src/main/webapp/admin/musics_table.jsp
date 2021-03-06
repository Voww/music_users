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
    <th><%=l.tr("idHeader")%></th>
    <th><%=l.tr("nameHeader")%></th>
    <th><%=l.tr("ratingHeader")%></th>
    <th><%=l.tr("actionHeader")%></th>
  </tr>
<%String action = request.getParameter("action"); action = action == null ? "" : action;%>
<%Long id = 5L; %>
<%try { %><%id = Long.parseLong(request.getParameter("id"));%> <%} catch (NumberFormatException e) { %><%} %>
  
<%for (Music music : musics.getInstances()) {%>
  <%if (music.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>


  <%if (action.matches("edit") && music.getId() == id) { %>
<form action="AdminWorks" method="post" name="action">
		<td><%=music.getId() %>
            <input type="hidden" title="table" name="table" value="music">
            <input type="hidden"  title="id" name="id" value="<%=music.getId() %>"></td>
		<td><label><input type="text" name="name" value="<%=music.getName() %>"></label></td>
		<td><label><input type="text" name="rating" readonly value="<%=music.getRating() %>"></label></td>
		<td><input type="submit" title="update changes" name="action" value="update">
		<input type="submit" title="revert changes" name="action" value="cancel"></td>
</form>
  
  <%} else { %>
    <td><%=music.getId() %></td>
	<td><%=music.getName() %></td>
	<td><%=music.getRating() %></td>
	<td>
		<a href="AdminWorks?table=music_users&action=details&id=<%=music.getId()%>" title="details on the item"><button><%=l.tr("detailsButton")%></button></a>
		<a href="AdminWorks?table=music&action=edit&id=<%=music.getId()%>" title="edit the item"><button><%=l.tr("editButton")%></button></a>
		<a href="AdminWorks?table=music&action=delete&id=<%=music.getId()%>" title="delete the item"><button><%=l.tr("deleteButton")%></button></a>
	</td>

<%} %>
  </tr>
<%} %>
	<tr>
	<form action="AdminWorks" method="post" name="action">
		<td><input type="hidden" title="table" name="table" value="music"></td>
		<td><label>Name:<input type="text" name="name" value="name"></label></td>
		<td><label>Rating:<input type="text" name="rating" readonly value="0"></label></td>
		<td><input type="submit" title="insert a new item" name="action" value="insert"></td>
	</form>
	</tr>
</table>
<hr><a href="AdminWorks"><button><%=l.tr("backwardButton")%></button></a>
</body>
</html>