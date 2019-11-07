package top.moxingwang.simplemock.agent;


import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class Agent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println(" premain(String args, Instrumentation inst) ");
        inst.addTransformer(new AgentTransformer());
    }

    public static void agentmain(String args, Instrumentation inst) {
        System.out.println(" agentmain(String args, Instrumentation inst) ");
        inst.addTransformer(new AgentTransformer(), true);
        try {
            inst.retransformClasses(Class.forName(args));
        } catch (UnmodifiableClassException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
