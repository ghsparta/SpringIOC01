package com.pojo;

import lombok.Getter;


@Getter
public class Author {
    int id;
    String username, password, email, bio, favouriteSection;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", bio='" + bio + '\'' +
                ", favouriteSection='" + favouriteSection + '\'' +
                '}';
    }
}
