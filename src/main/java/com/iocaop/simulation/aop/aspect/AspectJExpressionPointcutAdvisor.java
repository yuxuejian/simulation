package com.iocaop.simulation.aop.aspect;

import com.iocaop.simulation.aop.advice.Advice;
import com.iocaop.simulation.aop.aspect.PointcutAdvisor;
import com.iocaop.simulation.aop.pointcut.AspectJExpressionPointcut;
import com.iocaop.simulation.aop.pointcut.Pointcut;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/6 9:50
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();

    private Advice advice;

    public void setExpression(String expression) {
        aspectJExpressionPointcut.setExpression(expression);
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        return aspectJExpressionPointcut;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }
}
