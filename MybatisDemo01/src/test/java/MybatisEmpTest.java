import com.demo.EmpMapper;
import com.demo.PersonMapper;
import com.demo.domain.Emp;
import com.demo.domain.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisEmpTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        String resource = "mybatis-config-2.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void testSelectEmpByIdWithInterface()  {
        //try-with-resource
        try (SqlSession session = sqlSessionFactory.openSession()) {
            EmpMapper mapper = session.getMapper(EmpMapper.class);
//            System.out.println(mapper.getClass().getName());
            Emp emp = mapper.selectEmpById(1);
            System.out.println(emp);
            emp = mapper.selectEmpByName("李胜杰");
            System.out.println(emp);
        }
    }
}
