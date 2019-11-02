# Simple-mock: 让MOCK变得更简单

## Introduction

基于ASM实现Java method mock，实现任意Java方法在线Mock

# Quick Start

- mvn clean package 
- -javaagent:simple-mock-agent/target/simple-mock-agent-1.0-SNAPSHOT.jar


# Plan

### 第一阶段
    - mock client
        - mock参数基于静态config对象配置
    - mock server
        - 数据存储采用内存存储
        - mock server区分app
        - 页面手动输入mock json
    
### 第二阶段
    - mock client
        - mock参数支持jvm参数配置
        - mock参数支持动态修改
    - mock server
        - 数据存储支持文件存储
        - 

### 第三阶段
    - mock client
        - mock参数接入配置中心
    - mock server
        - 数据存储支持MySQL存储
        - 页面支持动态加载jar

### 第四阶段
    - mock client
        - 启动Netty和服务通信
        - mock client自动汇报方法签名
        - mock client支持内存存储数据减少和server的通信
    - mock server
        - mock server支持推送服务mock
        - mock server和client实现心跳
        - mock server mock数据直接放到client内存

# reference
- [如何利用 ASM 实现既有方法的增强？](https://zhuanlan.zhihu.com/p/71762514)
- [JVM插码之五：Java agent+ASM实战--监控所有方法执行时间](https://www.cnblogs.com/duanxz/p/6090190.html)
- [Understanding how to use visitFrame](https://stackoverflow.com/questions/20391272/understanding-how-to-usevisitframe)
- [字节码及ASM使用](https://segmentfault.com/a/1190000009956534)
- [Nov 10, 2018 - Java 动态字节码技术 - 对 Debug 的好奇](https://zhenbianshu.github.io/2018/11/control_jvm_byte_code.html)
- [深入理解 RPC 之序列化篇 -- 总结篇](https://www.cnkirito.moe/rpc-serialize-2/)
- [Java Class文件格式access_flags 描述的是当前类（或者接口）的访问修饰符](https://blog.csdn.net/u014490683/article/details/22745799)
 
