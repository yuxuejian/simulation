package com.iocaop.simulation.ioc.reader;

import java.io.FileNotFoundException;

/**
 * 读取类信息接口
 *
 * @author csu_y
 * @date 2020/2/4 19:39
 */
public interface BeanDefinitionReader {
    /**
     * 根据地址加载类的信息
     * @param location
     * @throws FileNotFoundException
     * @throws Exception
     */
    void loadBeanDefinitions(String location) throws FileNotFoundException, Exception;
}
