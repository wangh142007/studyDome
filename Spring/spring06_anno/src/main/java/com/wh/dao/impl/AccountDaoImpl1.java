package com.wh.dao.impl;

import com.wh.dao.IAccountDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao1")
public class AccountDaoImpl1 implements IAccountDao {

    public void saveAccount() {
        System.out.println("保存了账户1111");
    }
}
