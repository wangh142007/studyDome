package com.wh.factory;

import com.wh.service.IAccountService;
import com.wh.service.impl.AccountServiceImpl;

/**
 * 模拟一个工厂类（该类可能是存在于jar中的，我们无法通过修改源码的方式来提供默认的构造函数）
 */
public class InstanceFactory {

    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
