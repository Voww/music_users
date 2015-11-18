<%@ page import="zaietsv.complextask.mvc.localization.Localization" %>
<%@ page import="zaietsv.complextask.mvc.localization.MusicUsersLocalization" %>
<%--
  Created by IntelliJ IDEA.
  User: Voww
  Date: 16.11.2015
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <% Localization l = MusicUsersLocalization.getInstance(request); %>
    <title><%=l.tr("langSelect") %></title>
</head>
<body>
<form method="get" action="AdminWorks" onchange="submit();">
    <select name="langID">
        <option value="ua" <%if (l.getLanguageId().equals("ua")) { %>selected<% } %>><%=l.tr("ukrainian") %></option>
        <option value="fr"<%if (l.getLanguageId().equals("fr")) { %>selected<% } %>><%=l.tr("french") %></option>
      <option value="en" <%if (l.getLanguageId().equals("en")) { %>selected<% } %>><%=l.tr("english") %></option>
      <option value="ru" <%if (l.getLanguageId().equals("ru")) { %>selected<% } %>><%=l.tr("russian") %></option>
    </select>
</form>
</body>
</html>
