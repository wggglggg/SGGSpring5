package com.ssgspring5.spring5.bean;

/**
 * ClassName: Order
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/27 18:22
 * @Version 1.0
 */
public class Order {

    private String oname;

    public Order() {
        System.out.println("第一步 执行无参数构造创建bean实例");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步 调用set方法设置属性值");
    }

    public void initMethod(){
        System.out.println("第三步 执行初始化的方法");
    }

    public void destroyMethod(){
        System.out.println("第五步 执行销毁的方法");
    }
}
