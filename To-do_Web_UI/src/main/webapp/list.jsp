<%@ page import="entity.Item" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: derec
  Date: 6/29/2025
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To-Do List</title>
</head>
<body>
<%
    List<Item> todos = (List<Item>) request.getAttribute("todos");
%>
<h2>To-Do List</h2>
<ul>
    <% for (Item item : todos) { %>
    <li>
        <%= item.getText() %>
        <a href="delete?id=<%= item.getId() %>">Delete</a>
    </li>
    <% } %>
</ul>
<a href="add.jsp">Add New</a>
</body>
</html>
