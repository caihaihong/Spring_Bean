package com.ui;


import com.service.ICustomerService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * Spring的入门案例
 */
public class Client {
    /**
     * ClassPathXmlApplicationContext:只能加载类路径下的配置文件
     * FileSystemXmlApplicationContext：可以加载磁盘任意位置配置文件
     *
     * BeanFactory创建的两种规则
     * BeanFoctory：
     * 提供的是一种延迟加载思想来创建bean对象，对象什么时候使用，什么时候创建
     * ApplicationContext
     * 提供的一种立即加载思想来创建bean对象，解析完xml文件，就立刻创建
     *
     * Bean的三种创建方式：
     * 第一种：调用默认无参构造函数创建              此种方式最多
     *         默认情况下，如果没有默认无参构造函数，创建失败
     * 第二种：使用静态工厂的方法创建对象
     *         需要使用bean标签的factory-method属性，指定静态工厂中创建对象的方法
     * 第三种：使用实例工厂的方法创建
     *
     * Bean的作用范围：
     *      通过配置的方式调整作用范围
     *      配置的属性：bean标签的scoped
     *      属性值：
     *            singleton:单例的默认值
     *            prototype:多例的
     *            request:作用范围是一次请求，和当前请求的转发
     *            session:作用范围是一次会话
     *            globalsession:作用范围是一次全局会话（多台服务器，同一用户访问）
     *
     * bean的生命周期：
     *      涉及bean两个属性：
     *          init-method
     *          destroy-method
     *      单例：
     *          出生：容器创建时候，对象创建
     *          活着：只要容器在，对象就在
     *          死亡：容器销毁，对象死亡
     *      多例：
     *          出生：每次使用时创建对象
     *          活着：只有对象在使用中，就活着
     *          死亡：当java长时间没有使用，没有被引用，java回收机制回收
     * @param args
     */
    @SuppressWarnings("all")
    public static void main(String[] args) {
        //1.获取容器_立即加载方式
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据bean的id获取对象
        ICustomerService cs = (ICustomerService) ac.getBean("customerService");
//          ICustomerService cs = (ICustomerService) ac.getBean("staticCustomerService");
//          ICustomerService cs = (ICustomerService) ac.getBean("instanceCustomerService");
        ICustomerService cs1 = (ICustomerService) ac.getBean("customerService");
//        System.out.println(cs == cs1);   //单例(singleTon)：true  多例(prototype)：false
        cs.saveCustomer();
        ((ClassPathXmlApplicationContext) ac).close();//close方法属于ClassPathXmlApplicationContext  多态


//        1.获取容器_延迟加载__
//        Resource resource =  new ClassPathResource("bean.xml");
//        BeanFactory factory = new XmlBeanFactory(resource);
//        2.根据bean的id获取对象
//        ICustomerService cs = (ICustomerService) factory.getBean("customerService");
//        cs.saveCustomer();

    }
}