<%@ page import="zaietsv.complextask.mvc.localization.Localization" %>
<%@ page import="zaietsv.complextask.mvc.localization.MusicUsersLocalization" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <% Localization l = MusicUsersLocalization.getInstance(request); %>
<title>Music Users login page</title>
</head>
<body>

<div>
    <div style="float: left; width: 95%">
        <h1 style="background-color: lightgrey">Music Users login page</h1>
    </div>
    <div style="float: left; width: 5%;">
        <h1></h1>
        <a href="guest/index.jsp">Guest</a><br>
        <jsp:include page="/Languages.jsp"></jsp:include>
    </div>
</div>
    <form action="AuthorizationService?action=login" name="pleaseLogin" method="post">
    <table frame="box">
        <thead>
        <tr>
            <td colspan="2" align="center" bgcolor="#ff1493">Authorization</td>
            <td align="center" bgcolor="#00bfff">Registration</td>
        </tr>
        </thead>
        <tbody style="background-color: hotpink">
            <tr>
                <td><b>Login:</b></td><td><input type="text" name="login" title="Please login here!"></td>
                <td rowspan="2" style="background-color: aquamarine" title="Please register here!"><b>Register and enjoy many benefits</b></td>
            </tr>
            <tr><td><b>Password:</b></td><td><input type="password" name="password"></td></tr>
        </tbody>
        <tfoot>
            <tr><td colspan="2" align="right" bgcolor="#ff1493"><input type="submit" value="Login"><input type="reset" value="Reset"></td>
                <td align="right" bgcolor="#00bfff"><a href="/RegService"><button>Register</button></a></td>
            </tr>
        </tfoot>
    </table>
    </form>
</body>
</html>