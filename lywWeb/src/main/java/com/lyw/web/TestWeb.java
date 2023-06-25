package com.lyw.web;

import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.*;

//测试HTTP
@RestController
public class TestWeb {

    //处理资源路径为/hello1的http请求 整个请求对象作为参数
    @RequestMapping("/hello1")
    public String httpRe1(HttpServletRequest request){
        //获取指定的请求参数如"name"的值
        String name = request.getParameter("name");
        String text="Hello Spring Boot<br>";
        text+="获取指定的请求参数如\"name\"的值<br>name:"+name+"<br>";
        //获取所有参数的名字
        text+="获取所有参数的名字<br>";
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            text+=s+"<br>";
        }
        text+="获取一个关键字对应的所有值<br>";
        String[] names = request.getParameterValues("name");
        text+= "name:"+Arrays.toString(names)+"<br>";
        text+="获取参数的键值对字典，一个键对应一个数组<br>";
        Map<String, String[]> pm = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = pm.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            text+=entry.getKey()+":"+Arrays.toString(entry.getValue())+"<br>";
        }
        //获取请求方式
        String method = request.getMethod();
        text=method+"<br>"+text;
        //获取客户端IP地址
        String remoteHost = request.getRemoteAddr();
        text+="客户端IP:"+remoteHost+"<br>";
        //获取请求头信息
        Enumeration<String> hns = request.getHeaderNames();
        text+="请求头信息<br>";
        while(hns.hasMoreElements()){
            String s = hns.nextElement();
            text+=s+":"+request.getHeader(s)+"<br>";
        }
        //URL是所有路径 ?之前的全部网址
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURL);
        //URI只有资源路径
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        String remoteUser = request.getRemoteUser();
        System.out.println(remoteUser);


        String str="<h1 style=\" text-align:center\">"+text+"</h1>";
        return str;
    }

    //处理资源路径为/hello2的http请求 具体的请求参数作为参数
    @RequestMapping(value = "/hello2")
    public String httpRe2(String name,Integer age){
        return name+":"+age;
    }

    //处理资源路径为/hello3的http请求 具体的请求参数作为参数 加了形参注解 形参的名字就不必和请求参数完全一致
    @RequestMapping(value = "/hello3")
    public String httpRe3(@RequestParam(name = "name",required = false)String myname, Integer age){
        return myname+":"+age;
    }

    //处理资源路径为/hello4的http请求 具体的请求参数作封装到一个类里面 将类作为形参
    @RequestMapping(value = "/hello4")
    public String httpRe4(User user){
        return user.toString();
    }

    //处理资源路径为/hello5的http请求 传递日期格式的形参
    @RequestMapping(value = "/hello5")
    public String httpRe5( @RequestParam(name = "dateTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime time){
        return time.toString();
    }

    //处理资源路径为/hello6的http请求 传递JSON形参 需要加注解@RequestBody
    @RequestMapping(value = "/hello6")
    public String httpRe6(@RequestBody User user){
        return user.toString();
    }

    //路径参数 id为资源路径的内容 要将这个参数传递进来需要注解 @PathVariable
    @RequestMapping(value = "/hello/{name}/{id}")
    public String httpRe7(@PathVariable Integer id,@PathVariable String name){
        return name+id.toString();
    }

    //类上加了@RestController注解等于加了@Controller @ResponseBody 两个注解
    //所有方法的返回值如果是字符串直接将字符串作为响应体返回 如果是对象 就将对象封装为JSON对象返回
    @CrossOrigin
    @RequestMapping(value = "/json")
    public User httpRe8(HttpServletRequest request){
        User u=new User();
        u.setAge(19);
        u.setName("李彦伟");
        u.setAddr(new Addr("山西","柳林"));
        System.out.println(u);
        return u;
    }

    //返回值是集合的话 响应就是数组 里面放的是每个对象的JSON对象
    @CrossOrigin
    @RequestMapping(value = "/json2")
    public List<User> httpRe9(HttpServletRequest request){
        User u=new User();
        u.setAge(19);
        u.setName("李彦伟");
        u.setAddr(new Addr("山西","柳林"));了，
        List<User> list=new ArrayList<>();
        list.add(u);
        list.add(u);
        list.add(u);
        return list;
    }

    //统一返回值 Result 响应就是Result的JSON对象
    @CrossOrigin
    @RequestMapping(value = "/json3")
    public Result<List<User>> httpRe10(HttpServletRequest request){
        User u=new User();
        u.setAge(19);
        u.setName("李彦伟");
        u.setAddr(new Addr("山西","柳林"));
        List<User> list=new ArrayList<>();
        list.add(u);
        list.add(u);
        list.add(u);
        return new Result<>(1,"success",list);
    }
}
