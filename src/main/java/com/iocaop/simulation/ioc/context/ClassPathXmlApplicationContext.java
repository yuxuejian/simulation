package com.iocaop.simulation.ioc.context;

import com.iocaop.simulation.ioc.beans.BeanDefinition;
import com.iocaop.simulation.ioc.factory.BeanFactoryImpl;
import com.iocaop.simulation.ioc.reader.BeanDefinitionReader;
import com.iocaop.simulation.ioc.reader.BeanDefinitionReaderImpl;

import java.util.Map;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/9 15:50
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext{
    private String configLocation;

    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        // 默认是自动装载bean
        this(configLocation, new BeanFactoryImpl(configLocation));
    }

    public ClassPathXmlApplicationContext(String configLocation, BeanFactoryImpl beanFactory) throws Exception {
        super(beanFactory);
        this.configLocation = configLocation;
        refresh();
    }
    @Override
    protected void loadBeanDefinitions(BeanFactoryImpl beanFactory) throws Exception {
        BeanDefinitionReaderImpl xmlBeanDefinitionReader = new BeanDefinitionReaderImpl();
        // 从类路径加载xml文件中bean的定义并注册到AbstractBeanDefinitionReader的registry中去
        xmlBeanDefinitionReader.loadBeanDefinitions(configLocation);
        // 将加载出的bean定义从registry中注册到beanFactory中
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }
    }
}
