<%@page import="zaietsv.complextask.mvc.entity.instance.Address"%>
<%@page import="zaietsv.complextask.mvc.entity.instance.Addresses"%>
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
<title><%=l.tr("addressTable")%></title>
</head>
<body>
<h1 style="background-color: springgreen"><%=l.tr("addressTable")%></h1>
<a href="AdminWorks"><button><%=l.tr("backwardButton")%></button></a><hr>
last action = <%=request.getParameter("action") %>
<% Addresses addresses = (Addresses)request.getSession().getAttribute("addresses"); %>

<table frame="border" border="1">
  <tr bgcolor="magenta">
    <th><%=l.tr("idHeader")%></th><th><%=l.tr("postcodeHeader")%></th><th><%=l.tr("cityHeader")%></th><th><%=l.tr("streetHeader")%></th><th><%=l.tr("houseHeader")%></th><th><%=l.tr("flatHeader")%></th><th><%=l.tr("actionHeader")%></th>
  </tr>
<%String action = request.getParameter("action"); action = action == null ? "" : action;%>
<%Long id = 0L; %>
<%try { %><%id = Long.parseLong(request.getParameter("id"));%> <%} catch (NumberFormatException e) { %><%} %>
  
<%for (Address address : addresses.getInstances()) {%>
  <%if (address.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>


  <%if (action.matches("edit") && address.getId() == id) { %>
<form action="AdminWorks" method="post" name="action">
		<td><%=address.getId() %>
			<input type="hidden" title="table" name="table" value="address">
            <input type="hidden"  title="id" name="id" value="<%=address.getId()%>"></td>
		<td><input type="text" name="postcode" value="<%=address.getPostcode()%>" title="edit postcode"></td>
		<td><input type="text" name="city" value="<%=address.getCity()%>" title="edit city"></td>
		<td><input type="text" name="street" value="<%=address.getStreet()%>" title="edit address"></td>
	<td><input type="text" name="house" value="<%=address.getHouse()%>" title="edit street"></td>
	<td><input type="text" name="flat" value="<%=address.getFlat()%>" title="edit flat"></td>
		<td><input type="submit" title="update changes" name="action" value="update">
		<input type="submit" title="revert changes" name="action" value="cancel"></td>
</form>
  
  <%} else { %>
    <td><%=address.getId() %></td>
	<td><%=address.getPostcode() %></td>
	<td><%=address.getCity() %></td>
	<td><%=address.getStreet() %></td>
	<td><%=address.getHouse() %></td>
	<td><%=address.getFlat() %></td>
	<td>
		<a href="AdminWorks?table=address_user&id=<%=address.getId()%>" title="details on the item"><button><%=l.tr("detailsButton")%></button></a>
		<a href="AdminWorks?table=address&action=edit&id=<%=address.getId()%>" title="edit the item"><button><%=l.tr("editButton")%></button></a>
		<a href="AdminWorks?table=address&action=delete&id=<%=address.getId()%>" title="delete the item"><button><%=l.tr("deleteButton")%></button></a>
	</td>

<%} %>
  </tr>
<%} %>
	<tr>
	<form action="AdminWorks" method="post" name="action">
		<td><input type="hidden" title="table" name="table" value="address"></td>
		<td><label>Postcode:<input type="text" name="postcode" value="000000"></label></td>
		<td><label>City:<input type="text" name="city" value="city"></label></td>
		<td><label>Street:<input type="text" name="street" value="street"></label></td>
		<td><label>House:<input type="text" name="house" value="0"></label></td>
		<td><label>Flat:<input type="text" name="flat" value="000"></label></td>
		<td><input type="submit" title="insert a new item" name="action" value="insert"></td>
	</form>
	</tr>
</table>
<hr><a href="AdminWorks"><button><%=l.tr("backwardButton")%></button></a>
</body>
</html>