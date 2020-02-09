package com.iocaop.simulation.aop.weaving;

import com.iocaop.simulation.aop.joinpoint.MethodInvocation;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/8 16:03
 */
public interface MethodInterceptor extends Interceptor{
    Object invoke(MethodInvocation methodInvocation) throws Throwable;
}
