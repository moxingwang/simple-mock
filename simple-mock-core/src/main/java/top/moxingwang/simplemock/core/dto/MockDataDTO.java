package top.moxingwang.simplemock.core.dto;

import java.io.Serializable;

public class MockDataDTO implements Serializable {
    /**
     * 0 return body
     * 1 void return
     * 2 return null
     */
    private int type;
    private String body;


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
