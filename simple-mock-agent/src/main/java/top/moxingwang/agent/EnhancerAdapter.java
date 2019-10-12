package top.moxingwang.agent;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.util.TraceClassVisitor;

import java.io.PrintWriter;

/**
 * @see https://blog.csdn.net/u014490683/article/details/22745799
 * @see https://zhuanlan.zhihu.com/p/71762514
 */

public class EnhancerAdapter extends ClassVisitor {

    private final Integer ACC_ABSTRACT = 0x0400;
    private final Integer ACC_FINAL = 0x0010;

    private final TraceClassVisitor tracer;

    public EnhancerAdapter(ClassVisitor cv) {
        super(Opcodes.ASM6, cv);
        PrintWriter pw = new PrintWriter(System.out);
        tracer = new TraceClassVisitor(cv, pw);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {

        /*final MethodVisitor mv = tracer.visitMethod(access, name, desc, signature, exceptions);
        if (isIgnore(mv, access, name)) {
            return mv;
        }
        return new EnhancerMethodAdapter(mv, access, name, desc);*/


        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        MethodVisitor wrappedMv = mv;
        if (mv != null) {
            wrappedMv = new EnhancerMethodAdapter(mv, access, name, desc);
        }
        return wrappedMv;
    }

    @Override
    public void visitEnd() {
        System.out.println(tracer.p.getText());
        super.visitEnd();
    }

    /**
     * 忽略构造方法、类加载初始化方法，final方法和 abstract 方法
     *
     * @param mv
     * @param access
     * @param methodName
     * @return
     */
    private boolean isIgnore(MethodVisitor mv, int access, String methodName) {
        return null == mv
                || isAbstract(access)
                || isFinalMethod(access)
                || "<clinit>".equals(methodName)
                || "<init>".equals(methodName);
    }

    private boolean isAbstract(int access) {
        return (ACC_ABSTRACT & access) == ACC_ABSTRACT;
    }

    private boolean isFinalMethod(int methodAccess) {
        return (ACC_FINAL & methodAccess) == ACC_FINAL;
    }
}
