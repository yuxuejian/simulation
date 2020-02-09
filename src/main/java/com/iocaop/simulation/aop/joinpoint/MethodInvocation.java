package com.iocaop.simulation.aop.joinpoint;

import com.iocaop.simulation.aop.joinpoint.Invocation;

import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/5 17:18
 */
public interface MethodInvocation extends Invocation {

    Method getMethod();
}
