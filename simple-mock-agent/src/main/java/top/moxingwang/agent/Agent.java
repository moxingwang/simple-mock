package top.moxingwang.agent;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.instrument.Instrumentation;

public class Agent {

    private static final Integer COMPUTE_MAXS = 1;

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(
                (loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
                    // 只对 io/libriraries/asm/agent/Person 类做方法增强
                    if ("io/libriraries/asm/agent/Person".equals(className)) {

                    }

                    System.out.println(className + " 开始agent...");
                    ClassReader reader = new ClassReader(classfileBuffer);
                    // 要指定 COMPUTE_MAXS 新生成字节码需要自动计算操作数栈的最大值，否则会报错
                    ClassWriter writer = new ClassWriter(reader, COMPUTE_MAXS);
                    ClassVisitor cv = new EnhancerAdapter(writer);
                    reader.accept(cv, 0);
                    System.out.println(className + "结束agent...");


                       /* // debug 输出文件到磁盘，方便核查
                        try (FileOutputStream fos = new FileOutputStream("F:\\Person.class")) {
                            fos.write(writer.toByteArray());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }*/

                    return writer.toByteArray();
                }
        );
    }
}
