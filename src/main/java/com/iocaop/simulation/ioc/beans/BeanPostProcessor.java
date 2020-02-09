package com.iocaop.simulation.ioc.beans;

/**
 * 实例化的类需要实现的接口（不是必须）
 *
 * @author csu_y
 * @date 2020/2/4 19:41
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception;
    Object postProcessAfterInitialization(Object bean, String beanName) throws Exception;
}
