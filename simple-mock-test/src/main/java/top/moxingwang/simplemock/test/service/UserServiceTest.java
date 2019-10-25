package top.moxingwang.simplemock.test.service;

import com.alibaba.fastjson.JSON;
import top.moxingwang.simplemock.core.SimpleMockConstant;
import top.moxingwang.simplemock.core.api.MockApi;

import java.util.HashMap;
import java.util.Map;

public class UserServiceTest {
    public static void main(String[] args) {
//        Map<String, String> s = new HashMap<>();
//        s.put("hahahhaha", "fsdfsdfsd");
//        System.out.println(JSON.toJSONString(s));
        System.getProperties().setProperty(SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL, "http://localhost:8080/simple-mock/mock/string/");

//        MockApi.httpGet("http://localhost:8080/simple-mock/mock/string/java.lang.reflect.Method.userInfo");
        UserService userService = new UserService();
        System.out.println("执行结果：" + JSON.toJSONString(userService.userInfo()));
    }
}
