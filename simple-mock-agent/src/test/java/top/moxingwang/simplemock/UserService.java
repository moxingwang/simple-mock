package top.moxingwang.simplemock;

import com.sun.istack.internal.NotNull;

import javax.xml.ws.ServiceMode;

@ServiceMode
public class UserService {
    @NotNull
    public void userInfo() {
        System.out.println("user info method------------------");
    }
}
