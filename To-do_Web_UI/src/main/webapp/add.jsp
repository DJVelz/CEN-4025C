<%--
  Created by IntelliJ IDEA.
  User: derec
  Date: 6/29/2025
  Time: 5:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add an item</title>
</head>
<body>
  <h2>Add To-Do</h2>
  <form action="add" method="post">
    <input type="text" name="text" required />
    <input type="submit" value="Add" />
</form>
</body>
</html>
