package com.iocaop.simulation.aop.pointcut;

/**
 * 切点：用于选择连接点
 *
 * @author csu_y
 * @date 2020/2/5 20:40
 */
public interface Pointcut {
    ClassFilter getClassFilter();
    MethodMacher getMathodMacher();
}
