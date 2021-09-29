package com.fanhuilin.test1;

/**
 * @author fanhuilin
 * @date 2021-09-29 10:53
 */
public class Http {

    protected void doGet() {
        System.out.println("我是Http类中的doGet方法");
    }

    protected void service() {
        this.doGet();
    }
}
