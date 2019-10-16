package top.moxingwang.simplemock.test.service;

import top.moxingwang.simplemock.core.SimpleMockConstant;
import top.moxingwang.simplemock.core.dto.MethodSpiResponseDTO;

import java.lang.reflect.Method;

public class ThreadTest {
    public static void main(String[] args) {
        System.getProperties().setProperty(SimpleMockConstant.SIMPLE_MOCK_VM_SERVER_URL, "http://localhost:8080/simple-mock/mock/string/");
        String info = new ThreadTest().getInfo();
        System.out.println("结果"+info);
    }

    public String getInfo() {
        MethodSpiResponseDTO mockResponse = mock(Thread.currentThread().getStackTrace()[1]);
        if (mockResponse.getType() == 2) {
            return;
        }

        System.out.println(1);
        return "OK";
//        return 1;
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
                    } else if ("int".equals(returnMethodName) || "java.lang.Integer".equals(returnMethodName)) {
                        responseDTO.setType(1);
                        return responseDTO;
                    } else if ("int".equals(returnMethodName) || "java.lang.Integer".equals(returnMethodName)) {
                        responseDTO.setType(1);
                        return responseDTO;
                    } else if ("int".equals(returnMethodName) || "java.lang.Integer".equals(returnMethodName)) {
                        responseDTO.setType(1);
                        return responseDTO;
                    } else if ("int".equals(returnMethodName) || "java.lang.Integer".equals(returnMethodName)) {
                        responseDTO.setType(1);
                        return responseDTO;
                    } else if ("int".equals(returnMethodName) || "java.lang.Integer".equals(returnMethodName)) {
                        responseDTO.setType(1);
                        return responseDTO;
                    }else if ("java.lang.String".equals(returnMethodName)) {
                        responseDTO.setType(1);
                        responseDTO.setResponse(str);
                        return responseDTO;
                    }
                    System.out.println(method.getName());
                }
            }
            System.out.println(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseDTO;
    }
}
