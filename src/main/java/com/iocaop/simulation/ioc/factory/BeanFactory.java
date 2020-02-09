package com.iocaop.simulation.ioc.factory;

/**
 * 工厂类，用于获取对象
 *
 * @author csu_y
 * @date 2020/2/4 19:36
 */
public interface BeanFactory {
    Object getBean(String beanId) throws Exception;
}
