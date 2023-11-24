package com.pojo;


public class RegularPost extends Post{
    @Override
    public String toString() {
        return "RegularPost{" +
                "id=" + id +
                ", type=RegularPost" +
                ", created_on='" + created_on + '\'' +
                ", section='" + section + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", comments=" + comments +
                ", tags=" + tags +
                '}';
    }
}
