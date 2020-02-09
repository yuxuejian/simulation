package com.iocaop.simulation.ioc.beans;

/**
 * 类中属性的键值对
 *
 * @author csu_y
 * @date 2020/2/4 19:24
 */
public class PropertyValue {

    private final String name;

    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
