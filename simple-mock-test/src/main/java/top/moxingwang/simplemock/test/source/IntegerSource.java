package top.moxingwang.simplemock.test.source;

import top.moxingwang.simplemock.core.api.MockApi;
import top.moxingwang.simplemock.core.dto.MethodSpiResponseDTO;

public class IntegerSource {


    public int VoidMethodAdapter() {
        MethodSpiResponseDTO mockResponse = MockApi.getMockData(Thread.currentThread().getStackTrace()[1]);
        if (mockResponse.isMocked()) {
            return Integer.valueOf(mockResponse.getResponse()).intValue();
        }


        System.out.println("AAAAAAAAAA");
        return 1 ;
    }

}
