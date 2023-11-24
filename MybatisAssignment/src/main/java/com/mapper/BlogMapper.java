package com.mapper;

import com.pojo.Blog;

public interface BlogMapper {

    Blog selectBlogById(int id);
    Blog selectBlogDetails(int id);


}
