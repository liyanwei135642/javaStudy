package com.lyw.study;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解学习 给计算机看的
 *      1.@Override 表示被该注解标记的方法是重写父类的同名方法
 *      2.@Deprecated 表示被该注解标记的方法是过时的方法 不推介使用
 *      3.@SuppressWarnings 表示取消编译器的检查
 *      4.@FunctionalInterface 表示被该注解标记的接口是函数式接口
 * 元注解 给注解添加元注解表示说明的
 *      1.@Retention 用来标志被该注解标注的注解将来会出现在哪
 *          有一个参数 value 有三种可选值
 *              1.RetentionPolicy.SOURCE  只在源代码中出现
 *              2.RetentionPolicy.CLASS   停留到class阶段
 *              3.RetentionPolicy.RUNTIME 整个运行阶段
 *      2.@Target 指定被修饰的注解能用于修饰哪些程序单元
 *          有一个参数 value 有多种可选值
 *              1.ElementType.TYPE  修饰类、接口、枚举、注解
 *              2.ElementType.FIELD  修饰属性、字段、枚举的常量
 *              3.ElementType.METHOD  修饰方法
 *              4.ElementType.PARAMETER  修饰方法参数
 *              5.ElementType.CONSTRUCTOR  修饰构造方法
 *              6.ElementType.LOCAL_VARIABLE  修饰布局变量
 *
 * 自定义注解
 *      定义格式：
 *          元注解
 *          public @interface 注解名称{
 *              属性列表;
 *          }
 * 注解的使用和解析
 *      1.获取字节码文件对象 谁调用了注解就获取谁的字节码文件
 *          Class<Main> C = Main.class;
 *      2.获取字节码对象上的注解信息
 *          MyAnnotation annotation = C.getAnnotation(MyAnnotation.class);
 *      3.解析注解的属性
 *           String name = annotation.name();
 *           int age = annotation.age();
 *           String value = annotation.value();
 *
 * 注解加反射掉用其他类的方法
 *         Class<Main> C = Main.class;
 *         MyAnnotation annotation = C.getAnnotation(MyAnnotation.class);
 *         String classname = annotation.className();
 *         String methodname = annotation.methodName();
 *         Class<?> aClass = Class.forName(classname);
 *         Method method = aClass.getMethod(methodname);
 *         Object o = aClass.newInstance();
 *         method.invoke(o);
 *
 *
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface MyAnnotation {
    //注解本质上继承自Annotation接口
    //注解的属性等效于接口的方法
    //注解属性定义方式：返回值类相关 属性名称(参数...)[default 默认值];
    String value()default "123";

    String name() default "liyanwei";
    int age()default 32;

    String className();

    String methodName();

}
