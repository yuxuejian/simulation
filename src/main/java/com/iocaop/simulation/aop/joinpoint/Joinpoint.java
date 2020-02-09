package com.iocaop.simulation.aop.joinpoint;

import java.lang.reflect.AccessibleObject;

/**
 * 连接点：需要切入的点，只支持方法级别
 *
 * @author csu_y
 * @date 2020/2/5 20:47
 */
public interface Joinpoint {
    /**
     * 该方法用于执行拦截器逻辑，执行目标方法
     * @return
     * @throws Throwable
     */
    Object proceed() throws Throwable;

    /**
     * 获取代理对象
     * @return
     */
    Object getThis();

    AccessibleObject getStaticPart();
}
