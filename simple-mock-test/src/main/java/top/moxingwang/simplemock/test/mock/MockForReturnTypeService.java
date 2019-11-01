package top.moxingwang.simplemock.test.mock;

import com.chinaredstar.ordercenter.api.common.OrderResult;
import top.moxingwang.simplemock.core.annotation.SimpleMock;
import top.moxingwang.simplemock.test.config.MockConfig;

import java.util.HashMap;
import java.util.Map;

@SimpleMock
public class MockForReturnTypeService {
    public static void main(String[] args) {
        MockConfig.init();

        MockForReturnTypeService mockService = new MockForReturnTypeService();
        mockService.testMap();
    }


    public Map<String, String> testMap() {
        System.out.println("服务未被mock");

        Map<String, String> testMap = new HashMap<>();
        testMap.put("UserService", "UserService测试返回");
        return testMap;
    }

    public String testString() {
        System.out.println("服务未被mock");
        return "OK";
    }

    public OrderResult testOrderResult() {
        System.out.println("服务未被mock");
        return OrderResult.newSuccess();
    }

    public void testVoid() {
        System.out.println("服务未被mock");
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
