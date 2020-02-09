package com.iocaop.simulation;

/**
 * TODO
 *
 * @author csu_y
 * @date 2020/2/8 17:20
 */
public class UserServiceImpl implements UserService{
    @Override
    public void getUserName(User user) {
        System.out.println("用户信息："+user.toString());
    }
}
