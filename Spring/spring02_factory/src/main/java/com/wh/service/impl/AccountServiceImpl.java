package com.wh.service.impl;

import com.wh.dao.IAccountDao;
import com.wh.dao.impl.AccountDaoImpl;
import com.wh.factory.BeanFactory;
import com.wh.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

//    private IAccountDao accountDao =new AccountDaoImpl();
    private IAccountDao accountDao = (IAccountDao)BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
