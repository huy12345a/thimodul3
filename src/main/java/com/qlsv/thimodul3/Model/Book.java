package com.qlsv.thimodul3.Model;

public class Book {
    private int id;
    private String title;
    private String author;
    private String description;
    private int quantity;

    public Book(int id, String title, String author, String description, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.quantity = quantity;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
