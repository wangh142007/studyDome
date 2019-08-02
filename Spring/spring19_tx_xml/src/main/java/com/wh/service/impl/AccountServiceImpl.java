package com.wh.service.impl;

import com.wh.dao.IAccountDao;
import com.wh.domain.Account;
import com.wh.service.IAccountService;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findAccountById(Integer id) {
        Account accountById = accountDao.findAccountById(id);
        return accountById;
    }

    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("开始执行");

        //2.执行操作
        //2.1.根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        //2.2.根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        //2.3.转出账户减钱
        source.setMoney(source.getMoney() - money);
        //2.4.转入账户加钱
        target.setMoney(target.getMoney() + money);
        //2.5.更新转入账户
        accountDao.updateAccount(source);
        int a = 1 / 0;
        //2.6.更新转出账户
        accountDao.updateAccount(target);
        //3.提交事务


    }
}
