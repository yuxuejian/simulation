package com.iocaop.simulation.aop.advice;

import com.sun.istack.internal.Nullable;

import java.lang.reflect.Method;

/**
 * 后置通知：方法执行后调用
 *
 * @author csu_y
 * @date 2020/2/5 22:18
 */
public interface AfterReturningAdvice {
    void afterReturning(@Nullable Object returnValue, Method method, Object[] args, @Nullable Object target) throws Throwable;
}
