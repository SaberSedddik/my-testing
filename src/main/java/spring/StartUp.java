package spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Created by saberseddik on 15-01-31.
 */
public class StartUp {
    final static Logger logger = LoggerFactory.getLogger(StartUp.class);
    private GenericApplicationContext context;
    public static void main(String[] args) {
       // ClassPathXmlApplicationContext applicationContext =new ClassPathXmlApplicationContext("spring/application-context.xml");
        new StartUp().run();
    }

    public void run(){
        logger.info("Initializing Spring context.");

        context = new GenericApplicationContext();
        BeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(context);
        //AnnotatedBeanDefinitionReader classReader = new AnnotatedBeanDefinitionReader(context);

        xmlReader.loadBeanDefinitions("spring/application-context.xml");

        logger.info("Spring context initialized.");

        context.registerShutdownHook();
        context.refresh();
        System.out.println("done");
    }
}
