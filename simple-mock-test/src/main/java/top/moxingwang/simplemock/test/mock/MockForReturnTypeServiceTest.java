package top.moxingwang.simplemock.test.mock;

import com.chinaredstar.ordercenter.api.common.OrderResult;
import top.moxingwang.simplemock.core.annotation.SimpleMock;
import top.moxingwang.simplemock.test.config.MockConfig;

import java.util.Map;

@SimpleMock
public class MockForReturnTypeServiceTest {
    public static void main(String[] args) {
        MockConfig.init();
        MockForReturnTypeService mockService = new MockForReturnTypeService();

        Map<String, String> map = mockService.testMap();
        OrderResult orderResult = mockService.testOrderResult();
        String s = mockService.testString();
        int i = mockService.testInt();
        mockService.testVoid();
        System.out.println("done");
    }


}
