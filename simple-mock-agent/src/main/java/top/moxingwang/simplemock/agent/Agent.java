package top.moxingwang.simplemock.agent;


import java.lang.instrument.Instrumentation;

public class Agent {

/*    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new AgentTransformer());
    }*/

    public static void agentmain(String args, Instrumentation inst) {
        System.out.println(" agentmain(String args, Instrumentation inst) ");

        inst.addTransformer(new AgentTransformer());

    }

    public static void premain(String var0) throws Exception {
        System.out.println("premain(String var0)");

    }

    public static void agentmain(String var0) throws Exception {
        System.out.println("agentmain(String var0)");
    }
}
