package top.moxingwang.simplemock;

import top.moxingwang.agent.api.SPI;

//@SPI
public class UserService {
    @SPI
    public void userInfo() {
        System.out.println("user info method------------------");
    }
}
