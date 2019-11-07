package top.moxingwang.simplemock.agent;


import java.io.File;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Agent {
    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println(" premain(String args, Instrumentation inst) ");
        inst.addTransformer(new AgentTransformer(0,null,null));
    }

    public static void agentmain(String args, Instrumentation inst) {
        {
            loadClass("C:\\\\workspace\\\\simple-mock\\\\simple-mock-spy\\\\target\\\\simple-mock-spy-1.0.1-SNAPSHOT-jar-with-dependencies.jar",
                    "org.objectweb.asm.ClassVisitor");
        }
        System.out.println(" agentmain(String args, Instrumentation inst) ");
        inst.addTransformer(new AgentTransformer(1,args,null), true);
        try {
            inst.retransformClasses(Class.forName(args));
        } catch (UnmodifiableClassException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static public Class<?> loadClass(String filename, String classname) {
        try {
            File file = new File(filename);
            URL url = file.toURI().toURL();
            @SuppressWarnings("resource")
            URLClassLoader loader = new URLClassLoader(new URL[] { url });
            //
            return loader.loadClass(classname);
        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }
}
