package top.moxingwang.simplemock.core.test;

import top.moxingwang.simplemock.core.annotation.SimpleMock;

@SimpleMock
public class UserTest {
    public void test(){
        System.out.println("没有被mock");
    }
}
