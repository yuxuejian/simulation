package com.iocaop.simulation.aop.weaving;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/8 16:09
 */
public abstract class AbstractAopProxy implements AopProxy{

    protected AdvisedSupport advisedSupport;

    public AbstractAopProxy(AdvisedSupport advisedSupport) {
        this.advisedSupport = advisedSupport;
    }
}
