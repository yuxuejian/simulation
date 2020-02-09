package com.iocaop.simulation.aop.aspect;

import com.iocaop.simulation.aop.aspect.Advisor;
import com.iocaop.simulation.aop.pointcut.Pointcut;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/5 22:23
 */
public interface PointcutAdvisor extends Advisor {
    Pointcut getPointcut();
}
