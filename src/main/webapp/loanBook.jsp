<%@ page import="java.util.*, com.qlsv.thimodul3.Model.StudentDAO, com.qlsv.thimodul3.Model.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mượn Sách</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Mượn Sách</h2>
    <form action="LoanBookServlet" method="post">
        <div class="form-group">
            <label for="loanId">Mã Mượn Sách</label>
            <input type="text" class="form-control" id="loanId" name="loanId" required

            >
        </div>
        <div class="form-group">
            <label for="bookTitle">Tên Sách</label>
            <input type="text" class="form-control" id="bookTitle" name="bookTitle"
                   value="${book.title}"
                   readonly>
        </div>
        <div class="form-group">
            <label for="studentId">Tên Học Sinh</label>
            <select class="form-control" id="studentId" name="studentId">
                <%
                    StudentDAO studentDAO = new StudentDAO();
                    List<Student> students = studentDAO.getAllStudents();
                    for (Student student : students) {
                %>
                <option value="<%= student.getId() %>"><%= student.getFullName() %></option>
                <% } %>
            </select>
        </div>
        <div class="form-group">
            <label for="loanDate">Ngày Mượn</label>
            <input type="text" class="form-control" id="loanDate" name="loanDate" value="<%= new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()) %>" readonly>
        </div>
        <div class="form-group">
            <label for="returnDate">Ngày Trả</label>
            <input type="text" class="form-control" id="returnDate" name="returnDate" required>
        </div>
        <button type="submit" class="btn btn-primary">Mượn Sách</button>
        <a href="bookList.jsp" class="btn btn-secondary" onclick="return confirm('Bạn có chắc chắn muốn trở về danh sách?')">Trở Về Danh Sách</a>
    </form>
</div>
</body>
</html>
