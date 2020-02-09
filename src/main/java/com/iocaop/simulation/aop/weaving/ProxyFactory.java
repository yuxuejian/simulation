package com.iocaop.simulation.aop.weaving;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/8 16:08
 */
public class ProxyFactory extends AdvisedSupport implements AopProxy{
    @Override
    public Object getProxy() {
        return createAopProxy().getProxy();
    }

    private AopProxy createAopProxy() {
        return new JdkDynamicAopProxy(this);
    }
}
