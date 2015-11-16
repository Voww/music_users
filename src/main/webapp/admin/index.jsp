<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Administrator's page</title>
</head>
<body>
<div>
    <div style="float: left; width: 95%">
        <h1 style="background-color: fuchsia;">Administrator's page</h1>
    </div>
    <div style="float: left; width: 5%;">
        <h1></h1>
        <jsp:include page="/Logout.html"></jsp:include><br>
        <jsp:include page="/Languages.jsp"></jsp:include>
    </div>
</div>
    <div style="width: 100%; clear: both"><hr></div>
    <div>
        Common information for authorized administrators.<br>
        <a href="AdminWorks?table=user"><button>User table</button></a>
        <a href="AdminWorks?table=role"><button>Role table</button></a>
        <a href="AdminWorks?table=address"><button>Address table</button></a>
        <a href="AdminWorks?table=music"><button>Music table</button></a>
    </div>
</body>
</html>