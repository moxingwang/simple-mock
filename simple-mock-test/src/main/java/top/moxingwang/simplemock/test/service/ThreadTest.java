package top.moxingwang.simplemock.test.service;

import top.moxingwang.simplemock.core.dto.MethodSpiResponseDTO;

import java.lang.reflect.Method;

public class ThreadTest {
    public static void main(String[] args) {
        new ThreadTest().getInfo();
    }

    public Integer getInfo() {
        MethodSpiResponseDTO info2 = getInfo2(Thread.currentThread().getStackTrace()[1]);
        System.out.println(1);
//        return "OK";
        return 1;
    }

    public MethodSpiResponseDTO getInfo2(StackTraceElement stackTraceElement) {
        MethodSpiResponseDTO responseDTO = new MethodSpiResponseDTO(0);
        try {
            Class cl = Class.forName(stackTraceElement.getClassName());
            for (Method method : cl.getMethods()) {
                //调用mock server

                if (method.getName().equals(stackTraceElement.getMethodName())) {
                    String returnMethodName = method.getReturnType().getName();
                    if ("void".equals(returnMethodName)) {
                        responseDTO.setType(1);
                        return responseDTO;
                    }else if ("int".equals(returnMethodName) || "java.lang.Integer".equals(returnMethodName)) {
                        responseDTO.setType(1);
                        return responseDTO;
                    }else if ("int".equals(returnMethodName) || "java.lang.Integer".equals(returnMethodName)) {
                        responseDTO.setType(1);
                        return responseDTO;
                    }else if ("int".equals(returnMethodName) || "java.lang.Integer".equals(returnMethodName)) {
                        responseDTO.setType(1);
                        return responseDTO;
                    }else if ("int".equals(returnMethodName) || "java.lang.Integer".equals(returnMethodName)) {
                        responseDTO.setType(1);
                        return responseDTO;
                    }else if ("int".equals(returnMethodName) || "java.lang.Integer".equals(returnMethodName)) {
                        responseDTO.setType(1);
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
