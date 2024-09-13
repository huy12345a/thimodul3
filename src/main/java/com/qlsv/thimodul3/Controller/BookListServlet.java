package com.qlsv.thimodul3.Controller;

import com.qlsv.thimodul3.Model.Book;
import com.qlsv.thimodul3.Model.BookDAO;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/BookListServlet")
public class BookListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDAO bookDAO = new BookDAO();
        List<Book> books = bookDAO.getAllBooks();
        System.out.println(books);
        request.setAttribute("books", books);
        request.getRequestDispatcher("bookList.jsp").forward(request, response);
    }
}


