package top.moxingwang.simplemock.core.dto;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class MethodSpiResponseDTO implements Serializable {

    private boolean mocked = false;
    private String response;
    private Class methodReturnClass;


    public MethodSpiResponseDTO() {
    }

    public MethodSpiResponseDTO(boolean mocked) {
        this.mocked = mocked;
    }

    public static <T> T getObject(MethodSpiResponseDTO methodSpiResponseDTO) {
        return JSONObject.parseObject(methodSpiResponseDTO.getResponse().getBytes(), methodSpiResponseDTO.getMethodReturnClass());
    }


    public boolean isMocked() {
        return mocked;
    }

    public void setMocked(boolean mocked) {
        this.mocked = mocked;
    }

    public Class getMethodReturnClass() {
        return methodReturnClass;
    }

    public void setMethodReturnClass(Class methodReturnClass) {
        this.methodReturnClass = methodReturnClass;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
