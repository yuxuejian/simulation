package com.iocaop.simulation;

import com.iocaop.simulation.aop.joinpoint.MethodInvocation;
import com.iocaop.simulation.aop.weaving.MethodInterceptor;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/8 17:25
 */
public class LogInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println(methodInvocation.getMethod().getName() + " invoke method before");
        Object object = methodInvocation.proceed();
        System.out.println(methodInvocation.getMethod().getName() + " invoke method after");
        return object;
    }
}
