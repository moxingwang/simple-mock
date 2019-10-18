package top.moxingwang.simplemock.test.service;


import top.moxingwang.simplemock.core.annotation.SimpleMock;

import java.util.Map;

@SimpleMock
public class UserService {
    public Map<String,String> userInfo() {
        System.out.println("user info method------------------");
        return null;
    }
}
