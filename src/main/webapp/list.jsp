<%@ page import="fawry.servlettask.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List of Products</title>
    <style>
        body {
            font-family: sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            margin: 0;
        }

        h1 {
            text-align: center;
        }

        table {
            width: 500px;
            margin: 20px auto;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
        }

        th {
            background-color: #000;
            color: #fff;
        }

        td:last-child {
            text-align: center;
        }

        input[type=submit] {
            width: 80px;
            padding: 5px;
            background-color: #f00;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #c00;
        }

        a {
            width: 100px;
            padding: 10px;
            display: block;
            background-color: #000;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
            text-decoration: none;
            text-align: center;
        }

        a:hover {
            background-color: #333;
        }
    </style>
</head>
<body>

<h1>List of Products</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <%
        for(Product product : (List<Product>) request.getAttribute("products")) {
    %>
    <tr>
        <td><%= product.getId() %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %></td>
        <td>
            <form action="${pageContext.request.contextPath}/product-servlet" method="post">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" value="<%= product.getId() %>">
                <input type="submit" value="Delete">
            </form>
        </td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<br>
<a href="${pageContext.request.contextPath}/addForm.html">Add Product</a>
</body>
</html>
