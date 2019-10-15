package top.moxingwang.simplemock.test.service;


import top.moxingwang.simplemock.core.annotation.SimpleMock;

@SimpleMock("hahahahhah")
public class UserService {
    public String userInfo() {
        System.out.println("user info method------------------");
        return "OK";
    }
}
