package com.wh.ui;


import com.wh.dao.IAccountDao;
import com.wh.service.IAccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {

    /**
     * 获取spring的ioc的核心容器，并根据id获取对象
     * ApplicationContext的三个常用实现类：
     *      ClassPathXmlApplicationContext：它可以加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话，加载不了
     *      FileSystemXmlApplicationContext：它可以加载磁盘人一路径下的配置文件（必须又访问权限）
     *      AnnotationConfigApplicationContext：它是用于读取注解创建容器的
     *
     * 核心容器的两个接口引发出的问题
     * ApplicationContext：  单例对象适用
     *      它在构建核心容器时，创建对象采用的策略是采用立即加载的方式。也就是说，只要一度去配置文件立马就去创建文件中的配置的对象。
     * BeanFactory：     多例对象适用
     *      它在构建核心容器时，创建对象采用的策略是采用延迟加载的方式。什么时候根据id获取对象了，什么时候才真正的创建对象。
     * @param args
     */
    public static void main(String[] args) {
        //1.获取核心容器对象
//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext ac = new FileSystemXmlApplicationContext("E:\\spring\\spring01_spring\\src\\main\\resources\\bean.xml");
//        //2.根据id获取bean对象
//        IAccountService as = (IAccountService) ac.getBean("accountService");
//        IAccountDao ad = ac.getBean("accountDao", IAccountDao.class);
//        System.out.println(as);
//        System.out.println(ad);

        //------beanFactory------
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService as = (IAccountService) factory.getBean("accountService");
        System.out.println(as);
    }

}
