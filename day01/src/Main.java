import com.lyw.net.TCPServer;
import com.lyw.study.MyAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


//使用自定义注解
@MyAnnotation(className = "com.lyw.net.TCPServer",methodName = "start")
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<Main> C = Main.class;
        MyAnnotation annotation = C.getAnnotation(MyAnnotation.class);
        String classname = annotation.className();
        String methodname = annotation.methodName();
        Class<?> aClass = Class.forName(classname);
        Method method = aClass.getMethod(methodname);
        Object o = aClass.newInstance();
        method.invoke(o);


    }

}
