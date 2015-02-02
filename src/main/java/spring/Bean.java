package spring;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by saberseddik on 15-01-31.
 */
public class Bean implements InitializingBean{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initialized");
    }
}
