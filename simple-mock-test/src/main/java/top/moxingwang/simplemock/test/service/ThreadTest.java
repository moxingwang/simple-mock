package top.moxingwang.simplemock.test.service;

import top.moxingwang.simplemock.core.api.MockApi;
import top.moxingwang.simplemock.core.dto.MethodSpiResponseDTO;

import java.util.Map;

public class ThreadTest {

    //Object
    public Map<String, String> getInfo() {
        MethodSpiResponseDTO mockResponse = MockApi.getMockData(Thread.currentThread().getStackTrace()[1]);
        if (mockResponse.isMocked()) {
            return mockResponse.getObject(mockResponse);
        }

        return null;
    }


}
