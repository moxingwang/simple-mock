package top.moxingwang.simplemock.test.mock;

import com.chinaredstar.ordercenter.api.common.OrderResult;
import com.chinaredstar.ordercenter.dto.common.message.ParticipleWordMessageDTO;
import com.chinaredstar.ordercenter.module.order.Order;
import top.moxingwang.simplemock.core.annotation.SimpleMock;

/**
 * @description:
 * @author: MoXingwang 2019-07-02 17:28
 **/
@SimpleMock
public class CommonMessageService {


    public void sendParticipleWord(ParticipleWordMessageDTO participleWordDTO) {
        return;
    }

    public OrderResult<Order> getOrderResult(){
        OrderResult orderResult = OrderResult.newSuccess();

        orderResult.setMessage("服务未被mock");

        Order order = new Order();
        order.setSerialNumber("rsddsdsds");
        order.setMarketId("21312");
        order.setMarketName("21312");
        orderResult.setDataMap(order);
        return orderResult;
    }
}
