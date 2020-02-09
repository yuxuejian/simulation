package com.iocaop.simulation.aop.joinpoint;

import com.iocaop.simulation.aop.joinpoint.Joinpoint;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/5 20:51
 */
public interface Invocation extends Joinpoint {
    Object[] getArguments();
}
