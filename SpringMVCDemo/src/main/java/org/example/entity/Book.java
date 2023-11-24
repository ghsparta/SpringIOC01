package org.example.entity;

public class Book {
    int id;
    String title;
    String[] authors;
    String description;
    String status;
    String[] tags;

    public Book(int id, String title, String[] authors, String description, String status, String[] tags) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.description = description;
        this.status = status;
        this.tags = tags;
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

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }
}
