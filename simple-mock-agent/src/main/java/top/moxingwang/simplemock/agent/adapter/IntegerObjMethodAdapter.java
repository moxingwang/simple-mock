package top.moxingwang.simplemock.agent.adapter;


import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;

public class IntegerObjMethodAdapter extends AdviceAdapter {

    public IntegerObjMethodAdapter(MethodVisitor mv, int access, String name, String desc) {
        super(ASM7, mv, access, name, desc);
    }

    /**
     * 方法前置
     */
    @Override
    protected void onMethodEnter() {
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(10, l0);
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/Thread", "currentThread", "()Ljava/lang/Thread;", false);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Thread", "getStackTrace", "()[Ljava/lang/StackTraceElement;", false);
        mv.visitInsn(ICONST_1);
        mv.visitInsn(AALOAD);
        mv.visitMethodInsn(INVOKESTATIC, "top/moxingwang/simplemock/core/api/MockApi", "getMockData", "(Ljava/lang/StackTraceElement;)Ltop/moxingwang/simplemock/core/dto/MethodSpiResponseDTO;", false);
        mv.visitVarInsn(ASTORE, 1);
        Label l1 = new Label();
        mv.visitLabel(l1);
        mv.visitLineNumber(11, l1);
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKEVIRTUAL, "top/moxingwang/simplemock/core/dto/MethodSpiResponseDTO", "isMocked", "()Z", false);
        Label l2 = new Label();
        mv.visitJumpInsn(IFEQ, l2);
        Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLineNumber(12, l3);
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKEVIRTUAL, "top/moxingwang/simplemock/core/dto/MethodSpiResponseDTO", "isReturnNull", "()Z", false);
        Label l4 = new Label();
        mv.visitJumpInsn(IFEQ, l4);
        Label l5 = new Label();
        mv.visitLabel(l5);
        mv.visitLineNumber(13, l5);
        mv.visitInsn(ACONST_NULL);
        mv.visitInsn(ARETURN);
        mv.visitLabel(l4);
        mv.visitLineNumber(15, l4);
        mv.visitFrame(F_APPEND, 1, new Object[]{"top/moxingwang/simplemock/core/dto/MethodSpiResponseDTO"}, 0, null);
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKEVIRTUAL, "top/moxingwang/simplemock/core/dto/MethodSpiResponseDTO", "getResponse", "()Ljava/lang/String;", false);
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(Ljava/lang/String;)Ljava/lang/Integer;", false);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Integer", "intValue", "()I", false);
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;", false);
        mv.visitInsn(ARETURN);
        mv.visitLabel(l2);
        mv.visitLineNumber(19, l2);
        mv.visitFrame(F_SAME, 0, null, 0, null);
    }
}