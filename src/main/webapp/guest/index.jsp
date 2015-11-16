<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Guest's page</title>
</head>
<body>

<div>
    <div style="float: left; width: 95%">
        <h1 style="background-color: greenyellow">Guest's page</h1>
    </div>
    <div style="float: left; width: 5%;">
        <h1></h1>
        <a href="/music_users/login.jsp">Log in</a><br>
        <jsp:include page="/Languages.jsp"></jsp:include>
    </div>
</div>
<div style="width: 100%; clear: both"><hr></div>
Common information for non-authorized users.<br>
You can perform an authorization at <a href="/music_users/login.jsp">login page</a><br>
<a href="AdminWorks?table=music"><button>Music table</button></a>
</body>
</html>