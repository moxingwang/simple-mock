package top.moxingwang.simplemock.test.source;

import top.moxingwang.simplemock.core.api.MockApi;
import top.moxingwang.simplemock.core.dto.MethodSpiResponseDTO;

public class StringSource {


    public String VoidMethodAdapter() {
        MethodSpiResponseDTO mockResponse = MockApi.getMockData(Thread.currentThread().getStackTrace()[1]);
        if (mockResponse.isMocked()) {
            return mockResponse.getResponse();
        }


        System.out.println("AAAAAAAAAA");





        return "OK";
    }

}
