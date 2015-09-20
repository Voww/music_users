<%@page import="zaietsv.complextask.mvc.holder.MusicHolder"%>
<%@page import="zaietsv.complextask.mvc.instance.Music"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Music table</title>
</head>
<body>
<h1>Music table</h1>
last action = <%=request.getParameter("action") %>
<% MusicHolder musicHolder = (MusicHolder)request.getSession().getAttribute("musicHolder"); %>

<table frame="border" border="1">
  <tr bgcolor="magenta">
    <th>Id</th>
    <th>Name</th>
    <th>Rating</th>
    <th>Action</th>
  </tr>
<%String action = request.getParameter("action"); action = action == null ? "" : action;%>
<%Long id = 5L; %>
<%try { %><%id = Long.parseLong(request.getParameter("id"));%> <%} catch (NumberFormatException e) { %><%} %>
  
<%for (Music music : musicHolder.getList()) {%>
  <%if (music.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>


  <%if (action.matches("edit") && music.getId() == id) { %>
<form action="AdminServlet" method="post" name="action">
		<td><%=music.getId() %>
            <input type="hidden" title="table" name="table" value="music">
            <input type="hidden"  title="id" name="id" value="<%=music.getId() %>"></td>
		<td><label><input type="text" name="name" value="<%=music.getName() %>"></label></td>
		<td><label><input type="text" name="rating" value="<%=music.getRating() %>"></label></td>
		<td><input type="submit" title="update changes" name="action" value="update">
		<input type="submit" title="revert changes" name="action" value="cancel"></td>
</form>
  
  <%} else { %>
    <td><%=music.getId() %></td>
	<td><%=music.getName() %></td>
	<td><%=music.getRating() %></td>
	<td>
		<form action="AdminServlet" method="get" name="action_<%=music.getId() %>">
            <input type="hidden" title="table" name="table" value="music">
            <input type="hidden" title="id" name="id" value="<%=music.getId() %>">
			<input type="submit" title="details of an item" name="action" value="details">
			<input type="submit" title="edit an existing item" name="action" value="edit">
			<input type="submit" title="delete an item" name="action" value="delete">
		</form>
	</td>

<%} %>
  </tr>
<%} %>
	<tr>
	<form action="AdminServlet" method="post" name="action">
		<td><input type="hidden" title="table" name="table" value="music"></td>
		<td><label>
			Name:
			<input type="text" name="name" value="name">
		</label></td>
		<td><label>
			Rating:
			<input type="text" name="rating" value="0">
		</label></td>
		<td><input type="submit" title="insert a new item" name="action" value="insert"></td>
	</form>
	</tr>
</table>
<hr>
</body>
</html>