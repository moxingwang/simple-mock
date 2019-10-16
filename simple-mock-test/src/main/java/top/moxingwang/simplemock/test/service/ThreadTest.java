package top.moxingwang.simplemock.test.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import top.moxingwang.simplemock.core.SimpleMockConstant;
import top.moxingwang.simplemock.core.dto.MethodSpiResponseDTO;

import java.lang.reflect.Method;
import java.util.Map;

public class ThreadTest {
    public static void main(String[] args) {
        System.getProperties().setProperty(SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL, "http://localhost:8080/simple-mock/mock/string/");
        System.out.println("结果" + JSON.toJSONString(new ThreadTest().getInfo()));
    }

    public Map<String, String> getInfo() {
        MethodSpiResponseDTO mockResponse = mock(Thread.currentThread().getStackTrace()[1]);
        if (2 == mockResponse.getType()) {
            return JSONObject.parseObject(mockResponse.getResponse().toString().getBytes(), mockResponse.getMethodReturnClass());
        }


        System.out.println(1);
        return null;
    }

    public MethodSpiResponseDTO mock(StackTraceElement stackTraceElement) {
        MethodSpiResponseDTO responseDTO = new MethodSpiResponseDTO(0);
        try {
            Class cl = Class.forName(stackTraceElement.getClassName());
            for (Method method : cl.getMethods()) {
                //调用mock server

                if (method.getName().equals(stackTraceElement.getMethodName())) {
                    String mockUrl = System.getProperty(top.moxingwang.simplemock.core.SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL) + method.getClass().getName() + "." + method.getName();
                    String str = org.apache.http.util.EntityUtils.toString(org.apache.http.impl.client.HttpClients.createDefault().execute(new org.apache.http.client.methods.HttpGet(mockUrl)).getEntity(), "UTF-8");


                    String returnMethodName = method.getReturnType().getName();
                    if ("void".equals(returnMethodName)) {
                        responseDTO.setType(1);
                        return responseDTO;
                    }
                    if (String.class.getName().equals(returnMethodName)) {
                        responseDTO.setType(2);
                        responseDTO.setMethodReturnClass(String.class);
                        responseDTO.setResponse(str);
                        return responseDTO;
                    }

                    responseDTO.setType(2);

                    responseDTO.setMethodReturnClass(method.getReturnType());
                    responseDTO.setResponse(str);
                    return responseDTO;
                }
            }
            System.out.println(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseDTO;
    }
}
