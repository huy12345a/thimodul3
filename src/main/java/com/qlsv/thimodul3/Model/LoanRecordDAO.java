package com.qlsv.thimodul3.Model;
import java.sql.*;

public class LoanRecordDAO {
    private Connection getConnection() throws SQLException {
        // Thay đổi thông tin kết nối tùy theo cấu hình của bạn
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String password = "012345";
        return DriverManager.getConnection(url, user, password);
    }

    public void addLoanRecord(LoanRecord loanRecord) {
        String sql = "INSERT INTO LoanRecords (loan_id, book_id, student_id, status, loan_date, return_date) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, loanRecord.getLoanId());
            stmt.setInt(2, loanRecord.getBookId());
            stmt.setInt(3, loanRecord.getStudentId());
            stmt.setBoolean(4, loanRecord.isStatus());
            stmt.setDate(5, loanRecord.getLoanDate());
            stmt.setDate(6, loanRecord.getReturnDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

