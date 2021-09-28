package com.atguigu.java1;

/*
* 3、自定义注解：参照SuppressWarnings定义
*   1)注解声明为：@interface
*   2)内部定义成员，通常使用value表示
*   3)可以指定成员的默认值，使用default定义
*   4)如果自定义注解没有成员，表明是一个标识作用
*   如果注解有成员，在使用注解时，需要指明成员的值。
*   自定义注解必须配上注解的信息处理流程（使用反射）才有意义。
*   自定义注解通常都会指明两个元注解：Retention、Target
*
* 4、jdk提供的4种元注解：Retention、Target、Documented、Inherited
*   元注解：对现有的注解进行解释说明的注解
*   Retention：指定所修饰的Annotation的生命周期：SOURCE\CLASS(默认行为)\RUNTIME
*               只有声明为RUNTIME生命周期的注解，才能通过反射获取
*   Target：用于指定被修饰的Annotation能用于修饰哪些程序元素，不指定则没有要求
*   Documented：表示所修饰的注解在被javadoc解析时，保留下来
*   Inherited：被它修饰的Annotation将具有继承性
*
* 5、通过反射获取注解信息
*
* 6、jdk8 中注解的新特性：可重复注解、类型注解
*   6、1可重复注解
*
* */

import org.junit.Test;

public class AnnotationTest {
    public static void main(String[] args) {

        @SuppressWarnings("unused")
        int num = 10;
    }

    @Test
    public void testGetAnnotation(){
        System.out.println("testGetAnnotation");
    }
}

@MyAnnotation(value = "hello")
class Person{

}
