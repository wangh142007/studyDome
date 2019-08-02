package com.wh.jdbc;

import java.sql.*;

/**
 * 程序的耦合
 *      耦合：程序间的依赖关系
 *          包括：
 *              类之间的依赖
 *              方法间的依赖
 *      解耦：降低程序间的依赖关系
 *      实际开发中：
 *          编译期不依赖，运行时才依赖
 *      解耦思路：
 *          第一步：使用反射来创建对象，避免使用new关键字
 *          第二步：通过读取配置文件获取要创建的对象全限定类名
 */
public class jdbcDemo {

    public static void main(String[] args) throws Exception {
        //1.注册驱动
//        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");//反射
        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","1234");
        //3.获取操作数据库的预处理对象
        PreparedStatement pstm = connection.prepareStatement("select * from account");
        //4.执行SQL，得到结果
        ResultSet rs = pstm.executeQuery();
        //5.便利结果集
        while (rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6. 释放资源
        rs.close();
        pstm.close();
        connection.close();
    }
}
