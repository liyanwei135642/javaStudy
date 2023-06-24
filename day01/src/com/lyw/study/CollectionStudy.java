package com.lyw.study;
import java.io.Serializable;
import java.util.*;

public class CollectionStudy {
    public static void main(String[] args) {
       testSet();

    }

    public static <E> void addAll(ArrayList<E> arr,E...e){
        for (E e1 : e) {
            arr.add(e1);
        }
    }

    public static void testSet(){
        Set<Student> set1=new TreeSet<>();
        set1.add(new Student("liyanwei", (byte) 56));
        set1.add(new Student("liyanhong", (byte) 23));
        set1.add(new Student("lihongwei", (byte) 74));
        set1.add(new Student("libingze", (byte) 18));
        set1.add(new Student("liuchuanlan", (byte) 62));
        set1.add(new Student("muyonglian", (byte) 29));
        System.out.println(set1);







    }
}


class Student implements Comparable, Serializable {
    private static final long serialVersionUID = -5081282907286734349L;
    private String name;
    private byte age;

    //transient 关键字表示 顺态属性 不会被序列化到本地文件
    private transient String adress;

    public Student() {
    }

    public Student(String name, byte age, String adress) {
        this.name = name;
        this.age = age;
        this.adress = adress;
    }

    public Student(String name, byte age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", adress='" + adress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Object o) {
        Student s=(Student)o;
        return this.name.compareTo(s.name);
    }
}