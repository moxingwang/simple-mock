package top.moxingwang.simplemock.test.service;


import top.moxingwang.simplemock.core.annotation.SimpleMock;

import java.util.Map;

@SimpleMock
public class UserService {
    public Map<String,String> userInfo() {
        System.out.println("user info method------------------");
        return null;
    }

    public Map<String,String> userInfo1() {
        System.out.println("user info method-111111111111-----------------");
        return null;
    }
}
