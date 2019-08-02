package com.wh.service;

import com.wh.domain.Account;

public interface IAccountService {

    Account findAccountById(Integer accountId);

    void transfer(String sourceName, String targetName, Float money);
}
