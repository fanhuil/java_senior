package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author fanhuilin
 * @date 2021-09-28 15:47
 */
public class OtherTest {

    /*
     * 获取构造器结构
     * */

    @Test
    public void test1() {
        Class clazz = Person.class;
        // getConstructors():当前运行时类中声明为public的构造器
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        System.out.println();

        // getDeclaredConstructors():获取当前运行时类中声明的所有构造器
        Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }
    }
}
