package top.moxingwang.simplemock.agent;

public class UserServiceTest {
    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println("执行结果：" + userService.userInfo());
    }
}
