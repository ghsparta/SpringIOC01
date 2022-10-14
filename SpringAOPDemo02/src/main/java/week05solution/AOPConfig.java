package week05solution;
 
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AOPConfig {
	@Bean
	public Calculator calculator(){
		return new Calculator();
	}


	@Bean
	public LogAspects logAspects(){
		return new LogAspects();
	}
}

