<%@ page import="zaietsv.complextask.mvc.localization.Localization" %>
<%@ page import="zaietsv.complextask.mvc.localization.MusicUsersLocalization" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <% Localization l = MusicUsersLocalization.getInstance(request); %>
<title>User's page</title>
</head>
<body>
<h1 style="background-color: yellow">Access denied page</h1>
Your have not permission to view authorized pages.<br>
You can visit <a href="AdminWorks">guest page</a>
</body>
</html>