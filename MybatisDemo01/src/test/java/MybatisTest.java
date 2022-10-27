import com.demo.PersonMapper;
import com.demo.domain.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void testSelectPerson()  {
        //try-with-resource
        try (SqlSession session = sqlSessionFactory.openSession()) {
            Person p =  session.selectOne("com.demo.PersonMapper.selectPerson", 2);
            System.out.println(p);
        }
    }

    @Test
    public void testSelectPersonWithInterface()  {
        //try-with-resource
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
//            System.out.println(mapper.getClass().getName());
            Person person = mapper.selectPerson(1);
            System.out.println(person);
        }
    }

    @Test
    public void testSelectPersonWithDetails()  {
        //try-with-resource
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
//            System.out.println(mapper.getClass().getName());
            Person person = mapper.selectPersonByIdWithDetails(1);
            System.out.println(person);
        }
    }

    @Test
    public void testSelectPersonByIdAndName()  {
        //try-with-resource
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
            Person person = mapper.selectPersonByIdAndName(2,"bbb");
            System.out.println(person);
        }
    }

    @Test
    public void testSelectPersonByInstance()  {
        //try-with-resource
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
            Person person1 = new Person(2);
            Person person = mapper.selectPersonByInstance(person1);
            System.out.println(person);
        }
    }

    @Test
    public void testSelectPersonByMap()  {
        //try-with-resource
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
            Map<String, Object> map = new HashMap<>();
            map.put("id",2);
            map.put("name","bbb");
            Person person = mapper.selectPersonByMap(map);
            System.out.println(person);
        }
    }

    @Test
    public void testSelectPersonByList()  {
        //try-with-resource
        try (SqlSession session = sqlSessionFactory.openSession()) {
            PersonMapper mapper = session.getMapper(PersonMapper.class);
            List list1 = new ArrayList<>();
            list1.add(2);
            list1.add("bbb");
            Person person = mapper.selectPersonByList(list1);
            System.out.println(person);
        }
    }
}
