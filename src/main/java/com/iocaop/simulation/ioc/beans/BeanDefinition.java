package com.iocaop.simulation.ioc.beans;

/**
 * 解析后类信息
 * IOC容器可以根据这个类定义的信息生成实例对象
 *
 * @author csu_y
 * @date 2020/2/4 19:23
 */
public class BeanDefinition {

    private Object bean;
    /**
     * bean的类型
     */
    private Class beanClass;
    /**
     * bean的名称
     */
    private String beanClassName;
    /**
     * bean的属性集合（键值对）
     */
    private PropertyValues propertyValues = new PropertyValues();

    public BeanDefinition() {}

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
