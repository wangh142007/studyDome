package com.wh.service.impl;

import com.wh.dao.IAccountDao;
import com.wh.domain.Account;
import com.wh.service.IAccountService;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    private TransactionTemplate transactionTemplate;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public Account findAccountById(final Integer id) {

       return transactionTemplate.execute(new TransactionCallback<Account>() {
            public Account doInTransaction(TransactionStatus transactionStatus) {
                Account accountById = accountDao.findAccountById(id);
                return accountById;
            }
        });

    }

    public void transfer(final String sourceName,final String targetName,final Float money) {
        System.out.println("开始执行");
        transactionTemplate.execute(new TransactionCallback<Object>() {
            public Object doInTransaction(TransactionStatus transactionStatus) {
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
                return null;
            }
        });



    }


}
