package com.wh.dao;

import com.wh.domain.Account;

public interface IAccountDao {

    /**
     * 根据id查账户
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 根据名字查账户
     * @param name
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 修改账户
     * @param account
     */
    void updateAccount(Account account);
}
