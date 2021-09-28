package com.atguigu.java2;

import com.atguigu.java1.Person;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author fanhuilin
 * @date 2021-09-28 15:15
 */
public class MethodTest {

    @Test
    public void test1() {
        Class clazz = Person.class;

        // getMethods():获取当前运行类及其父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            System.out.println(m);
        }
        System.out.println();

        //getDeclaredMethods():获取当前运行时类中声明的所有方法。（不包含父类中声明的方法）
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            System.out.println(m);
        }

    }

    /*
     * @xxx
     * 权限修饰符
     * 返回值类型
     * 方法名（参数类型1 形参名1，。。。） throws XxxException{}
     * */
    @Test
    public void test2() {
        Class clazz = Person.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method m : declaredMethods) {
            // 1、获取方法声明的注解
//            Annotation[] annos = m.getAnnotations();
//            for (Annotation a : annos) {
//                System.out.println(a);
//            }

            // 2、获取权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + ",");

            // 3、返回值类型
            System.out.print(m.getReturnType().getName() + ",");

            // 4、方法名
            System.out.print(m.getName());
            System.out.print("(");
            // 5、形参列表
            Class[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes == null && parameterTypes.length == 0)) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i == parameterTypes.length - 1) {
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
                }
            }

            // 6、 跑出的异常
            Class[] exceptiontypes = m.getExceptionTypes();
            if (exceptiontypes.length > 0) {
                System.out.print(" throws ");
                for (int i = 0; i < exceptiontypes.length; i++) {
                    if (i == exceptiontypes.length - 1) {
                        System.out.println(exceptiontypes[i].getName());
                        break;
                    }
                    System.out.println(exceptiontypes[i].getName() + ",");
                }
            }


            System.out.print(")");
            System.out.println();
        }
    }
}
