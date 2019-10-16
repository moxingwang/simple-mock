package top.moxingwang.simplemock.test.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import top.moxingwang.simplemock.core.SimpleMockConstant;
import top.moxingwang.simplemock.core.api.MockApi;
import top.moxingwang.simplemock.core.dto.MethodSpiResponseDTO;

import java.util.Map;

public class ThreadTest {
    public static void main(String[] args) {
        System.getProperties().setProperty(SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL, "http://localhost:8080/simple-mock/mock/string/");
        System.out.println("结果" + JSON.toJSONString(new ThreadTest().getInfo()));
    }

    //Object
    public Map<String, String> getInfo() {
        if (null != System.getProperty(top.moxingwang.simplemock.core.SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL)) {
            MethodSpiResponseDTO mockResponse = MockApi.getMockData(Thread.currentThread().getStackTrace()[1]);
            String response = mockResponse.getResponse();
            if (null != response) {
                return JSONObject.parseObject(response.getBytes(), mockResponse.getMethodReturnClass());
            }
        }
        return null;
    }

    //String
    public String getString() {
        if (null != System.getProperty(top.moxingwang.simplemock.core.SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL)) {
            MethodSpiResponseDTO mockResponse = MockApi.getMockData(Thread.currentThread().getStackTrace()[1]);
            String response = mockResponse.getResponse();
            if (null != response) {
                return response;
            }
        }
        return null;
    }

    //Integer
    public Integer getInteger() {
        if (null != System.getProperty(top.moxingwang.simplemock.core.SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL)) {
            MethodSpiResponseDTO mockResponse = MockApi.getMockData(Thread.currentThread().getStackTrace()[1]);
            String response = mockResponse.getResponse();
            if (null != response) {
                return Integer.valueOf(response);
            }
        }
        return null;
    }

    //Integer
    public int getInt() {
        if (null != System.getProperty(top.moxingwang.simplemock.core.SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL)) {
            MethodSpiResponseDTO mockResponse = MockApi.getMockData(Thread.currentThread().getStackTrace()[1]);
            String response = mockResponse.getResponse();
            if (null != response) {
                return Integer.valueOf(response);
            }
        }
        return 1;
    }

}
