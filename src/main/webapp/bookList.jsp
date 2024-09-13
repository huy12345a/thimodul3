<%@ page import="java.util.*, com.qlsv.thimodul3.Model.BookDAO, com.qlsv.thimodul3.Model.Book" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Danh Sách Sách</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Danh sach sach</h2>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>tieu de</th>
            <th>tac gia</th>
            <th>so luong</th>
            <th>thao tac</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td><c:out value="${book.id}"/></td>
                <td><c:out value="${book.title}"/></td>

                <td><c:out value="${book.author}"/></td>
                <td><c:out value="${book.description}"/></td>
                <td><c:out value="${book.quantity}"/></td>
                <td>
                    <a href="LoanBookServlet?bookId=${book.id}" class="btn btn-primary">Mượn</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
