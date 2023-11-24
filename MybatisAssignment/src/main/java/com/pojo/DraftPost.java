package com.pojo;


public class DraftPost extends Post{
    @Override
    public String toString() {
        return "DraftPost{" +
                "id=" + id +
                ", type=DraftPost" +
                ", created_on='" + created_on + '\'' +
                ", section='" + section + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", comments=" + comments +
                ", tags=" + tags +
                '}';
    }
}
