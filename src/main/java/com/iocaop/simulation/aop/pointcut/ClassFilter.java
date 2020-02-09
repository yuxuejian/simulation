package com.iocaop.simulation.aop.pointcut;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/5 17:11
 */
public interface ClassFilter {
    boolean machers(Class beanClass) throws Exception;
}
