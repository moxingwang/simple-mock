package top.moxingwang.simplemock.server.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.moxingwang.simplemock.core.dto.MockDataDTO;

@RestController
@RequestMapping("/mock")
public class MockController {

    @GetMapping("/string/{methodName}")
    public String mock(@PathVariable(value = "methodName") String methodName) {

        System.out.println("mock 服务被调用到");
      /*  String content = "{\n" +
                "  \"afterSaleStatus\": 0,\n" +
                "  \"agreedDeliveryDate\": 1571068800000,\n" +
                "  \"canRefund\": 1,\n" +
                "  \"channel\": 2,\n" +
                "  \"client\": 1,\n" +
                "  \"createDate\": 1571112219000,\n" +
                "  \"createUserId\": \"a156f3b1-0446-46e1-b003-31976374ca3d\",\n" +
                "  \"deleteFlag\": 0,\n" +
                "  \"deliverType\": 3,\n" +
                "  \"extendStatus\": 11,\n" +
                "  \"extendType\": 0,\n" +
                "  \"id\": \"8004530\",\n" +
                "  \"isStage\": 0,\n" +
                "  \"marketId\": \"1001\",\n" +
                "  \"mobile\": \"13917111243\",\n" +
                "  \"orderStatus\": 1,\n" +
                "  \"orderType\": 8,\n" +
                "  \"paidAmount\": \"0.00\",\n" +
                "  \"payableAmount\": \"1600.00\",\n" +
                "  \"plantform\": 8,\n" +
                "  \"promotionTotalAmount\": \"0.00\",\n" +
                "  \"purchaserId\": \"a9ca6cd6-06c6-4fd2-8225-96c68e3dfa5d\",\n" +
                "  \"receiverMobile\": \"13917111243\",\n" +
                "  \"serialNumber\": \"TS216792016870\",\n" +
                "  \"settlementStatus\": 1,\n" +
                "  \"shopId\": \"148632\",\n" +
                "  \"totalAmount\": \"1600.00\"\n" +
                "}";*/

        String content = "{\"@type\":\"com.chinaredstar.ordercenter.api.common.OrderResult\",\"code\":\"200\",\"dataMap\":{\"@type\":\"com.chinaredstar.ordercenter.module.order.Order\",\"coupons\":[],\"invoiceInfos\":[],\"isAdditionReview\":false,\"itemPromotions\":[],\"orderItem\":{\"itemAttributes\":[]},\"orderItems\":[],\"orderStatusVersions\":[],\"payableAmount\":1111110,\"paymentLines\":[],\"priceDefferenceOrders\":[],\"promOrders\":[],\"promotions\":[],\"refoundOrders\":[],\"serialNumber\":\"323232\",\"workers\":[]},\"message\":\"Success\",\"success\":true}";

        MockDataDTO mockDataDTO = new MockDataDTO();
        mockDataDTO.setType(1);
        mockDataDTO.setBody(content);
        return JSON.toJSONString(methodName);
    }

}
