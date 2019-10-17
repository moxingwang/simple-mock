package top.moxingwang.simplemock.core.dto;

import java.io.Serializable;

public class MethodSpiResponseDTO<T> implements Serializable {

    private boolean mocked = false;
    private String response;
    private Class methodReturnClass;

    public MethodSpiResponseDTO() {
    }

    public MethodSpiResponseDTO(boolean mocked) {
        this.mocked = mocked;
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
