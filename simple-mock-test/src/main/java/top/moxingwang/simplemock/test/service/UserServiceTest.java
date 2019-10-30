package top.moxingwang.simplemock.test.service;

import com.alibaba.fastjson.JSON;
import top.moxingwang.simplemock.core.SimpleMockConstant;

public class UserServiceTest {
    public static void main(String[] args) {
        System.getProperties().setProperty(SimpleMockConstant.SIMPLE_MOCK_VM_PACKAGE_NAME, "top/moxingwang/simplemock/test");
        System.getProperties().setProperty(SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL, "http://localhost:8080/simple-mock/mock/string/");
        UserService userService = new UserService();


        {
            System.out.println("执行结果：" + JSON.toJSONString(userService.ObjectMethodAdapter()));
        }

        {
            userService.VoidMethodAdapter();
        }
    }
}
