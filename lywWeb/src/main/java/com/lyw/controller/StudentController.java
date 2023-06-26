package com.lyw.controller;

import com.lyw.dao.StudentDao;
import com.lyw.pojo.Student;
import com.lyw.service.StudentService;
import com.lyw.utils.Result;
import com.lyw.utils.XmlParse;
import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.*;

@CrossOrigin
@RestController
public class StudentController {

    @RequestMapping("/students/getAll")
    public Result<Student[]> getAll() throws DocumentException, FileNotFoundException {
        //持久层操作 访问数据 删除数据
        Student[] all = StudentDao.getAll();
        //逻辑处理层
        StudentService.getAll();
        //控制层 相应数据
        return new Result<Student[]>(1,"success",all);
    }

    @RequestMapping("/students/deleteById/{id}")
    public Result<Student[]> deleteById(@PathVariable int id) throws DocumentException, FileNotFoundException {
        //持久层操作 访问数据 获取数据
        Student[] all = StudentDao.deleteById(id);
        //逻辑处理层
        StudentService.deleteById();
        //控制层 相应数据
        return new Result<Student[]>(1,"success",all);
    }

    @RequestMapping("/students/update")
    public Result<Student[]> update(@RequestBody Student s) throws DocumentException, FileNotFoundException {
        //持久层操作 访问数据 更新数据
        Student[] all = StudentDao.update(s);
        //逻辑处理层
        StudentService.update();
        //控制层 相应数据
        return new Result<Student[]>(1,"success",all);
    }

    @RequestMapping("/students/add")
    public Result<Student[]> add(@RequestBody Student s) throws DocumentException, FileNotFoundException {
        //持久层操作 访问数据 添加数据
        Student[] all = StudentDao.add(s);
        //逻辑处理层
        StudentService.add();
        //控制层 相应数据
        return new Result<Student[]>(1,"success",all);
    }


}

