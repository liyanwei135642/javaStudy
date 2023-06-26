package com.lyw.pojo;

import com.lyw.utils.XmlParse;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntFunction;

/**
 * <!--第一行第一列必须写如上的文档声明-->
 * <!--必须有一个如下的根标签 有且仅有一个根标签-->
 * <!--    特殊字符 &lt &gt-->
 * <!--    如果一定要写特殊字符也可以用右边的标签   <![CDATA[a>b]]>  -->
 * <!--xml文件的解析工具api有多种 我们用的是 dom4j-1.6.1.jar -->
 * <!--第一步 创建学生类 包含 id name age address-->
 * <!--第二步 导入jar包 dom4j.1.6.1.jar-->
 * <!--第三步 创建解析器(也可以用dom4j文档中的index.html的QuickStart条目创建)-->
 * <!--第四步 通过解析器获取xml文档数据 得到Document对象-->
 * <!--第五步 获得根节点元素对象-->
 * <!--第六步 从根节点下查找其他子节点元素 读取数据-->
 *
 */
public class Student {
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        Student[] students = XmlParse.readXMLToStudent ("lywWeb/src/main/resources/study.xml");
        System.out.println(Arrays.toString(students));


    }

    private int id;
    private String name;
    private int age;
    private String address;

    public Student() {
    }

    public Student(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }


    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Student{id = " + id + ", name = " + name + ", age = " + age + ", address = " + address + "}";
    }
}
