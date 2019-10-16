package top.moxingwang.simplemock.core.api;

import top.moxingwang.simplemock.core.SimpleMockConstant;
import top.moxingwang.simplemock.core.dto.MethodSpiResponseDTO;

import java.lang.reflect.Method;

public class MockApi {

    public static MethodSpiResponseDTO getMockData(StackTraceElement stackTraceElement) {
        MethodSpiResponseDTO responseDTO = new MethodSpiResponseDTO();
        try {
            Class cl = Class.forName(stackTraceElement.getClassName());
            for (Method method : cl.getMethods()) {
                if (method.getName().equals(stackTraceElement.getMethodName())) {
                    //调用mock server
                    String mockUrl = System.getProperty(SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL) + method.getClass().getName() + "." + method.getName();
                    String str = org.apache.http.util.EntityUtils.toString(org.apache.http.impl.client.HttpClients.createDefault().execute(new org.apache.http.client.methods.HttpGet(mockUrl)).getEntity(), "UTF-8");

                    responseDTO.setMethodReturnClass(method.getReturnType());
                    responseDTO.setResponse(str);
                    return responseDTO;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseDTO;
    }
}
