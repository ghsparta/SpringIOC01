import com.demo.DepartmentMapper;
import com.demo.EmpMapper;
import com.demo.domain.Department;
import com.demo.domain.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisDepartmentTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        String resource = "mybatis-config-2.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void testSelectDepartmentByIdWithInterface()  {
        //try-with-resource
        try (SqlSession session = sqlSessionFactory.openSession()) {
            DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
            Department department = mapper.selectDepartmentById(1);
            System.out.println(department);
        }
    }


    @Test
    public void testSelectDepartmentByIdSeparately()  {
        //try-with-resource
        try (SqlSession session = sqlSessionFactory.openSession()) {
            DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
            Department department = mapper.selectDepartmentById2(1);
            System.out.println(department.getDname());
            System.out.println("=============not yet=============");
            System.out.println(department.getHead());
            System.out.println("=============all info=============");
            System.out.println(department);
        }
    }
}
