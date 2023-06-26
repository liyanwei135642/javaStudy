package com.lyw.dao;

import com.lyw.pojo.Student;
import com.lyw.utils.XmlParse;
import org.dom4j.DocumentException;

import java.io.FileNotFoundException;
import java.util.HashMap;

//Student实体类的数据访问层(持久层)代码 只负责 数据的增删改查
public class StudentDao {
    public static HashMap<Integer , Student> students=new HashMap<>();

    static {
        Student[] ss=null;
        try {
            ss= XmlParse.readXMLToStudent("lywWeb/src/main/resources/study.xml");
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (Student s : ss) {
            int id=s.getId();
            students.put(id,s);
        }
    }

    public static Student[] getAll(){
        return students.values().toArray(Student[]::new);
    }

    public static Student[] deleteById(int id){
        boolean b = students.containsKey(id);
        if(b){
            students.remove(id);
        }
        return students.values().toArray(Student[]::new);
    }

    public static Student[] update(Student s){
        int id=s.getId();
        boolean b = students.containsKey(id);
        if(b){
            students.put(id,s);
        }
        return students.values().toArray(Student[]::new);
    }

    public static Student[] add(Student s){
        int id=s.getId();
        students.put(id,s);
        return students.values().toArray(Student[]::new);
    }

}
