<%@page import="zaietsv.complextask.mvc.entity.instance.Music"%>
<%@page import="zaietsv.complextask.mvc.entity.instance.Musics"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="cache-control" content="no-cache, no-store, must-revalidate">
<title>Music table</title>
</head>
<body>
<h1 style="background-color: blue">Music table</h1>
<a href="GuestWorks"><button>Backward</button></a><hr>
<% Musics musics = (Musics)request.getSession().getAttribute("musics"); %>

<table frame="border" border="1">
  <tr bgcolor="magenta">
    <th>Id</th><th>Name</th><th>Rating</th>
  </tr>
	<%for (Music music : musics.getInstances()) {%>
  		<%if (music.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
    		<td><%=music.getId() %></td>
			<td><%=music.getName() %></td>
			<td><%=music.getRating() %></td>
  		</tr>
	<%} %>
</table>
<hr><a href="GuestWorks"><button>Backward</button></a>
</body>
</html>