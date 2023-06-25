"""
Spring网址：spring.io
SpringBootWeb开发快速入门：浏览器端发送http://localhost:8080/hello 收到响应 "Hello Spring Boot!"
1.创建SpringBoot工程,并勾选web开发相关的依赖
2.定义一个类添加@RestController注解 定义方法添加@RequestMapping("/hello")注解
3.运行测试

HTTP协议概述：基于TCP协议 无状态
    HTTP GET请求格式：
        GET /hello?name=liyanwei&age=32 HTTP/1.1  //请求行 下面的是请求头 (请求方式 资源路径+?请求参数关键字=请求参数值&请求参数关键字=请求参数值... 协议)
        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
        Accept-Encoding: gzip, deflate, br
        Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6
        Cache-Control: max-age=0
        Connection: keep-alive
        Host: 127.0.0.1:8080
        Sec-Fetch-Dest: document
        Sec-Fetch-Mode: navigate
        Sec-Fetch-Site: none
        Sec-Fetch-User: ?1
        Upgrade-Insecure-Requests: 1
        User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36 Edg/114.0.1823.51
        sec-ch-ua: "Not.A/Brand";v="8", "Chromium";v="114", "Microsoft Edge";v="114"
        sec-ch-ua-mobile: ?0
        sec-ch-ua-platform: "Windows"
    HTTP POST请求格式：
        GET /hello HTTP/1.1  //请求行 下面的是请求头 (请求方式 资源路径 协议) 空一行 请求体(请求参数关键字=请求参数值&请求参数关键字=请求参数值...)
        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7
        Accept-Encoding: gzip, deflate, br
        Accept-Language: zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6
        Cache-Control: max-age=0
        Connection: keep-alive
        Host: 127.0.0.1:8080
        Sec-Fetch-Dest: document
        Sec-Fetch-Mode: navigate
        Sec-Fetch-Site: none
        Sec-Fetch-User: ?1
        Upgrade-Insecure-Requests: 1
        User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36 Edg/114.0.1823.51
        sec-ch-ua: "Not.A/Brand";v="8", "Chromium";v="114", "Microsoft Edge";v="114"
        sec-ch-ua-mobile: ?0
        sec-ch-ua-platform: "Windows"

        name=liyanwei&age=32

    HTTP响应 数据格式
        HTTP/1.1 200 ok     //响应行 (协议 响应状态码 响应描述)  下面是响应标头 空一行 响应体
        Content-Type: text/html;charset=UTF-8   //响应体类型
        Content-Length: 53                      //响应体长度
        Date: Sat, 24 Jun 2023 15:19:17 GMT
        Keep-Alive: timeout=60
        Connection: keep-alive
        Content-Encoding:gzip                   //相应的压缩算法
        Cache-Control:                          //指示客户端如何缓存
        Set-Cookie:                              //指示客户端为当前页面所在的域名设置cookie

        Hello Spring Boot!
    响应码解析：
        1XX : 响应中 临时状态码 告诉客户端应该继续请求
        2XX : 成功 表示请求已经处理
        3xx : 重定向 浏览器会根据响应体中的重定向路径自发的重新发起请求
        4xx : 错误 责任在客户端 可能是访问的资源不存在
        5xx : 错误 责任在服务器

        100：这个临时响应表明，迄今为止的所有内容都是可行的，客户端应该继续请求，如果已经完成，则忽略它。
        101：该代码是响应客户端的 Upgrade (en-US) 请求头发送的，指明服务器即将切换的协议。
        102：此代码表示服务器已收到并正在处理该请求，但当前没有响应可用。
        103：此状态代码主要用于与 Link 链接头一起使用，以允许用户代理在服务器准备响应阶段时开始预加载 preloading 资源。
        200：请求成功。成功的含义取决于 HTTP 方法：
            GET: 资源已被提取并在消息正文中传输。
            HEAD: 实体标头位于消息正文中。
            PUT or POST: 描述动作结果的资源在消息体中传输。
            TRACE: 消息正文包含服务器收到的请求消息。
        201：该请求已成功，并因此创建了一个新的资源。这通常是在 POST 请求，或是某些 PUT 请求之后返回的响应。
        202：请求已经接收到，但还未响应，没有结果。意味着不会有一个异步的响应去表明当前请求的结果，预期另外的进程和服务去处理请求，或者批处理。
        203：服务器已成功处理了请求，但返回的实体头部元信息不是在原始服务器上有效的确定集合，而是来自本地或者第三方的拷贝。当前的信息可能是原始版本的子集或者超集。例如，包含资源的元数据可能导致原始服务器知道元信息的超集。使用此状态码不是必须的，而且只有在响应不使用此状态码便会返回200 OK的情况下才是合适的。
        204：对于该请求没有的内容可发送，但头部字段可能有用。用户代理可能会用此时请求头部信息来更新原来资源的头部缓存字段。
        205：告诉用户代理重置发送此请求的文档。
        206：当从客户端发送Range范围标头以只请求资源的一部分时，将使用此响应代码。
        207：对于多个状态代码都可能合适的情况，传输有关多个资源的信息。
        208：在 DAV 里面使用 <dav:propstat> 响应元素以避免重复枚举多个绑定的内部成员到同一个集合。
        226：服务器已经完成了对资源的GET请求，并且响应是对当前实例应用的一个或多个实例操作结果的
        300：请求拥有多个可能的响应。用户代理或者用户应当从中选择一个。（没有标准化的方法来选择其中一个响应，但是建议使用指向可能性的 HTML 链接，以便用户可以选择。）
        301：请求资源的 URL 已永久更改。在响应中给出了新的 URL。
        302：此响应代码表示所请求资源的 URI 已 暂时 更改。未来可能会对 URI 进行进一步的改变。因此，客户机应该在将来的请求中使用这个相同的 URI。
        303：服务器发送此响应，以指示客户端通过一个 GET 请求在另一个 URI 中获取所请求的资源。

        304 Not Modified
        这是用于缓存的目的。它告诉客户端响应还没有被修改，因此客户端可以继续使用相同的缓存版本的响应。

        305 Use Proxy 已弃用
        在 HTTP 规范中定义，以指示请求的响应必须被代理访问。由于对代理的带内配置的安全考虑，它已被弃用。

        306 unused
        此响应代码不再使用；它只是保留。它曾在 HTTP/1.1 规范的早期版本中使用过。

        307 Temporary Redirect
        服务器发送此响应，以指示客户端使用在前一个请求中使用的相同方法在另一个 URI 上获取所请求的资源。这与 302 Found HTTP 响应代码具有相同的语义，但用户代理 不能 更改所使用的 HTTP 方法：如果在第一个请求中使用了 POST，则在第二个请求中必须使用 POST

        308 Permanent Redirect
        这意味着资源现在永久位于由Location: HTTP Response 标头指定的另一个 URI。这与 301 Moved Permanently HTTP 响应代码具有相同的语义，但用户代理不能更改所使用的 HTTP 方法：如果在第一个请求中使用 POST，则必须在第二个请求中使用 POST。

        客户端错误响应
        400 Bad Request
        由于被认为是客户端错误（例如，错误的请求语法、无效的请求消息帧或欺骗性的请求路由），服务器无法或不会处理请求。

        401 Unauthorized
        虽然 HTTP 标准指定了"unauthorized"，但从语义上来说，这个响应意味着"unauthenticated"。也就是说，客户端必须对自身进行身份验证才能获得请求的响应。

        402 Payment Required 实验性
        此响应代码保留供将来使用。创建此代码的最初目的是将其用于数字支付系统，但是此状态代码很少使用，并且不存在标准约定。

        403 Forbidden
        客户端没有访问内容的权限；也就是说，它是未经授权的，因此服务器拒绝提供请求的资源。与 401 Unauthorized 不同，服务器知道客户端的身份。

        404 Not Found
        服务器找不到请求的资源。在浏览器中，这意味着无法识别 URL。在 API 中，这也可能意味着端点有效，但资源本身不存在。服务器也可以发送此响应，而不是 403 Forbidden，以向未经授权的客户端隐藏资源的存在。这个响应代码可能是最广为人知的，因为它经常出现在网络上。

        405 Method Not Allowed
        服务器知道请求方法，但目标资源不支持该方法。例如，API 可能不允许调用DELETE来删除资源。

        406 Not Acceptable
        当 web 服务器在执行服务端驱动型内容协商机制后，没有发现任何符合用户代理给定标准的内容时，就会发送此响应。

        407 Proxy Authentication Required
        类似于 401 Unauthorized 但是认证需要由代理完成。

        408 Request Timeout
        此响应由一些服务器在空闲连接上发送，即使客户端之前没有任何请求。这意味着服务器想关闭这个未使用的连接。由于一些浏览器，如 Chrome、Firefox 27+ 或 IE9，使用 HTTP 预连接机制来加速冲浪，所以这种响应被使用得更多。还要注意的是，有些服务器只是关闭了连接而没有发送此消息。

        409 Conflict
        当请求与服务器的当前状态冲突时，将发送此响应。

        410 Gone
        当请求的内容已从服务器中永久删除且没有转发地址时，将发送此响应。客户端需要删除缓存和指向资源的链接。HTTP 规范打算将此状态代码用于“有限时间的促销服务”。API 不应被迫指出已使用此状态代码删除的资源。

        411 Length Required
        服务端拒绝该请求因为 Content-Length 头部字段未定义但是服务端需要它。

        412 Precondition Failed
        客户端在其头文件中指出了服务器不满足的先决条件。

        413 Payload Too Large
        请求实体大于服务器定义的限制。服务器可能会关闭连接，或在标头字段后返回重试 Retry-After。

        414 URI Too Long
        客户端请求的 URI 比服务器愿意接收的长度长。

        415 Unsupported Media Type
        服务器不支持请求数据的媒体格式，因此服务器拒绝请求。

        416 Range Not Satisfiable
        无法满足请求中 Range 标头字段指定的范围。该范围可能超出了目标 URI 数据的大小。

        417 Expectation Failed
        此响应代码表示服务器无法满足 Expect 请求标头字段所指示的期望。

        418 I'm a teapot
        服务端拒绝用茶壶煮咖啡。笑话，典故来源茶壶冲泡咖啡

        421 Misdirected Request (en-US)
        请求被定向到无法生成响应的服务器。这可以由未配置为针对请求 URI 中包含的方案和权限组合生成响应的服务器发送。

        422 Unprocessable Entity (WebDAV)
        请求格式正确，但由于语义错误而无法遵循。

        423 Locked (en-US) (WebDAV)
        正在访问的资源已锁定。

        424 Failed Dependency (en-US) (WebDAV)
        由于前一个请求失败，请求失败。

        425 Too Early 实验性
        表示服务器不愿意冒险处理可能被重播的请求。

        426 Upgrade Required
        服务器拒绝使用当前协议执行请求，但在客户端升级到其他协议后可能愿意这样做。 服务端发送带有Upgrade (en-US) 字段的 426 响应 来表明它所需的协议（们）。

        428 Precondition Required
        源服务器要求请求是有条件的。此响应旨在防止'丢失更新'问题，即当第三方修改服务器上的状态时，客户端 GET 获取资源的状态，对其进行修改并将其 PUT 放回服务器，从而导致冲突。

        429 Too Many Requests
        用户在给定的时间内发送了太多请求（"限制请求速率"）

        431 Request Header Fields Too Large
        服务器不愿意处理请求，因为其头字段太大。在减小请求头字段的大小后，可以重新提交请求。

        451 Unavailable For Legal Reasons
        用户代理请求了无法合法提供的资源，例如政府审查的网页。

        服务端错误响应
        500 Internal Server Error
        服务器遇到了不知道如何处理的情况。

        501 Not Implemented
        服务器不支持请求方法，因此无法处理。服务器需要支持的唯二方法（因此不能返回此代码）是 GET and HEAD.

        502 Bad Gateway
        此错误响应表明服务器作为网关需要得到一个处理这个请求的响应，但是得到一个错误的响应。

        503 Service Unavailable
        服务器没有准备好处理请求。常见原因是服务器因维护或重载而停机。请注意，与此响应一起，应发送解释问题的用户友好页面。这个响应应该用于临时条件和如果可能的话，HTTP 标头 Retry-After 字段应该包含恢复服务之前的估计时间。网站管理员还必须注意与此响应一起发送的与缓存相关的标头，因为这些临时条件响应通常不应被缓存。

        504 Gateway Timeout
        当服务器充当网关且无法及时获得响应时，会给出此错误响应。

        505 HTTP Version Not Supported
        服务器不支持请求中使用的 HTTP 版本。

        506 Variant Also Negotiates
        服务器存在内部配置错误：所选的变体资源被配置为参与透明内容协商本身，因此不是协商过程中的适当终点。

        507 Insufficient Storage (WebDAV)
        无法在资源上执行该方法，因为服务器无法存储成功完成请求所需的表示。

        508 Loop Detected (WebDAV)
        服务器在处理请求时检测到无限循环。

        510 Not Extended
        服务器需要对请求进行进一步扩展才能完成请求。

        511 Network Authentication Required
        指示客户端需要进行身份验证才能获得网络访问权限。

    Tomcat文件目录
        bin：可执行文件（启动文件startup.bat、关闭文件shutdown.bat）
        conf：配置文件（修改端口号：server.xml，建议将server.xml备份）
        lib：依赖的jar包
        log：日志文件（记录出错等信息）
        temp：临时文件
        webapps：可执行的项目。默认作为存放开发项目的目录
        work：存放由jsp翻译成的.java源文件,以及编译的.class字节码文件(jsp ->java ->class)
    启动Tomcat
        方法一：在apache-tomcat-9.0.43/bin目录下，双击startup.bat打开窗口，双击shutdown.bat关闭窗口
        方法二：通过命令行窗口打开。cmd命令cd到 apache-tomcat-9.0.43/bin，然后输入命令：startup，出现对话框，表明服务启动成功

    常见问题
        1.闪退
        可能原因是：环境变量配置不正确
        JAVA_HOME中的路径不能用分号结尾，如C:rogram Files/Java/jdk1.8.0_121
        JAVA_HOME的路径是JDK路径，而不是JRE的路径。
        CATALINA_HOME中的路径不能以/结尾。
        在环境变量中修改添加变量时，一定要注意分号、空格，是否有多余的字母。
        2. 乱码
        问题描述：打开startup.bat后汉字乱码
        解决方法：在apache-tomcat-9.0.43/conf下打开logging.properties文件
        将java.util.logging.ConsoleHandler.encoding = UTF-8
        替换为java.util.logging.ConsoleHandler.encoding = GBK
        3. 与其他服务的端口号冲突
        tomcat端口号默认8080，如果和其他服务的端口号冲突，则可对端口号进行修改
        在apache-tomcat-9.0.43/conf下打开server.xml文件，在文件的69行左右，将port="8080"修改为指定的某一端口号，重新启动。

    Tomcat 部署项目：
        将项目放到webapps目录下 即部署完成 案例：Tomcat的安装目录下有 webapps/docs/index.html文件
        在浏览器端输入http://127.0.0.1:8080/docs/index.html 就可以了

    SpringBoot 已经内置了Tomcat
        DispatcherServlet 实现了Servlet接口 处理HTTP请求和响应
        HttpServletRequest 获取请求数据的对象
        HttpServletResponse 设置请求响应的对象

    //处理资源路径为/hello的http请求 整个请求对象作为参数
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

    //处理资源路径为/hello的http请求 具体的请求参数作为参数
    @RequestMapping(value = "/hello2")
    public String httpRe2(String name,Integer age){
        return name+":"+age;
    }

    //处理资源路径为/hello的http请求 具体的请求参数作为参数 加了形参注解 形参的名字就不必和请求参数完全一致
    @RequestMapping(value = "/hello3")
    public String httpRe3(@RequestParam(name = "name",required = false)String myname, Integer age){
        return myname+":"+age;
    }


    //处理资源路径为/hello的http请求 具体的请求参数封装到一个类里面 将类作为形参
    http://127.0.0.1:8080/hello4?name=李彦伟&age=32&test=789&addr.province=山西&addr.city=柳林&name=myl
    @RequestMapping(value = "/hello4")
    public String httpRe4(User user){
        return user.toString();
    }
    原理：请求根据自己的参数先去调用形参的get参数方法 如果有返回值再调用set参数方法
    结果：User{name = [李彦伟, myl], age = 32, addr = Addr{province = 山西, city = 柳林}}
    控制台输出：
        空参构造
        [liyanwei]
        获取age
        设置age:32
        获取name
        设置name:[李彦伟,myl]
        获取test
        设置test:789
    public class User {
        private String[] name= {"liyanwei"};
        private int age;
        private Addr addr;}
    public class Addr {
        private String province;
        private String city;}

    //处理资源路径为/hello的http请求 传递日期格式的形参
    @RequestMapping(value = "/hello5")
    public String httpRe5( @RequestParam(name = "dateTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")LocalDateTime time){
        return time.toString();
    }

    //类上加了@RestController注解等于加了@Controller @ResponseBody 两个注解
    //所有方法的返回值如果是字符串直接将字符串作为响应体返回 如果是对象 就将对象封装为JSON对象返回
    //返回值是JSON对象的案例：
    //如果前端跨域异步请求数据 需要在方法上添加注解 @CrossOrigin 取消CORS跨域验证
    HTTP请求格式
        GET /json HTTP/1.1
        User-Agent: PostmanRuntime/7.32.3
        Accept: */*
        Postman-Token: 6dc63d5f-297d-4fd9-b2a1-c3d6db9f0e3e
        Host: 127.0.0.1:8080
        Accept-Encoding: gzip, deflate, br
        Connection: keep-alive
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
    HTTP响应格式
        HTTP/1.1 200 OK
        Content-Type: application/json
        Transfer-Encoding: chunked
        Date: Sun, 25 Jun 2023 09:52:20 GMT
        Keep-Alive: timeout=60
        Connection: keep-alive

        {"name":"李彦伟","age":19,"addr":{"province":"山西","city":"柳林"},"test":"123"}

    //返回值是字符串对象的案例：
    HTTP请求格式
        GET /json HTTP/1.1
        User-Agent: PostmanRuntime/7.32.3
        Accept: */*
        Postman-Token: 98bb3ddc-b7f3-4754-b04a-eab0f5f9c602
        Host: 127.0.0.1:8080
        Accept-Encoding: gzip, deflate, br
        Connection: keep-alive
    //类上加了@RestController注解等于加了@Controller @ResponseBody 两个注解
    //所有方法的返回值如果是字符串直接将字符串作为响应体返回 如果是对象 就将对象封装为JSON对象返回
    @RequestMapping(value = "/json")
    public String httpRe8(HttpServletRequest request){
        User u=new User();
        u.setAge(19);
        u.setName("李彦伟");
        u.setAddr(new Addr("山西","柳林"));
        System.out.println(u);
        return u.toString();
    }
    HTTP响应格式
        HTTP/1.1 200 OK
        Content-Type: text/plain;charset=UTF-8
        Content-Length: 79
        Date: Sun, 25 Jun 2023 10:01:40 GMT
        Keep-Alive: timeout=60
        Connection: keep-alive

        User{name = 李彦伟, age = 19, addr = Addr{province = 山西, city = 柳林}}
