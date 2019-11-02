package top.moxingwang.simplemock.test.mock;

import com.chinaredstar.ordercenter.api.common.OrderResult;
import com.chinaredstar.ordercenter.dto.common.message.ParticipleWordMessageDTO;
import com.chinaredstar.ordercenter.module.order.Order;
import top.moxingwang.simplemock.core.annotation.SimpleMock;
import top.moxingwang.simplemock.test.config.MockConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SimpleMock
public class MockForReturnTypeService {

    public void testVoid() {
        System.out.println("服务未被mock");
    }
    public Map<String, String> testMap(String ... aa) {
        System.out.println("服务未被mock");

        Map<String, String> testMap = new HashMap<>();
        testMap.put("UserService", "UserService测试返回");
        return testMap;
    }

    public String testString(ParticipleWordMessageDTO participleWordMessageDTO) {
        System.out.println("服务未被mock");
        return "OK";
    }

    public OrderResult<Order> testOrderResult(ParticipleWordMessageDTO participleWordMessageDTO) {
        System.out.println("服务未被mock");
        return OrderResult.newSuccess();
    }


  /*


    public int testInt() {
        System.out.println("服务未被mock");
        return 1;
    }

    public Integer testInteger() {
        System.out.println("服务未被mock");
        return 100;
    }

    public Double testDouble() {
        System.out.println("服务未被mock");
        return new Double("111");
    }

    public double testdouble() {
        System.out.println("服务未被mock");
        return new Double("111");
    }

    public List testArrayList() {
        System.out.println("服务未被mock");
        return new ArrayList();
    }*/

}
