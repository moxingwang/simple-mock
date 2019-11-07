package top.moxingwang.simplemock.test.source;

import com.chinaredstar.ordercenter.api.common.OrderResult;
import com.chinaredstar.ordercenter.dto.common.message.ParticipleWordMessageDTO;
import com.chinaredstar.ordercenter.module.order.Order;
import top.moxingwang.simplemock.core.api.MockApi;
import top.moxingwang.simplemock.core.dto.MethodSpiResponseDTO;

import java.util.HashMap;
import java.util.Map;

public class ObjectSource {

    public OrderResult<Order> createSource( ) {
        MethodSpiResponseDTO mockResponse = MockApi.getMockData(Thread.currentThread().getStackTrace()[1]);
        if (mockResponse.isMocked()) {
            return mockResponse.getObject(mockResponse);
        }


        System.out.println("我在正常执行...");
        return null;
    }


}
