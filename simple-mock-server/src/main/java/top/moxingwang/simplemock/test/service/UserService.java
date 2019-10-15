package top.moxingwang.simplemock.test.service;


import top.moxingwang.simplemock.core.annotation.SPI;

//@SPI
public class UserService {
    @SPI
    public String userInfo() {
        System.out.println("user info method------------------");
        return "OK";
    }
}
