package com.atguigu.java1;

import java.io.Serializable;

/**
 * @author fanhuilin
 * @date 2021-09-28 14:35
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物进食");
    }
}
