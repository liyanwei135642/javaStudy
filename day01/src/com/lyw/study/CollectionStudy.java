package com.lyw.study;

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


class Student implements Comparable{
    private String name;
    private byte age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public Student(String name, byte age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
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