package com.iocaop.simulation.ioc.beans;

/**
 * 类引用变量信息（用来表示property标签的ref属性里的对象）
 *
 * @author csu_y
 * @date 2020/2/4 19:33
 */
public class BeanReference {

    private String name;

    private Object bean;

    public BeanReference(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }
}
