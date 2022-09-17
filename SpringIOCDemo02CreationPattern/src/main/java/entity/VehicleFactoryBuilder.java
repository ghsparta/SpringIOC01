package entity;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:app.properties")
public class VehicleFactoryBuilder {

    @Value("${vehiclefactory}")
    String WhichFactory;

    public VehicleFactory getVehicleFactory() throws Exception {
        return ((VehicleFactory) Class.forName(WhichFactory).newInstance());
    }

}
