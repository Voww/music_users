<%@page import="zaietsv.complextask.mvc.entity.instance_detail.AddressUser"%>
<%@ page import="zaietsv.complextask.mvc.localization.Localization" %>
<%@ page import="zaietsv.complextask.mvc.localization.MusicUsersLocalization" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
	<meta http-equiv="cache-control" content="no-cache, no-store, must-revalidate">
	<% Localization l = MusicUsersLocalization.getInstance(request); %>
<title><%=l.tr("addressUserTable")%></title>
</head>
<body>
<h1><%=l.tr("addressUserTable")%></h1>
<a href="AdminWorks?table=address"><button><%=l.tr("backwardButton")%></button></a><hr>
last action = <%=request.getParameter("action") %>
<h2><%=l.tr("addressHeader")%></h2>
<% AddressUser addressUser = (AddressUser)request.getSession().getAttribute("addressUser"); %>

<table frame="border" border="1">
	<tr bgcolor="magenta"><th><%=l.tr("idHeader")%></th><th><%=l.tr("postcodeHeader")%></th><th><%=l.tr("cityHeader")%></th><th><%=l.tr("streetHeader")%></th><th><%=l.tr("houseHeader")%></th><th><%=l.tr("flatHeader")%></th></tr>
	<%if (addressUser.getInstance().getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
	<td><%=addressUser.getInstance().getId() %></td>
	<td><%=addressUser.getInstance().getPostcode() %></td>
	<td><%=addressUser.getInstance().getCity() %></td>
	<td><%=addressUser.getInstance().getStreet() %></td>
	<td><%=addressUser.getInstance().getHouse() %></td>
	<td><%=addressUser.getInstance().getFlat() %></td>
</tr>
</table>

<h2><%=l.tr("userHeader")%></h2>
<table frame="border" border="1">
	<tr bgcolor="magenta">
		<th><%=l.tr("idHeader")%></th>
		<th><%=l.tr("loginHeader")%></th>
		<th><%=l.tr("passwordHeader")%></th>
		<th><%=l.tr("emailHeader")%></th>
		<th><%=l.tr("regDateHeader")%></th>
		<th><%=l.tr("actionHeader")%></th>
	</tr>
	<%if (addressUser.getDetail() == null) {%>
	<tr><td colspan="6" align="center">Empty list</td></tr>
	<%} else {%>
	<%if (addressUser.getDetail().getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%>
	<tr bgcolor="cyan"><%} %>
		<td><%=addressUser.getDetail().getId() %></td>
		<td><%=addressUser.getDetail().getLogin() %></td>
		<td><%=addressUser.getDetail().getPassword() %></td>
		<td><%=addressUser.getDetail().getEmail() %></td>
		<td><%=addressUser.getDetail().getReg_date() %></td>
		<td>
			<a href="AdminWorks?table=user_address_role_musics&action=details&id=<%=addressUser.getDetail().getId()%>" title="details on the item"><button><%=l.tr("detailsButton")%></button></a>
		</td>
	</tr><%} %>
</table>
<hr><a href="AdminWorks?table=address"><button><%=l.tr("backwardButton")%></button></a>
</body>
</html>