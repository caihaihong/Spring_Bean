package com.service.imple;


import com.service.ICustomerService;


public class CustomerServiceImpl implements ICustomerService {
    public CustomerServiceImpl() {
        System.out.println("CustomerServiceImpl的bean对象被创建了");
    }

    public void init() {
        System.out.println("init方法：对象被初始化了");
    }

    public void destroy() {
        System.out.println("destroy方法：对象被销毁了");
    }

    @Override
    public void saveCustomer() {
        System.out.println("业务层调用持久层");
    }
}
