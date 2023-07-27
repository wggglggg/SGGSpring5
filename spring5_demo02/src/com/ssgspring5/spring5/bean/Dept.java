package com.ssgspring5.spring5.bean;

/**
 * ClassName: Dept
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/27 20:30
 * @Version 1.0
 */
public class Dept {

    private String dname;
    public Dept() {
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
