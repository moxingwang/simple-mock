package top.moxingwang.simplemock.agent;

import org.objectweb.asm.*;
import top.moxingwang.simplemock.core.annotation.SimpleMock;

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

    private boolean isMockAnnotationType = false;

    private String methodName;

    public EnhancerAdapter(ClassVisitor classVisitor) {
        super(ASM7, classVisitor);
    }

    public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
        System.out.println("访问注解"+descriptor);

        System.out.println(descriptor);

        if (descriptor.contains(SimpleMock.class.toString().replace(".","/").replace("interface ",""))){
            isMockAnnotationType = true;
        }
        return this.cv != null ? this.cv.visitAnnotation(descriptor, visible) : null;
    }

    public AnnotationVisitor visitTypeAnnotation(int typeRef, TypePath typePath, String descriptor, boolean visible) {
        System.out.println("访问注解"+descriptor);
        if (descriptor.contains(SimpleMock.class.toString().replace(".","/").replace("interface ",""))) {
            isMockAnnotationType = true;
        }

        if (this.api < ASM6) {
            throw new UnsupportedOperationException("This feature requires ASM6");
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
        System.out.println("访问方法"+name+descriptor+isMockAnnotationType);
        MethodVisitor mv = cv.visitMethod(access, name, descriptor, signature, exceptions);

        if (isMockAnnotationType && !isInterface && mv != null && !name.equals("<init>") && !name.equals("<clinit>")) {
            methodName = name;
            EnhancerMethodAdapter at = new EnhancerMethodAdapter(mv, access, name, descriptor);
            return at;
        }

        return mv;
    }

    public void visitEnd() {
        if (isMockAnnotationType && !isInterface) {
            FieldVisitor fv = cv.visitField(acc, filedName, "Ljava/lang/String;", null, owner);
            if (fv != null) {
                fv.visitEnd();
            }
        }
        cv.visitEnd();
    }


}
