package com.iocaop.simulation.aop.weaving;

import com.iocaop.simulation.ioc.factory.BeanFactory;

/**
 * 实例化类需要实现的接口（不是必须）
 *
 * @author csu_y
 * @date 2020/2/4 19:38
 */
public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
