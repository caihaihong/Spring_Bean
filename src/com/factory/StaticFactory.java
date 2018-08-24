package com.factory;

import com.service.ICustomerService;
import com.service.imple.CustomerServiceImpl;

public class StaticFactory {
//    静态工厂所以用static
    public static ICustomerService getCustomerService(){
        return new CustomerServiceImpl();
    }

}
