package top.moxingwang.simplemock.agent;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class AgentTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classFileBuffer) {
        try {
            System.out.println("执行AgentTransformer");
            if (className == null || loader == null) {
                return null;
            }

            String packageName = System.getProperty(top.moxingwang.simplemock.core.SimpleMockConstant.SIMPLE_MOCK_VM_PACKAGE_NAME);


//            if (packageName == null || packageName.trim().length() <= 0 || !className.startsWith(packageName)) {
//                return null;
//            }

            ClassReader cr = new ClassReader(className);
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            EnhancerAdapter enhancerAdapter = new EnhancerAdapter(cw);

            cr.accept(enhancerAdapter, ClassReader.EXPAND_FRAMES);

            return cw.toByteArray();
        } catch (Exception e) {
            //e.printStackTrace();
        }

        return null;
    }
}
