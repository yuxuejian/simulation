package com.iocaop.simulation.aop.weaving;

import com.iocaop.simulation.aop.pointcut.MethodMacher;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/8 15:55
 */
public class AdvisedSupport {

    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;

    private MethodMacher methodMacher;

    public TargetSource getTargetSource() {
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodInterceptor getMethodInterceptor() {
        return methodInterceptor;
    }

    public void setMethodInterceptor(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    public MethodMacher getMethodMacher() {
        return methodMacher;
    }

    public void setMethodMacher(MethodMacher methodMacher) {
        this.methodMacher = methodMacher;
    }
}
