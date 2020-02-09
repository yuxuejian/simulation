package com.iocaop.simulation.aop.pointcut;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/5 17:13
 */
public interface MethodMacher {

    boolean machers(Method method, Class beanClass) throws Exception;
}
