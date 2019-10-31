package top.moxingwang.simplemock.test.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.chinaredstar.ordercenter.api.common.OrderResult;
import top.moxingwang.simplemock.core.SimpleMockConstant;

public class UserServiceTest {
    public static void main(String[] args) {
        System.getProperties().setProperty(SimpleMockConstant.SIMPLE_MOCK_VM_PACKAGE_NAME, "top/moxingwang/simplemock/test");
        System.getProperties().setProperty(SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL, "http://localhost:8080/simple-mock/mock/string/");
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);


        UserService userService = new UserService();


        {
//            System.out.println("map对象测试:" + JSON.toJSONString(userService.ObjectMethodAdapter()));
        }

        {
//            userService.VoidMethodAdapter();
        }


            System.out.println("String对象测试:"+userService.StringMethodAdapter());;
        OrderResult orderResult = userService.OrderResult();
            System.out.println("OrderResult对象测试:"+userService.OrderResult());;

    }
}
