<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Mandator's page</title>
</head>
<body>
<h1 style="background-color: blueviolet">Mandator's page</h1>
Special information for authorized mandators.<br>
<jsp:include page="/Logout.html"></jsp:include><br>
<a href="AdminWorks?table=user"><button>User table</button></a>
<a href="AdminWorks?table=role"><button>Role table</button></a>
<a href="AdminWorks?table=address"><button>Address table</button></a>
<a href="AdminWorks?table=music"><button>Music table</button></a>
</body>
</html>