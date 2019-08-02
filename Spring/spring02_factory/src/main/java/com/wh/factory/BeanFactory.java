package com.wh.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 一个创建bean对象的工厂
 * <p>
 * Bean：在计算机英语中，可重用组件的含义
 * JavaBean：用java语言编写的可重用组件
 * javabean>实体类
 * <p>
 * 它就是创建我们的service和dao对象的
 * <p>
 * 第一个：需要一个配置文件来配置我们的service和dao
 * 配置内容：唯一表示=全限定类名
 * <p>
 * 第二个：通过读取配置文件中配置的内容，反射创建对象
 * <p>
 * 我们的配置文件可以是xml也可以是properties
 *
 * 体会：之前是通过多例模式：每次调用都要通过反射的手段调用到相对应的bean
 * 后面改为单例，先在加载静态类方法的时候先将所有的类创建存入map之中，然后调用跟据beanName 去map中获取与之对应的类
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties props;

    //定义一个Map，用于存放我们需要创建的对象，我们把他称之为容器
    private static Map<String, Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        try {
            //实例化对象
            props = new Properties();
            //获取properties文件的流对象
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(in);
            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()) {
                //取出每个key
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = props.getProperty(key);
                //反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key, value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化properties失败");
        }
    }


    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }


//    /**
//     * 根据bean的名称获取bean对象
//     * @param beanName
//     * @return
//     */
//    public static Object getBean(String beanName) {
//        Object bean = null;
//        try {
//            String beanPath = props.getProperty(beanName);
//            bean = Class.forName(beanPath).newInstance();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bean;
//    }
}
