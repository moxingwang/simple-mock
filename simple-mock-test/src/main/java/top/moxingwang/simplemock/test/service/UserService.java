package top.moxingwang.simplemock.test.service;


import top.moxingwang.simplemock.core.annotation.SimpleMock;

import java.util.HashMap;
import java.util.Map;

@SimpleMock
public class UserService {

    public Map<String, String> userInfo() {
        System.out.println("user info method------------------");

        Map<String, String> testMap = new HashMap<>();
        testMap.put("UserService", "UserService测试返回");

        return testMap;
    }

    public Map<String, String> userInfo1() {
        System.out.println("user info method-111111111111-----------------");
        return null;
    }
}
