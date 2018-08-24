package com.factory;

import com.service.ICustomerService;
import com.service.imple.CustomerServiceImpl;

/**
 * 模拟一个实例工厂
 */
public class InstanceFactory {

    public  ICustomerService getCustomerService() {
        return new CustomerServiceImpl();
    }
}
