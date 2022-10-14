package template;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TemplateDemo extends JdbcDaoSupport {
    static JdbcTemplate jdbcTemplate=new JdbcTemplate(new DriverManagerDataSource(
            "jdbc:mysql://localhost:3306/bootdb","root","123456"));

    public static void main(String[] args) {

        List<Person> query =
                jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
        for (Person person : query) {
            System.out.println(person);
        }

    }
}
