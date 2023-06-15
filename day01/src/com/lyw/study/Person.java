package com.lyw.study;

public class Person implements Comparable<Person> {
    String name;
    int age;

    public Person() {
    }

    @Override
    public int compareTo(Person o) {
        int ret = o.age - this.age;
        if (ret != 0) {
            return ret;
        } else {
            return this.name.compareTo(o.name);
        }

    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
