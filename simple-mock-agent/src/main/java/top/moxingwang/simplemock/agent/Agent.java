package top.moxingwang.simplemock.agent;


import java.lang.instrument.Instrumentation;

public class Agent {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println(" premain(String args, Instrumentation inst) ");

        inst.addTransformer(new AgentTransformer());
    }

    public static void agentmain(String args, Instrumentation inst) {
        System.out.println(" agentmain(String args, Instrumentation inst) ");

        inst.addTransformer(new AgentTransformer());

    }

}
