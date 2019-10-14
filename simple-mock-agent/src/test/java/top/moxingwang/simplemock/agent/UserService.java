package top.moxingwang.simplemock.agent;

import top.moxingwang.simplemock.agent.api.SPI;

//@SPI
public class UserService {
    @SPI
    public void userInfo() {
        System.out.println("user info method------------------");
    }
}
