package top.moxingwang.simplemock.core.api;

import com.alibaba.fastjson.JSON;
import top.moxingwang.simplemock.core.SimpleMockConstant;
import top.moxingwang.simplemock.core.dto.MethodSpiResponseDTO;
import top.moxingwang.simplemock.core.dto.MockDataDTO;

import java.lang.reflect.Method;

public final class MockApi {

    /**
     * @param stackTraceElement
     * @return
     */
    public static MethodSpiResponseDTO getMockData(StackTraceElement stackTraceElement) {
        System.out.println("调用到mock");
        MethodSpiResponseDTO responseDTO = new MethodSpiResponseDTO(false);
        try {
            if (null == System.getProperty(top.moxingwang.simplemock.core.SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL)) {
                responseDTO.setMocked(false);
                return responseDTO;
            }
            Class cl = Class.forName(stackTraceElement.getClassName());
            for (Method method : cl.getMethods()) {
                if (method.getName().equals(stackTraceElement.getMethodName())) {
                    responseDTO.setMethodReturnClass(method.getReturnType());
                    responseDTO.setPrimitive(method.getReturnType().isPrimitive());


                    responseDTO.getMethodReturnClass().isPrimitive();

                    //调用mock server
                    String mockUrl = System.getProperty(SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL) + method.getClass().getName() + "." + method.getName();
                    String responseStr = org.apache.http.util.EntityUtils.toString(org.apache.http.impl.client.HttpClients.createDefault().execute(new org.apache.http.client.methods.HttpGet(mockUrl)).getEntity(), "UTF-8");

                    MockDataDTO mockDataDTO = JSON.parseObject(responseStr, MockDataDTO.class);

                    responseDTO.setMocked(true);
                    responseDTO.setResponse(mockDataDTO.getBody());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseDTO;
    }

}
