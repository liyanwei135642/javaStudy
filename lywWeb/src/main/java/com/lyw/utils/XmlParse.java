package com.lyw.utils;

import com.lyw.pojo.Student;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

//xml文档解析器 需要引入 org.dom4j.2.1.3.jar

public class XmlParse{
    public static void main(String[] args) {

    }
    public static Student[] readXMLToStudent(String filename) throws DocumentException, FileNotFoundException {
        //创建解析器
        SAXReader saxReader=new SAXReader();
        //获取Document对象
        Document document = saxReader.read(new FileInputStream(filename));
        //获取根节点元素对象
        Element root = document.getRootElement();
        //获取子节点元素列表
        List<Element> elements = root.elements();
        //创建Student列表用来存储读取到的对象
        ArrayList<Student> list=new ArrayList<>();
        //遍历子节点
        for (Element element : elements) {
            //获取子节点属性
            //Attribute attribute = element.attribute("id");
            //获取属性值
            //String idStr = attribute.getValue();
            //int id=Integer.parseInt(idStr);

            //获取指定的子标签元素
            Element idElement = element.element("id");
            Element nameElement = element.element("name");
            Element ageElement = element.element("age");
            Element addressElement = element.element("address");
            //获取指定的子标签元素值
            String idstr = idElement.getText();
            int id=Integer.parseInt(idstr);
            String name = nameElement.getText();
            String ageStr = ageElement.getText();
            int age=Integer.parseInt(ageStr);
            String address = addressElement.getText();
            Student s=new Student(id,name,age,address);
            list.add(s);
        }
        return list.toArray(num->new Student[num]);
    }


}