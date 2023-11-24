package com.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Blog {
    int id;
    String title;
    Author author;
    State state;
    List<Post> posts;

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Blog(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder postDetails = new StringBuilder();
        for (int i = 0; i < posts.size(); i++) {
            postDetails.append(posts.get(i).toString() + ",\n");
        }
        return "Blog{" +
                "id=" + id +
                ",\ntitle='" + title + '\'' +
                ",\nauthor=" + author +
                ",\nposts={" + postDetails.toString() +
                "state=" + state +
                '}';
    }
}
