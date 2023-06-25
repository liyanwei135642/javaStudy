package com.lyw;
import org.junit.Test;

import java.io.IOException;

public class TestDemo {
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @Test
    public void test3() throws IOException {
        System.out.println("test3");;
    }

}
