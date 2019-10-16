package top.moxingwang.simplemock.core.dto;

import java.io.Serializable;

public class MethodSpiResponseDTO<T> implements Serializable {

    private String response;
    private Class methodReturnClass;

    public MethodSpiResponseDTO() {
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
