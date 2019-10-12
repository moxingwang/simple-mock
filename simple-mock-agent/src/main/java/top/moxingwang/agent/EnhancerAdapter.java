package top.moxingwang.agent;

import org.objectweb.asm.*;

/**
 * @see https://blog.csdn.net/u014490683/article/details/22745799
 * @see https://zhuanlan.zhihu.com/p/71762514
 */

public class EnhancerAdapter extends ClassVisitor implements Opcodes {


    private String owner;
    private boolean isInterface;
    private String filedName = "UDASMCN";
    private int acc = Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC + Opcodes.ACC_FINAL;
    private boolean isPresent = false;

    private String methodName;

    public EnhancerAdapter(ClassVisitor classVisitor) {
        super(ASM7, classVisitor);
    }

    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        System.out.println("发现注解" + descriptor);
        return this.cv != null ? this.cv.visitAnnotation(descriptor, visible) : null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        System.out.println("发现注解-----------------" + descriptor);

        if (this.api < 327680) {
            throw new UnsupportedOperationException("This feature requires ASM5");
        } else {
            return this.cv != null ? this.cv.visitTypeAnnotation(typeRef, typePath, descriptor, visible) : null;
        }
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        owner = name;
        isInterface = (access & ACC_INTERFACE) != 0;
    }

    @Override
    public FieldVisitor visitField(int access, String name, String descriptor, String signature, Object value) {
        if (name.equals(filedName)) {
            isPresent = true;
        }
        return super.visitField(access, name, descriptor, signature, value);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature,
                                     String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, descriptor, signature, exceptions);

        if (!isInterface && mv != null && !name.equals("<init>") && !name.equals("<clinit>")) {
            methodName = name;
            EnhancerMethodAdapter at = new EnhancerMethodAdapter(mv, access, name, descriptor);
            return at;
        }

        return mv;
    }

    public void visitEnd() {
        if (!isInterface) {
            FieldVisitor fv = cv.visitField(acc, filedName, "Ljava/lang/String;", null, owner);
            if (fv != null) {
                fv.visitEnd();
            }
        }
        cv.visitEnd();
    }


}
