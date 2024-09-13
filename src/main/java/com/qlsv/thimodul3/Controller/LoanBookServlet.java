package com.qlsv.thimodul3.Controller;

import com.qlsv.thimodul3.Model.Book;
import com.qlsv.thimodul3.Model.BookDAO;
import com.qlsv.thimodul3.Model.LoanRecord;
import com.qlsv.thimodul3.Model.LoanRecordDAO;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoanBookServlet")
public class LoanBookServlet extends HttpServlet {
    BookDAO bookDAO = new BookDAO();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loanId = request.getParameter("loanId");
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        Date loanDate = Date.valueOf(request.getParameter("loanDate"));
        Date returnDate = Date.valueOf(request.getParameter("returnDate"));

        if (loanId == null || loanId.isEmpty() || !loanId.matches("MS-\\d{4}")) {
            request.setAttribute("error", "Mã mượn sách không hợp lệ.");
            request.getRequestDispatcher("loanBook.jsp").forward(request, response);
            return;
        }

        LoanRecord loanRecord = new LoanRecord();
        loanRecord.setLoanId(loanId);
        loanRecord.setBookId(bookId);
        loanRecord.setStudentId(studentId);
        loanRecord.setStatus(false); // Đang mượn
        loanRecord.setLoanDate(loanDate);
        loanRecord.setReturnDate(returnDate);

        LoanRecordDAO loanRecordDAO = new LoanRecordDAO();
        BookDAO bookDAO = new BookDAO();

        if (bookDAO.getBookQuantity(bookId) <= 0) {
            request.setAttribute("error", "Số lượng sách không đủ.");
            request.getRequestDispatcher("loanBook.jsp").forward(request, response);
            return;
        }

        loanRecordDAO.addLoanRecord(loanRecord);
        bookDAO.updateBookQuantity(bookId, bookDAO.getBookQuantity(bookId) - 1);

        response.sendRedirect("BookListServlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String bookId = req.getParameter("bookId");
            Book book = bookDAO.getBookById(bookId);
            System.out.println(book);
            req.setAttribute("book", book);
            req.getRequestDispatcher("loanBook.jsp").forward(req, resp);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

