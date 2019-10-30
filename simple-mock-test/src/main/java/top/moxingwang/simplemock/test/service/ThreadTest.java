package top.moxingwang.simplemock.test.service;

import top.moxingwang.simplemock.core.api.MockApi;
import top.moxingwang.simplemock.core.dto.MethodSpiResponseDTO;

import java.util.HashMap;
import java.util.Map;

public class ThreadTest {

    //ObjectMethodAdapter
    public Map<String, String> ObjectMethodAdapter() {
        MethodSpiResponseDTO mockResponse = MockApi.getMockData(Thread.currentThread().getStackTrace()[1]);
        if (mockResponse.isMocked()) {
            return mockResponse.getObject(mockResponse);
        }


        System.out.println("AAAAAAAAAA");
        return new HashMap<>();
    }

    public void VoidMethodAdapter() {
        MethodSpiResponseDTO mockResponse = MockApi.getMockData(Thread.currentThread().getStackTrace()[1]);
        if (mockResponse.isMocked()) {
            return;
        }


        System.out.println("AAAAAAAAAA");
        return;
    }

}
