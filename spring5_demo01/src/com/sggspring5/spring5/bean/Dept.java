package com.sggspring5.spring5.bean;

/**
 * ClassName: Dept
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/27 10:41
 * @Version 1.0
 */
public class Dept {

    private String dname;

    public Dept() {
    }

    public String getDname() {
        return dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
