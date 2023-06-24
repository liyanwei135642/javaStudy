// js 弹框函数 alert("弹框信息")
// alert("我是外部弹框！");
// 将字符串转化为数字类型
// alert(parseInt("456bvv"));//456
// alert(parseInt("a456bvv"));//NAN not a number
// 将其他类型转化为布尔类型
// 将数字转化为布尔 0 和 NAN 转化为false 其他都是true
// 将字符串转化为布尔 除了空字符串 其他都是true
// null 和 undefined 都是false
// alert(typeof 3.1415);//弹窗
// console.log("65487456")//控制台输出
//结尾的分号可有可无
// 用 var 关键字申明变量
// var name="liyanwei"; //页面局部变量
// sex="man"; //全局变量
// var a1=a2=a3=0;
// var b1,b2,b3;
// c1=4,c2=5;
//定义常量用关键字 const
// const PI=3.1415926;
// 数字.toFixed(n) 保留小数点后n位。
// pi=PI.toFixed(3);
// 八进制以0开头
// pi=3.1415926;
// var num=021; //十进制等于17
// 科学计数法
// var num2=1.36e4;//等于13600
// 布尔类型
// var bool_1=true,bool_2=false;
//  申明了未定义的变量就是undefined;
//  null 空类型
// var strName=null;
// typeof() 获取变量的类型
// typename=typeof(strName);
// 转换为字符串类型
// c="456.369";
// c=c.toString()
// 转换为数字类型
// b="123.3654";
// b=Number(b);
// alert(c);
// a='Aasas';
// b='a';
// a.charCodeAt(1) 返回"Aasas"字符串第二位字符的阿斯克码值
// console.log(b.charCodeAt(0));
// a="-596.365";
// a=Number(a);//如果a不是数字则返回NaN
// b=isNaN(a)?false:true;
// console.log(b);
// 函数学习：


// function mytest1()
// {
//     a="-596.365";
//     a=Number(a);//如果a不是数字则返回NaN
//     b=isNaN(a)?false:true;
//     console.log(b);
// }
// function mytest2(id)
// {
//     a=document.getElementById(id);
//     if(a.style.display=="")
//     {
//         a.style.display="none";
//     }
//     else
//     {
//         a.style.display="";
//     }
//     console.log(a.style.display)
// }


// js当下主流的定义函数方法：
// myFunction={
//     f1:function(a,b){
//         return a+b;
//     },
//     f2:function(a,b){
//         return a*b
//     }
// }
// 普通定义函数方法：
// function f1(a,b)
// {
//     return a+b;
// }
// function f2(a,b)
// {
//     return a*b;
// }
// 定义匿名函数
// a=function(a,b){
//     return a+b;
// };
// console.log(a(23,56));
// a=(function(a,b){
//     return a+b;
// })(5,9);
// console.log(a);
// 数组定义
//arr=[[1,3,6],[5,9,7],[23,56,89,"89"]];
// length 数组的长度属性可读可写
// push(data) 尾插元素 逗号隔开
// pop() 尾删元素 返回被删除元素
// unshift(data) 头插元素 逗号隔开
// shift() 头删元素 返回被删除元素
// toString() 返回字符串类型
// join(char) 返回字符串类型 用char分割
// sort() 排序 默认升序 改变原数组 返回排序数组
// reverse() 反序 改变原数组 返回反序数组
// arr=[];
// for (let i = 0; i < 10; i++) {
//     arr.push(i,i*5,"789"+i);
// }
// arr.forEach(function(e){
//     console.log(e)
// });
// for(i=0;i<arr.length;i++){
//     console.log(arr[i]);
// }
// console.log(arr.pop());
// for(i=0;i<10;i++)
// {
//     arr.unshift(i*3);
//     console.log(arr[0]);
// }
// console.log(arr.shift());
//console.log(arr.toString());
// console.log(arr.join("我"));
// a=arr.reverse();


// 字符串
// toUpperCase()转大写字母 不改变原字符串
// toLowerCase()转小写字母 不改变原字符串
// charAt(index)获取指定位置的字符 不改变原字符串
// charCodeAt(index)获取指定位置的字符编码 不改变原字符串
// indexOf(char,index)获取指定字符的第一个下标 从指定下标开始找 不改变原字符串
// lastIndexOf(char,index)获取指定字符的倒数第一个下标 从指定下标开始找 不改变原字符串
// substring(startindex,endindex)截取字符串  不改变原字符串
// substr(startindex,len) 从指定位置截取指定长度的字符串
// split(str)用指定的字符串分割字符串，返回分割后的字符串数组
// trim()去除开头结尾空格，返回分割后的字符串数组
// str="  456789   ";
// console.log(str);
// str=str.trim();
// console.log(str);


//自定义JSON对象
// var jsObject={  name:"liyanwei",
//                 age:32,
//                 addr:["北京","上海"],
//                 func:function(){alert("456");return 69}
//             }

//alert(jsObject.name);




//将JSON对象转化为JSON字符串 这个方法只能转化属性 不能转化方法
//str=JSON.stringify(jsObject);
//alert(str)
//将JSON字符串格式转化为JSON对象 
//obj=JSON.parse(str);
// obj={"aaa":456,as:"789"}
// alert(JSON.stringify(obj));

