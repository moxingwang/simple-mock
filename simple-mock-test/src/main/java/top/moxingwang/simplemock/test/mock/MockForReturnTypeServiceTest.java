package top.moxingwang.simplemock.test.mock;

import top.moxingwang.simplemock.core.annotation.SimpleMock;
import top.moxingwang.simplemock.test.config.MockConfig;

import java.util.Map;

@SimpleMock
public class MockForReturnTypeServiceTest {
    public static void main(String[] args) {
        MockConfig.init();
        MockForReturnTypeService mockService = new MockForReturnTypeService();

        Map<String, String> map = mockService.testMap();
        int i = mockService.testInt();

        System.out.println("done");
    }


}
