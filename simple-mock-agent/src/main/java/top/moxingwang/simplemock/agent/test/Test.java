package top.moxingwang.simplemock.agent.test;

import top.moxingwang.simplemock.agent.AgentTransformer;

import java.lang.instrument.ClassFileTransformer;

public final class Test  {
    public static void main(String[] args) {
        {
            UserTest userTest = new UserTest();
            userTest.test();
        }

        {
            AgentTransformer agentTransformer = new AgentTransformer();
            agentTransformer.transform(UserTest.class.getClassLoader(), UserTest.class.getName(), null, null, null);
        }

        {
            UserTest userTest = new UserTest();
            userTest.test();
        }
    }
}
