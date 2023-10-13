import iocusage.DatabaseConfig;
import iocusage.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MainClass2 {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(DatabaseConfig.class);
        for (String beanDefinitionName : context.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
        //print separator line
        System.out.println("--------------------------------------------------");
//        System.out.println(((JdbcTemplate) context.getBean("jdbcTemplate")).getDataSource());
        //print separator line
        System.out.println("--------------------------------------------------");
        System.out.println(context.getBean(MyService.class).someDatabaseOperation());

        context.close();
    }
}
