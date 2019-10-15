package top.moxingwang.simplemock.test.service;

import top.moxingwang.simplemock.core.annotation.SimpleMock;

public class Test {
    public static void main(String[] args) {
//        System.out.println(SimpleMock.class.toGenericString());
        System.out.println(SimpleMock.class.toString().replace(".","/"));
    }
}
