<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nguyenthithuyduyen
  Date: 18/8/25
  Time: 22:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> List Categories</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        h1 {
            color: #333;
        }
        a {
            text-decoration: none;
            color: #007BFF;
            margin: 0 10px;
        }
        a:hover {
            text-decoration: underline;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            background: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #007BFF;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .action-links {
            display: flex;
            justify-content: space-around;
        }
    </style>
</head>
<body>
<h1> Danh sách danh mục</h1>
<a href="${pageContext.request.contextPath}/categories/add">Thêm mới danh mục</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên danh mục</th>
        <th>Mô tả</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.id}</td>
            <td>${category.cateName}</td>
            <td>${category.description}</td>
            <td>${category.status}</td>
            <td class="action-links">
                <a href="/categories/edit/${category.id}">Sửa</a>
                <a href="/categories/delete/${category.id}" onclick="return confirm('Bạn có chắc chắn muốn xóa?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${not empty message}">
    <script>
        alert("${message}")
    </script>
</c:if>
</body>
</html>
