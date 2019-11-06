package top.moxingwang.simplemock.agent.test;

import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
import top.moxingwang.simplemock.core.util.JUtil;

import java.io.File;
import java.io.IOException;

public final class Test {
    public static void main(String[] args) {
        while (true) {
            UserTest userTest = new UserTest();
            userTest.test();

            try {
                Thread.sleep(10000);

                {
                    // Attach到被监控的JVM进程上
                    VirtualMachine virtualmachine = null;
                    try {
                        virtualmachine = VirtualMachine.attach(JUtil.getPid());

                        // 让JVM加载jmx Agent
                        String javaHome = virtualmachine.getSystemProperties().getProperty("java.home");
                        String jmxAgent = javaHome + File.separator + "lib" + File.separator + "management-agent.jar";
                        virtualmachine.loadAgent(jmxAgent, "com.sun.management.jmxremote");

                    } catch (AttachNotSupportedException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (AgentLoadException e) {
                        e.printStackTrace();
                    } catch (AgentInitializationException e) {
                        e.printStackTrace();
                    }


                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
