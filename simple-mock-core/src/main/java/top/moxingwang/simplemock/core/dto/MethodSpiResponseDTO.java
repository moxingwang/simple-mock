package top.moxingwang.simplemock.core.dto;

import java.io.Serializable;

public class MethodSpiResponseDTO<T> implements Serializable {
    /**
     * 0 不mock
     * 1 void方法
     * 2 有返回值
     *
     */
    private int type;
    private T response;
    private Class methodReturnClass;

    public MethodSpiResponseDTO() {
    }

    public Class getMethodReturnClass() {
        return methodReturnClass;
    }

    public void setMethodReturnClass(Class methodReturnClass) {
        this.methodReturnClass = methodReturnClass;
    }

    public MethodSpiResponseDTO(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
