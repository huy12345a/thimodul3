package com.qlsv.thimodul3.Model;

import java.sql.Date;

public class LoanRecord {
    private String loanId;
    private int bookId;
    private int studentId;
    private boolean status;
    private Date loanDate;
    private Date returnDate;

    public LoanRecord(int bookId, Date loanDate, String loanId, Date returnDate, boolean status, int studentId) {
        this.bookId = bookId;
        this.loanDate = loanDate;
        this.loanId = loanId;
        this.returnDate = returnDate;
        this.status = status;
        this.studentId = studentId;
    }

    public LoanRecord() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
}
