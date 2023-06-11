package com.lyw.study;

public class ExceptionTest {
    public static void main(String[] args) {
        testException();

    }

    //异常测试
    static void testException(){
        try{
            throw new MyException("姓名错误！");
        }catch(MyException e){
           e.printStackTrace();
        }
        System.out.println("123");
    }

    static void test()
    {

    }

}
