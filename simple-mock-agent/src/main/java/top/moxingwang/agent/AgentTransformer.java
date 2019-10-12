package top.moxingwang.agent;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class AgentTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        try {
            ClassReader cr = new ClassReader(className);
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            EnhancerAdapter enhancerAdapter = new EnhancerAdapter(cw);

            cr.accept(enhancerAdapter, ClassReader.EXPAND_FRAMES);

            return cw.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
