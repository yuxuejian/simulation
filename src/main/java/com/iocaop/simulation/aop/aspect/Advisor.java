package com.iocaop.simulation.aop.aspect;

import com.iocaop.simulation.aop.advice.Advice;

/**
 * 切面：结合切点和通知，主要作用是让某个方法在调用的时候能够将通知的内容执行
 *
 * @author csu_y
 * @date 2020/2/5 22:21
 */
public interface Advisor {
    Advice getAdvice();
}
