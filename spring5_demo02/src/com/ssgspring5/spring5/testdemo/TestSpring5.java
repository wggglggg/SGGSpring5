package com.ssgspring5.spring5.testdemo;

import com.ssgspring5.spring5.bean.Dept;
import com.ssgspring5.spring5.bean.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: TestSpring5
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/27 18:28
 * @Version 1.0
 */
public class TestSpring5 {

    @Test
    public void testOrder(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Object order = context.getBean("order", Object.class);
        System.out.println("第四步 获取创建bean实例对象");

        System.out.println("order = " + order);

        //手动让bean实例销毁
        context.close();
    }

    @Test
    public void testEmpDeptAutowire(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Emp emp = context.getBean("emp", Emp.class);
        Dept dept = context.getBean("dept", Dept.class);

        System.out.println("emp = " + emp);
        System.out.println("dept = " + dept);

    }
}
