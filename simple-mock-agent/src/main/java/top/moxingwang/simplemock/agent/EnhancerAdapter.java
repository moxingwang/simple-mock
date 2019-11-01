package top.moxingwang.simplemock.agent;

import org.objectweb.asm.*;
import org.objectweb.asm.commons.AdviceAdapter;
import top.moxingwang.simplemock.agent.adapter.IntegerMethodAdapter;
import top.moxingwang.simplemock.agent.adapter.ObjectMethodAdapter;
import top.moxingwang.simplemock.agent.adapter.VoidMethodAdapter;
import top.moxingwang.simplemock.core.annotation.SimpleMock;

/**
 * @see https://blog.csdn.net/u014490683/article/details/22745799
 * @see https://zhuanlan.zhihu.com/p/71762514
 */

public class EnhancerAdapter extends ClassVisitor implements Opcodes {

    private boolean isInterface;
    private boolean isMockAnnotationType = false;

    public EnhancerAdapter(ClassVisitor classVisitor) {
        super(ASM7, classVisitor);
    }

    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        System.out.println("访问注解1" + descriptor);

        System.out.println(descriptor);

        if (descriptor.contains(SimpleMock.class.toString().replace(".", "/").replace("interface ", ""))) {
            isMockAnnotationType = true;
        }
        return this.cv != null ? this.cv.visitAnnotation(descriptor, visible) : null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        System.out.println("访问注解2" + descriptor);
        if (descriptor.contains(SimpleMock.class.toString().replace(".", "/").replace("interface ", ""))) {
            isMockAnnotationType = true;
        }

        if (this.api < ASM7) {
            throw new UnsupportedOperationException("This feature requires ASM6");
        } else {
            return this.cv != null ? this.cv.visitTypeAnnotation(typeRef, typePath, descriptor, visible) : null;
        }
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        isInterface = (access & ACC_INTERFACE) != 0;
    }


    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature,
                                     String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, descriptor, signature, exceptions);

        System.err.println("return type: " + Type.getReturnType(descriptor));
        System.err.println("return type: " + Type.getReturnType(descriptor).getSort());


        if (isMockAnnotationType && !isInterface && mv != null && !name.equals("<init>") && !name.equals("<clinit>")) {
            System.out.println("访问方法开始" + name + descriptor + isMockAnnotationType);
            int methodReturnType = Type.getReturnType(descriptor).getSort();
            System.out.println("返回class:" + Type.getReturnType(descriptor).getClassName());
            AdviceAdapter adviceAdapter = null;

            String returnClassType = Type.getReturnType(descriptor).getClassName().replace(".", "/");

            System.out.println("分发methodReturnType"+methodReturnType+"returnClassType"+returnClassType);

            if (Type.OBJECT == methodReturnType) {
                adviceAdapter = new ObjectMethodAdapter(mv, access, name, descriptor, returnClassType);
            } else if (Type.VOID == methodReturnType) {
                adviceAdapter = new VoidMethodAdapter(mv, access, name, descriptor);
            } else if (Type.INT == methodReturnType) {
                adviceAdapter = new IntegerMethodAdapter(mv, access, name, descriptor);
            }

            if (null != adviceAdapter) {
                return adviceAdapter;
            }
        }

        return mv;
    }


}
