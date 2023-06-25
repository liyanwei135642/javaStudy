"""

下载安装Maven: https://maven.apache.org/download.cgi 点击download 下载binary...zip稳定版本
解压到自定义的路径
配置本地仓库

再配置阿里云私服
<mirror>
    <id>alimaven</id>
    <name>aliyun maven</name>
    <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
    <mirrorOf>central</mirrorOf>
</mirror>

Maven 依赖管理：
    依赖配置：我们添加一个logback的依赖 groupId:组织名称 artifactId:模块名称 version:版本号
        <dependencies>
            <dependency>
                <groupId>ch.qos.logback</groupId>
                <artifactId>logback-classic</artifactId>
                <version>1.2.3</version>
                <!--     依赖的生命周期    不加scope标签默认全局范围可用 main test package  scope标签为test表示只能在test范围使用  -->
                <scope>test</scope>
                <!--   排除不想要的依赖         -->
                <exclusions>
                    <exclusion>
                        <groupId>org.slf4j</groupId>
                        <artifactId>slf4j-api</artifactId>
                    </exclusion>
                    <!--  可以排除多个不需要的依赖 这里只展示一个 -->
                </exclusions>
            </dependency>
        </dependencies>
        如果是第一次添加某个依赖可能没有提示 可以去 mvnrespository.com 网站搜索需要的依赖
    运行maven 的各组插件 clean compile test package install
    可以直接双击也可以 命令行运行 mvn command
    如果命令行无法找到mvn 可能是环境变量没有配置 也可能是配置的系统环境变量 用户找不到 需要在配置用户级别的环境变量


"""