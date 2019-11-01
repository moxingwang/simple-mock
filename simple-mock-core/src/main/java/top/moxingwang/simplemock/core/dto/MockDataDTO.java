package top.moxingwang.simplemock.core.dto;

import java.io.Serializable;

public class MockDataDTO implements Serializable {
    /**
     * 1 return body
     * 2 void return
     * 3 return null
     */
    private int type;
    private String body;

    public MockDataDTO() {
    }

    public MockDataDTO(int type, String body) {
        this.type = type;
        this.body = body;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
