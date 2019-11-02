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


 
