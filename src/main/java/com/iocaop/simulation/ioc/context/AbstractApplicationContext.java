package com.iocaop.simulation.ioc.context;

import com.iocaop.simulation.ioc.beans.BeanPostProcessor;
import com.iocaop.simulation.ioc.factory.BeanFactoryImpl;

import java.util.List;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/9 15:44
 */
public abstract class AbstractApplicationContext implements ApplicationContext{
    protected BeanFactoryImpl beanFactory;

    public AbstractApplicationContext(BeanFactoryImpl beanFactory) {
        this.beanFactory = beanFactory;
    }

    public void refresh() throws Exception {

    }

    protected abstract void loadBeanDefinitions(BeanFactoryImpl beanFactory) throws Exception;

    protected void registerBeanPostProcessors(BeanFactoryImpl beanFactory) throws Exception {
        List beanPostProcessors = beanFactory.getBeansForType(BeanPostProcessor.class);
        for (Object beanPostProcessor : beanPostProcessors) {
            beanFactory.addBeanPostProcessor((BeanPostProcessor) beanPostProcessor);
        }
    }

    // 实现支持singleton(单例)类型的bean
    protected void onRefresh() throws Exception{
        beanFactory.preInstantiateSingletons();
    }

    // 从beanFactory中获取bean
    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }
}
