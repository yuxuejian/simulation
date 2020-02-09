package com.iocaop.simulation.ioc.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * 类中的属性和值
 *
 * @author csu_y
 * @date 2020/2/4 19:23
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropetyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValueList() {
        return propertyValueList;
    }
}
