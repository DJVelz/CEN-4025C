<%@ page import="java.util.List" %>
<%@ page import="entity.Item" %>
<%
    List<Item> items = (List<Item>) request.getAttribute("items");
%>
<html>
<head><title>To-Do List</title></head>
<body>
<h2>My To-Do List</h2>
<ul>
    <% if (items != null) {
        for (Item item : items) { %>
    <li>
        <%= item.getDescription() %>
        <a href="delete?id=<%= item.getId() %>">[Delete]</a>
    </li>
    <%  }} %>
</ul>
<a href="add.jsp">Add New Item</a>
</body>
</html>
