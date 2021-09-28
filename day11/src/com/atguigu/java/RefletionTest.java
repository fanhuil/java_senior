package com.atguigu.java;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 关于java.lang.Class类的理解
 * 1、类的加载过程
 * 程序经过java.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
 * 接着使用java.exe命令对某个字节码文件进行解释运行。相当于将某个字节码文件加载到内存中。此过程称为类的加载。
 * 加载到内存中的类，我们就成为运行时类，此运行时类，就作为Class的一个实例
 * <p>
 * 2、换句话说，Class的实例就对应着一个运行时类。Class类就是用一个运行时类来赋值的。
 * 3、加载到内存中的运行时类，回缓存一定的时间。在此时间之内，我们可以通过不同的方式来获取此运行时类。
 *
 *
 *
 * @auchor fanhuilin
 * @create 2021 上午 10:38
 */
public class RefletionTest {
    public static void main(String[] args) {

    }

    // 反射之前，对于Person的操作
    @Test
    public void test1() {
        // 1、创建Person类的对象
        Person p1 = new Person("Tom", 12);

        // 2、通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());

        p1.show();

        // 在Person类外部，不可以通过Person类的对象调用其内部私有结构
    }

    // 反射之后，对于Person的操作
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        // 1、通过反射，创建Person类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(obj.toString());
        // 2、通过反射，调用对象指定的属性、方法
        // 调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p.toString());

        // 调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("*****************************");
        // 通过反射，可以调用Person私有结构的。比如：私有的构造器、方法、属性
        // 调用私有构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        // 调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "HanMeimei");
        System.out.println(p1);

        // 调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);
    }

    // 获取Class的实例的方式（前三种方式需要掌握）
    @Test
    public void test3() throws ClassNotFoundException {
        // 方式一：调用运行时类的属性：.class
        Class clazz1 = Person.class;
        System.out.println(clazz1); // class com.atguigu.java.Person

        // 方式二：通过运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        // 方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("com.atguigu.java.Person");
        System.out.println(clazz3);

        // 方式四：使用类的加载器ClassLoader
        ClassLoader classLoader = RefletionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);
    }

}
