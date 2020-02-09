package com.iocaop.simulation.aop.weaving;

import com.iocaop.simulation.aop.aspect.AspectJExpressionPointcutAdvisor;
import com.iocaop.simulation.ioc.factory.BeanFactory;
import com.iocaop.simulation.ioc.factory.BeanFactoryImpl;
import com.iocaop.simulation.ioc.beans.BeanPostProcessor;

import java.util.List;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/8 16:23
 */
public class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor, BeanFactoryAware {

    private BeanFactoryImpl beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws Exception {
        this.beanFactory = (BeanFactoryImpl) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws Exception {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws Exception {

        if (bean instanceof AspectJExpressionPointcutAdvisor) {
            return bean;
        }

        if (bean instanceof MethodInterceptor) {
            return bean;
        }

        List<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeansForType(AspectJExpressionPointcutAdvisor.class);

        for (AspectJExpressionPointcutAdvisor advisor : advisors) {

            if (advisor.getPointcut().getClassFilter().machers(bean.getClass())) {
                ProxyFactory proxyFactory = new ProxyFactory();
                proxyFactory.setMethodInterceptor((MethodInterceptor) advisor.getAdvice());
                proxyFactory.setMethodMacher(advisor.getPointcut().getMathodMacher());
                TargetSource targetSource = new TargetSource(bean, bean.getClass(), bean.getClass().getInterfaces());
                proxyFactory.setTargetSource(targetSource);
                return proxyFactory.getProxy();
            }
        }
        return bean;
    }
}
