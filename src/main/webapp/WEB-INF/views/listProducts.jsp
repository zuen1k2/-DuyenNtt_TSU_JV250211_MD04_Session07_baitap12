<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Danh sach san pham</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        a {
            text-decoration: none;
            color: #007bff;
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
            border: 1px solid #ddd;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .action-links {
            display: flex;
            gap: 10px;
        }
    </style>
</head>
<body>
<h1>Danh sách sản phẩm</h1>
<a href="${pageContext.request.contextPath}/products/add">Thêm mới sản phẩm</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Mô tả</th>
        <th>Giá</th>
        <th>Danh mục ID</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
            <td>${product.categoryId}</td>
            <td class="action-links">
                <a href="${pageContext.request.contextPath}/products/edit/${product.productId}">Sửa</a>
                <a href="${pageContext.request.contextPath}/products/delete/${product.productId}" onclick="return confirm('Bạn có chắc chắn muốn xóa?');">Xóa</a>
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
