package iocusage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Service
public class MyService {
    
//    @Autowired
//    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Map<String, Object>> someDatabaseOperation() {
        String sql = "SELECT * FROM tb_department";
        return jdbcTemplate.queryForList(sql);
    }


}
