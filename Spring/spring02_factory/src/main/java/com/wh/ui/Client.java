package com.wh.ui;

import com.wh.dao.IAccountDao;
import com.wh.factory.BeanFactory;
import com.wh.service.IAccountService;
import com.wh.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    public static void main(String[] args) {
//        IAccountService as = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }

    }
    /**
     * 总结：
     *     private IAccountDao accountDao =new AccountDaoImpl();
     *     private IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");
     *     这两者的区别
     *     通过new出来的对象  是我们主动去寻求资源的，它的耦合度就高了
     *     通过工厂实现的话，是我们把资源交给工厂去代理，我们只要传入对应的字段，然后工厂就返回我们对应的值，
     *     从来实现解耦。
     *
     *     ioc的作用：是削减计算机程序之间的耦合
     */
}
