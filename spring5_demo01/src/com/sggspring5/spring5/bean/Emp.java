package com.sggspring5.spring5.bean;

/**
 * ClassName: Emp
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/27 10:42
 * @Version 1.0
 */
public class Emp {

    private String ename;
    private String gender;
    //员工属于某一个部门，使用对象形式表示
    private Dept dept;

    public Emp() {
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void add() {
        System.out.println(ename+"::"+gender+"::"+dept);
    }
}
