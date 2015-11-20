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
<% Addresses addresses = (Addresses)request.getSession().getAttribute("addresses"); %>

<table frame="border" border="1">
  <tr bgcolor="magenta">
    <th><%=l.tr("idHeader")%></th><th><%=l.tr("postcodeHeader")%></th><th><%=l.tr("cityHeader")%></th><th><%=l.tr("streetHeader")%></th><th><%=l.tr("houseHeader")%></th><th><%=l.tr("flatHeader")%></th><th><%=l.tr("actionHeader")%></th>
  </tr>
<%for (Address address : addresses.getInstances()) {%>
  <%if (address.getId() % 2 == 0) {%><tr bgcolor="yellow"><%} else {%><tr bgcolor="cyan"><%} %>
    <td><%=address.getId() %></td>
	<td><%=address.getPostcode() %></td>
	<td><%=address.getCity() %></td>
	<td><%=address.getStreet() %></td>
	<td><%=address.getHouse() %></td>
	<td><%=address.getFlat() %></td>
	<td>
		<a href="AdminWorks?table=address_user&id=<%=address.getId()%>" title="details on the item"><button><%=l.tr("detailsButton")%></button></a>
	</td>
  </tr>
<%} %>
</table>
<hr><a href="AdminWorks"><button><%=l.tr("backwardButton")%></button></a>
</body>
</html>