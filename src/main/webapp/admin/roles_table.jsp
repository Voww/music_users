<%@page import="zaietsv.complextask.mvc.entity.instance.Role"%>
<%@ page import="zaietsv.complextask.mvc.entity.instance.Roles" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="cache-control" content="no-cache, no-store, must-revalidate">
<title>Role table</title>
</head>
<body>
<h1 style="background-color: blueviolet">Role table</h1>
<a href="AdminWorks"><button>Backward</button></a><hr>
last action = <%=request.getParameter("action") %>
<% Roles roles = (Roles)request.getSession().getAttribute("roles"); %>

<table frame="border" border="1">
  <tr bgcolor="magenta">
    <th>Id</th>
    <th>Name</th>
    <th>Action</th>
  </tr>
<%String action = request.getParameter("action"); action = action == null ? "" : action;%>
<%Long id = 5L; %>
<%try { %><%id = Long.parseLong(request.getParameter("id"));%> <%} catch (NumberFormatException e) { %><%} %>
  
<%for (Role role : roles.getInstances()) {%>
  <%if (role.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>


  <%if (action.matches("edit") && role.getId() == id) { %>
<form action="AdminWorks" method="post" name="action">
		<td><%=role.getId() %>
            <input type="hidden" title="table" name="table" value="role">
            <input type="hidden"  title="id" name="id" value="<%=role.getId() %>"></td>
		<td><input type="text" name="name" value="<%=role.getName() %>" title="edit name"></td>
		<td><input type="submit" title="update changes" name="action" value="update">
		<input type="submit" title="revert changes" name="action" value="cancel"></td>
</form>
  
  <%} else { %>
    <td><%=role.getId() %></td>
	<td><%=role.getName() %></td>
	<td>
		<a href="AdminWorks?table=role_users&action=details&id=<%=role.getId()%>" title="details on the item"><button>details</button></a>
		<a href="AdminWorks?table=role&action=edit&id=<%=role.getId()%>" title="edit the item"><button>edit</button></a>
		<a href="AdminWorks?table=role&action=delete&id=<%=role.getId()%>" title="delete the item"><button>delete</button></a>
	</td>

<%} %>
  </tr>
<%} %>
	<tr>
	<form action="AdminWorks" method="post" name="action">
		<td><input type="hidden" title="table" name="table" value="role"></td>
		<td><label>Name:<input type="text" name="name" value="name"></label></td>
		<td><input type="submit" title="insert a new item" name="action" value="insert"></td>
	</form>
	</tr>
</table>
<hr><a href="AdminWorks"><button>Backward</button></a>
</body>
</html>