package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author fanhuilin
 * @date 2021-09-28 14:48
 */
public class FieldTest {
    // 获取属性
    @Test
    public void test1() {
        Class clazz = Person.class;
        // 获取属性结构,
        // getFields():能够获取当前运行类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();
        for (Field f : fields) { // 此处有疑惑
            System.out.println(f);
        }
        System.out.println();

        // getDeclaredFields():获取当前运行类中声明的所有属性。（不包含父类中声明的属性）
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) { // 此处有疑惑
            System.out.println(f);
        }
    }

    // 权限修饰符 数据类型 变量名
    @Test
    public void test2() {
        Class clazz = Person.class;
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) { // 此处有疑惑
            // 权限修饰符
            int modifier = f.getModifiers(); // 默认是数字，使用Modifier.toString(modifier)获取字符串
            System.out.print(Modifier.toString(modifier) + ",");

            // 数据类型
            Class type = f.getType();
            System.out.print(type.getName() + ",");

            // 变量名
            String fName = f.getName();
            System.out.println(fName);
        }
    }


}