// 正则表达式
// 语法：
// var reg1=/...../ig; i代表忽略大小写 g代表在全局范围匹配，找到一处匹配后下次匹配从上次的lastindex索引开始匹配
// var reg2=new RegExp("匹配模式","修饰符");
// 属性
// lastIndex 可读可写 下一次匹配的起始索引
// 方法：
// test(str) 满足匹配返回true 否则返回false
// 下面两个方法是字符串的方法，用字符串调用下面方法
// str.match(reg) 满足匹配返回满足匹配的正则字符串的数组
// str.replace(reg,newstr) 将满足匹配的字符串替换为新的字符串

// str="abcabcabc123465..?/";
// reg1=/aBc/ig;//定义一个正则表达式
// reg=new RegExp("abc","ig");//第二种方法定义一个正则表达式
// arr=str.match(reg);
// newstr=str.replace(reg,"123 23");

// Math 数学对象
// 属性：
// Math.PI π 3.1415926...
// Math.E 自然对数e
// 方法：
// a=Math.random(); //生成0-1之间的随机数
// b=Math.ceil(-5.2); //向上取整
// c=Math.floor(-5.2); //向下取整
// d=Math.round(-5.51); //四舍五入取整
// a=Math.exp(1); //自然对数的指数函数

// 日期对象Date
// d1=new Date(); //创建当前时间的日期对象
// d2=new Date("2023/04/02 20:40:00"); //用时间创建日期对象
// d3=new Date("2023/2/3");//用日期创建日期对象
// year=d1.getFullYear();//获取年份
// month=d1.getMonth()+1;//获取的月份是从0开始的 要加1
// day=d1.getDate();//获取日
// hour=d1.getHours();//获取时
// minute=d1.getMinutes();//获取分
// second=d1.getSeconds();//获取秒
// time1=d1.getTime();//获取当前日期对象时间戳毫秒数
// time2=d2.getTime();//获取当前日期对象时间戳毫秒数

// BOM 浏览器对象模型 window 关键字
// window.alert("提示窗口：");//弹出提示窗口
// mes=window.prompt("输入窗口：")//弹出输入窗口 确认返回输入信息 取消返回null
// mes=window.confirm("确认窗口：")//确认返回true 取消返回false
// window.open("test2.html")//在浏览器重新打开一个给定地址的页面 会被浏览器拦截 推介使用a标签超级链接
// window.close()//关闭当前网页
// n=0;
// function getTime()
// {
//     d1=new Date();
//     year=d1.getFullYear();//获取年份
//     month=d1.getMonth()+1;//获取的月份是从0开始的 要加1
//     day=d1.getDate();//获取日
//     hour=d1.getHours();//获取时
//     minute=d1.getMinutes();//获取分
//     second=d1.getSeconds();//获取秒
//     time=year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
//     console.log(time);
//     n++;
//     if(n>=10)
//     {
//         clearInterval(timerId);
//     }
// }

// 定时器
//timerId=window.setInterval(getTime,1000)//周期性定时器 第一个参数是定时执行的函数 第二个参数是时间间隔 毫秒为单位
//timerId=window.setTimeout(getTime,10000)//一次性定时器 第一个参数是定时执行的函数 第二个参数是时间间隔 毫秒为单位
// window.clearInterval(timerId)//停止定时器 参数是定时器id

// window 的属性
// history属性 记录当前浏览器访问过得url记录
    // history 的属性 
    // length属性 当前访问过得url的数量
    // history 的方法
    // back() 回退一个访问记录
    // forword() 前进一个访问记录
    // go(n) 前进n个访问记录 n<0时后退
// location属性 当前地址栏对象
    // location 的属性
    // herf属性 当前地址栏的url
    // location 的方法
    // reload(true/false) ture参数强制从根目录加载 false参数从缓存加载
// a=window.location.href;
// window.location.reload(true);


// document 对象的方法
// divs=document.getElementsByTagName("div");//通过标签名获取元素 返回元素列表
// divs=document.getElementsByClassName("a");//通过class属性名获取元素 返回元素列表
// divs=document.getElementById ("div");//通过标签id获取元素 返回元素
// divs=document.getElementsByName("a");//通过name属性名获取元素 返回元素列表

// 元素对象的属性：
// innerText属性可读可写 操作元素内部的文本内容 不能识别html语法
// innerHTML属性可读可写 操作元素内部的文本内容 能识别html语法
// value 可读可写 操作表单控件的值
// 操作元素的属性方法如下：
// element.getAttribute("attrname")//通过属性名来获取属性值
// element.setAttribute("attrname","value")//通过属性名来改变属性值
// element.removeAttribute("attrname")//通过属性名来置空属性值
// 下面的是哪种方法也是操作元素属性的方法 与上面三种等效
// element.attrname="value" 改变属性值
// a=element.attrname 获取属性值
// element.attrname="" 置空属性值

//事件监听
h1=document.getElementById("h1");
// h1.oncopy=()=>{myfunc(56)};
// function myfunc(num){
//     h1.innerHTML+='<h1 style="color: #f00;">'+num+'</h1>';
// }
h1.oncopy=()=>{
    h1.innerHTML='<h1 style="color: #f00;">56</h1>';
}
//onclick 点击事件
//onblur 失去焦点事件
//onfocus 获得焦点事件
//onload 某个页面或者图片被加载完毕事件
//onsubmit 表单被提交事件
//onkeydown 键盘按键被按下事件
//onmouseover 鼠标进入事件
//onmouseout 鼠标离开事件
h1.onmouseover=()=>{
    console.log("鼠标进入");
}
h1.onmouseout=()=>{
    console.log("鼠标离开");
}


