package top.moxingwang.simplemock.test.service;


import com.chinaredstar.ordercenter.api.common.OrderResult;
import top.moxingwang.simplemock.core.annotation.SimpleMock;

import java.util.HashMap;
import java.util.Map;

@SimpleMock
public class UserService {

    public Map<String, String> ObjectMethodAdapter() {
        System.out.println("服务未被mock");

        Map<String, String> testMap = new HashMap<>();
        testMap.put("UserService", "UserService测试返回");

        return testMap;
    }

    public void VoidMethodAdapter() {
        System.out.println("服务未被mock");
    }

    public String StringMethodAdapter() {
        System.out.println("服务未被mock");
        return "OK";
    }

    public OrderResult OrderResult() {
        System.out.println("服务未被mock");
        return OrderResult.newSuccess();
    }

    public int testInt() {
        System.out.println("服务未被mock");
        return 1;
    }

    public Integer testInteger() {
        System.out.println("服务未被mock");
        return 100;
    }

}
