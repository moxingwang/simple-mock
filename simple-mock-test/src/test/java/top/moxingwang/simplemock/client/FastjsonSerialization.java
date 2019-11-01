package top.moxingwang.simplemock.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.chinaredstar.ordercenter.api.common.OrderResult;
import com.chinaredstar.ordercenter.module.order.Order;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FastjsonSerialization {
    static final String charsetName = "UTF-8";

    public byte[] serialize(Object data) throws IOException {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);

        SerializeWriter out = new SerializeWriter();
        JSONSerializer serializer = new JSONSerializer(out);
        serializer.config(SerializerFeature.WriteEnumUsingToString, true);//<1>
        serializer.config(SerializerFeature.WriteClassName, true);//<1>
        serializer.write(data);
        return out.toBytes(charsetName);
    }


    public <T> T deserialize(byte[] data, Class<T> clz) throws IOException {
        return JSON.parseObject(new String(data), clz);
    }

    public static void main(String[] args) throws IOException {
        {
            OrderResult orderResult = OrderResult.newSuccess();
            Order order = new Order();
            order.setSerialNumber("323232");
            order.setPayableAmount(new BigDecimal("1111110"));
            orderResult.setDataMap(order);
            FastjsonSerialization fastjsonSerialization = new FastjsonSerialization();
            byte[] serialize = fastjsonSerialization.serialize(orderResult);
            String s = new String(serialize);
            OrderResult deserialize = fastjsonSerialization.deserialize(s.getBytes(), OrderResult.class);
            System.out.println(1);
        }

        {
            int[] ints = {21,43,45365,65};
            FastjsonSerialization fastjsonSerialization = new FastjsonSerialization();
            byte[] serialize = fastjsonSerialization.serialize(ints);
            String s = new String(serialize);
            int[] deserialize = fastjsonSerialization.deserialize(s.getBytes(), int[].class);
            System.out.println(1);

        }
    }
}
