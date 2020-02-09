package com.iocaop.simulation;

import com.iocaop.simulation.ioc.context.ApplicationContext;
import com.iocaop.simulation.ioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/8 17:00
 */
public class IocAopTest {

    @Test
    public void getBean() throws Exception{
        System.out.println("--------- IOC test ----------");
        String location = getClass().getClassLoader().getResource("simulation.xml").getFile();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(location);
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);

        System.out.println("\n--------- AOP test ----------");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.getUserName(user);
    }
}
