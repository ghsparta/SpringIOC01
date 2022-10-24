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
            System.out.println(mapper.getClass().getName());
            Person person = mapper.selectPerson(2);
//            Person p =  session.selectOne("com.demo.PersonMapper.selectPerson", 2);
            System.out.println(person);
        }
    }


}
