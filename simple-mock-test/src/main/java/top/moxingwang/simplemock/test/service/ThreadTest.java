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

    //Object
    public Map<String, String> getInfo() {
        if (null != System.getProperty(top.moxingwang.simplemock.core.SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL)) {
            MethodSpiResponseDTO mockResponse = getMockData(Thread.currentThread().getStackTrace()[1]);
            if (null != mockResponse.getResponse()) {
                return JSONObject.parseObject(mockResponse.getResponse().getBytes(), mockResponse.getMethodReturnClass());
            }
        }
        return null;
    }

    //String
    public String getString() {
        if (null != System.getProperty(top.moxingwang.simplemock.core.SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL)) {
            MethodSpiResponseDTO mockResponse = getMockData(Thread.currentThread().getStackTrace()[1]);
            if (null != mockResponse.getResponse()) {
                return mockResponse.getResponse();
            }
        }
        return null;
    }

    //Integer
    public Integer getInteger() {
        if (null != System.getProperty(top.moxingwang.simplemock.core.SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL)) {
            MethodSpiResponseDTO mockResponse = getMockData(Thread.currentThread().getStackTrace()[1]);
            if (null != mockResponse.getResponse()) {
                return Integer.valueOf(mockResponse.getResponse());
            }
        }
        return null;
    }

    //Integer
    public int getInt() {
        if (null != System.getProperty(top.moxingwang.simplemock.core.SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL)) {
            MethodSpiResponseDTO mockResponse = getMockData(Thread.currentThread().getStackTrace()[1]);
            if (null != mockResponse.getResponse()) {
                return Integer.valueOf(mockResponse.getResponse());
            }
        }
        return 1;
    }


    public MethodSpiResponseDTO getMockData(StackTraceElement stackTraceElement) {
        MethodSpiResponseDTO responseDTO = new MethodSpiResponseDTO();
        try {
            Class cl = Class.forName(stackTraceElement.getClassName());
            for (Method method : cl.getMethods()) {
                if (method.getName().equals(stackTraceElement.getMethodName())) {
                    //调用mock server
                    String mockUrl = System.getProperty(top.moxingwang.simplemock.core.SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL) + method.getClass().getName() + "." + method.getName();
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
