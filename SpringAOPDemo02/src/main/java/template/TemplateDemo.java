package template;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TemplateDemo extends JdbcDaoSupport {
    static JdbcTemplate jdbcTemplate=new JdbcTemplate(new DriverManagerDataSource(
            "jdbc:mysql://localhost:3306/bootdb","root","123456"));

    public static void main(String[] args) {

        List<Person> query =
                jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<Person>(Person.class));
        for (Person person : query) {
            System.out.println(person);
        }

        query.stream().map(p->p.getName()).forEach(System.out::println);
        System.out.println("============================");
        List<Person> collect =
                query.stream().filter(p -> p.getAge() > 20).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("============================");
        query.stream().flatMap(person -> {

            Stream<String> s2 = Arrays.stream(new String[]{String.valueOf(person.getAge()), String.valueOf(person.getId()), person.getName()});
            return s2;
        }).forEach(System.out::println);


    }
}
