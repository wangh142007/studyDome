package com.wh.service.impl;

import com.wh.dao.IAccountDao;
import com.wh.model.Account;
import com.wh.service.IAccountService;
import com.wh.utils.TransactionManager;

import java.util.List;

public class AccountServiceImpl1 implements IAccountService {

    private IAccountDao accountDao;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAllAccount() {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            List<Account> allAccount = accountDao.findAllAccount();
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return allAccount;
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException();
        }finally {
            //6.释放连接
            txManager.release();
        }
    }

    public Account findAccountById(Integer id) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            Account accountById = accountDao.findAccountById(id);
            //3.提交事务
            txManager.commit();
            //4.返回结果
            return accountById;
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
            throw new RuntimeException();
        }finally {
            //6.释放连接
            txManager.release();
        }
    }

    public void saveAccount(Account account) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            txManager.commit();
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
        }finally {
            //6.释放连接
            txManager.release();
        }
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            txManager.commit();
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
        }finally {
            //6.释放连接
            txManager.release();
        }

    }

    public void deleteAccount(Integer id) {
        try {
            //1.开启事务
            txManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(id);
            //3.提交事务
            txManager.commit();
        }catch (Exception e){
            //5.回滚操作
            txManager.rollback();
        }finally {
            //6.释放连接
            txManager.release();
        }

    }

    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("开始执行");
            //1.开启事务
            txManager.beginTransaction();
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
//            int a = 1/0;
            //2.6.更新转出账户
            accountDao.updateAccount(target);
            //3.提交事务
            txManager.commit();

    }
}
