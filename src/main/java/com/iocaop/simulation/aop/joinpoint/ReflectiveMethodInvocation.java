package com.iocaop.simulation.aop.joinpoint;

import com.iocaop.simulation.aop.joinpoint.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/5 20:44
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

    protected Object target;

    protected Method method;

    protected Object[] arguments;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] arguments) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Object proceed() throws Throwable {
        return method.invoke(target, arguments);
    }

    @Override
    public Object getThis() {
        return target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return method;
    }
}
