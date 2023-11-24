package mapper;

import com.mapper.BlogMapper;
import com.pojo.Blog;
import com.pojo.Comment;
import com.pojo.Post;
import com.pojo.Tag;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BlogMapperTest {
    String resource = "mybatis-config.xml";
    SqlSessionFactory sqlSessionFactory = null;
    {
        try(InputStream inputStream = Resources.getResourceAsStream(resource)){
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void selectBlogWithDetail(){
        try (SqlSession session = sqlSessionFactory.openSession()) {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlogDetails(1);
            System.out.println(blog);
        }
    }
    @Test
    public void selectBlogLazy() {
        try (SqlSession session = sqlSessionFactory.openSession()){
            BlogMapper mapper = session.getMapper(BlogMapper.class);
//            Blog blog = mapper.selectBlogDetails(1);
            Blog blog = mapper.selectBlogById(1);
            System.out.println("----------------------------------------------------延迟加载Author-----------------------------------------------");
            System.out.println(blog.getAuthor());
            System.out.println("----------------------------------------------------延迟加载Post-------------------------------------------------");
            List<Post> posts = blog.getPosts();
            for (Post post : posts) {
                System.out.println("============="+post.getBody()+"==============================");
                System.out.println("----------------------------------------------------延迟加载Comment-------------------------------------------------");
                List<Comment> comments = post.getComments();
                for (Comment comment : comments) {
                    System.out.println(comment);
                }
                System.out.println("----------------------------------------------------延迟加载Tag-------------------------------------------------");
                List<Tag> tags = post.getTags();
                for (Tag tag : tags) {
                    System.out.println(tag);
                }
                System.out.println("===================================");
                System.out.println();
            }
//            System.out.println("----------------------------------------------------打印Blog-------------------------------------------------");
//            System.out.println(blog);
        }
    }






}