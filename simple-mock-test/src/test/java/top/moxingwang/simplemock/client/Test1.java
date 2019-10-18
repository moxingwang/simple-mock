package top.moxingwang.simplemock.client;

import top.moxingwang.simplemock.core.annotation.SimpleMock;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(SimpleMock.class.toString().replace(".","/"));
        System.out.println("Ltop/moxingwang/simplemock/core/annotation/SimpleMock;".contains(SimpleMock.class.toString().replace(".","/").replace("interface ","")));
    }
}
