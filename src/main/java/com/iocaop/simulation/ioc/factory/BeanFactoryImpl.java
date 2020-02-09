package com.iocaop.simulation.ioc.factory;

import com.iocaop.simulation.aop.weaving.BeanFactoryAware;
import com.iocaop.simulation.ioc.beans.BeanDefinition;
import com.iocaop.simulation.ioc.beans.BeanPostProcessor;
import com.iocaop.simulation.ioc.beans.BeanReference;
import com.iocaop.simulation.ioc.beans.PropertyValue;
import com.iocaop.simulation.ioc.reader.BeanDefinitionReaderImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类工厂的实现类（获取类的实例对象）
 *
 * @author csu_y
 * @date 2020/2/4 20:26
 */
public class BeanFactoryImpl implements BeanFactory{

    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private List<String> beanDefinitionNames = new ArrayList<>();

    private List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    private BeanDefinitionReaderImpl beanDefinitionReader;

    public BeanFactoryImpl(String location) throws Exception{
        beanDefinitionReader = new BeanDefinitionReaderImpl();
        loadBeanDefinitions(location);
    }

    private void loadBeanDefinitions(String location) throws Exception{
        beanDefinitionReader.loadBeanDefinitions(location);
        registerBeanDefinition();
        registerBeanPostProcessor();
    }

    private void registerBeanDefinition() {
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionReader.getRegistry().entrySet()) {
            String name = entry.getKey();
            beanDefinitionMap.put(name, entry.getValue());
            beanDefinitionNames.add(name);
        }
    }

    private void registerBeanPostProcessor() throws Exception{
        List beans = getBeansForType(BeanPostProcessor.class);
        for (Object bean : beans) {
            beanPostProcessors.add((BeanPostProcessor) bean);
        }
    }

    public List getBeansForType(Class type) throws Exception{
        List beans = new ArrayList<>();
        for (String beanDefinitionName : beanDefinitionNames) {
            if (type.isAssignableFrom(beanDefinitionMap.get(beanDefinitionName).getBeanClass())) {
                beans.add(getBean(beanDefinitionName));
            }
        }
        return beans;
    }

    @Override
    public Object getBean(String beanId) throws Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanId);
        if (beanDefinition == null) {
            throw  new IllegalArgumentException("no this bean name ["+beanId+"]");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            bean = createBean(beanDefinition);
            bean = initializeBeam(bean, beanId);
            beanDefinition.setBean(bean);
        }
        return bean;
    }

    private Object createBean(BeanDefinition beanDefinition) throws Exception{
        Object bean = beanDefinition.getBeanClass().newInstance();
        applyPropertyValues(bean, beanDefinition);
        return bean;
    }

    private Object initializeBeam(Object bean, String name) throws Exception{
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessBeforeInitialization(bean, name);
        }
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            bean = beanPostProcessor.postProcessAfterInitialization(bean, name);
        }
        return bean;
    }

    private void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception{
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValueList()) {
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }
            try {
                String setMethod = "set" + propertyValue.getName().substring(0, 1).toUpperCase() + propertyValue.getName().substring(1);
                Method declaredMethod = bean.getClass().getDeclaredMethod(setMethod, value.getClass());

                declaredMethod.setAccessible(true);
                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }

    }
    /**
     * 预处理bean的定义，将bean的名字提前存好,实现Ioc容器中存储单例bean
     * @throws Exception
     */
    public void preInstantiateSingletons() throws Exception {
        Iterator it = this.beanDefinitionNames.iterator();
        while (it.hasNext()) {
            String beanName = (String) it.next();
            getBean(beanName);
        }
    }
    // 增加bean处理程序，例如AspectJAwareAdvisorAutoProxyCreator#postProcessAfterInitialization()
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) throws Exception {
        this.beanPostProcessors.add(beanPostProcessor);
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }
}
