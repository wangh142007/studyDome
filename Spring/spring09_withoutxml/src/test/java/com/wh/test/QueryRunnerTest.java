package com.wh.test;

import com.wh.service.IAccountService;
import config.SpringConfiguration;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 测试QueryRunner是否单例
 */
public class QueryRunnerTest {

    @Test
    public void testQueryRunner(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2.得到业务层对象
        QueryRunner queryRunner = ac.getBean("queryRunner",QueryRunner.class);
        QueryRunner queryRunner1 = ac.getBean("queryRunner",QueryRunner.class);
        System.out.println(queryRunner==queryRunner1);
    }
}
