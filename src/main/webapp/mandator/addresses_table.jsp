<%@page import="zaietsv.complextask.mvc.entity.instance.Address"%>
<%@page import="zaietsv.complextask.mvc.entity.instance.Addresses"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
	<meta http-equiv="cache-control" content="no-cache, no-store, must-revalidate">
<title>Address table</title>
</head>
<body>
<h1 style="background-color: springgreen">Address table</h1>
<a href="MandatorWorks"><button>Backward</button></a><hr>
<% Addresses addresses = (Addresses)request.getSession().getAttribute("addresses"); %>

<table frame="border" border="1">
  <tr bgcolor="magenta">
    <th>Id</th><th>Postcode</th><th>City</th><th>Street</th><th>House</th><th>Flat</th><th>Action</th>
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
		<a href="MandatorWorks?table=address_user&id=<%=address.getId()%>" title="details on the item"><button>details</button></a>
	</td>
  </tr>
<%} %>
</table>
<hr><a href="MandatorWorks"><button>Backward</button></a>
</body>
</html>