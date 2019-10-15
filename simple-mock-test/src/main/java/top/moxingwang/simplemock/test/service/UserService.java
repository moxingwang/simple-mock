package top.moxingwang.simplemock.test.service;


import top.moxingwang.simplemock.core.annotation.SimpleMock;

@SimpleMock
public class UserService {
    public String userInfo() {
        System.out.println("user info method------------------");
        return "OK";
    }
}
