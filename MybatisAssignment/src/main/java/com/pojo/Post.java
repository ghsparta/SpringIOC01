package com.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
public class Post {
    int id, blog_id, draft;
    String created_on, section, subject, body;
    Author author;
    List<Comment> comments;
    List<Tag> tags;

    public Post() {
        this.comments = new ArrayList<>();
        this.tags = new ArrayList<>();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
