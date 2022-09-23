package entity;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;

//@Component
public class GenericFactoryBean extends AbstractFactoryBean {
    Class aClass;
    @Override
    public Class<?> getObjectType() {
        return aClass;
    }

    @Override
    protected Object createInstance() throws Exception {
        Object o = aClass.newInstance();
        return o;
    }

    public GenericFactoryBean(Class aClass) {
        this.aClass = aClass;
    }
}
