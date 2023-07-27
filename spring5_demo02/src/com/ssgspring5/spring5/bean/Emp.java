package com.ssgspring5.spring5.bean;

/**
 * ClassName: Emp
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/27 20:30
 * @Version 1.0
 */
public class Emp {

    private Dept dept;

    public Emp() {
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }


    public void test(){
        System.out.println("dept = " + dept);
    }
}
