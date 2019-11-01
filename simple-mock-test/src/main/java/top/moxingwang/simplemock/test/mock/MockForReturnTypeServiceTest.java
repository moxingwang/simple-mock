package top.moxingwang.simplemock.test.mock;

import top.moxingwang.simplemock.core.annotation.SimpleMock;
import top.moxingwang.simplemock.test.config.MockConfig;

@SimpleMock
public class MockForReturnTypeServiceTest {
    public static void main(String[] args) {
        MockConfig.init();
        MockForReturnTypeService mockService = new MockForReturnTypeService();

        mockService.testMap();

    }


}
