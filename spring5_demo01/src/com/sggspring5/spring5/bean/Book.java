package com.sggspring5.spring5.bean;

/**
 * ClassName: Book
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/27 11:35
 * @Version 1.0
 */
public class Book {
    private String bname;
    private String bauthor;
    private String address;

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
