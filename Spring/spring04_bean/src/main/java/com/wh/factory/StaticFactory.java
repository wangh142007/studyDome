package com.wh.factory;

import com.wh.service.IAccountService;
import com.wh.service.impl.AccountServiceImpl;

public class StaticFactory {

    public static IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
