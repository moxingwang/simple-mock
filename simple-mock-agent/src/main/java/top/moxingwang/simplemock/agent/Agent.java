package top.moxingwang.simplemock.agent;


import top.moxingwang.simplemock.agent.test.UserTest;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class Agent {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println(" premain(String args, Instrumentation inst) ");

        inst.addTransformer(new AgentTransformer());
    }

    public static void agentmain(String args, Instrumentation inst) {
        System.out.println(" agentmain(String args, Instrumentation inst) ");

        inst.addTransformer(new AgentTransformer());

        try {
            inst.retransformClasses(UserTest.class);
        } catch (UnmodifiableClassException e) {
            e.printStackTrace();
        }
    }

}
