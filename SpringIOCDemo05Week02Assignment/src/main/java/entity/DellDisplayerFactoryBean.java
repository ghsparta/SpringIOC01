package entity;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;


@Component
public class DellDisplayerFactoryBean extends AbstractFactoryBean<DellDisplayer> {
    @Override
    public Class<?> getObjectType() {
        return DellDisplayer.class;
    }

    @Override
    protected DellDisplayer createInstance() throws Exception {
        return new DellDisplayer();
    }
}
