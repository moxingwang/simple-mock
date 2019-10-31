package top.moxingwang.simplemock.agent.adapter;


import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;

public class ObjectMethodAdapter extends AdviceAdapter {

    private String returnClassType;

    public ObjectMethodAdapter(MethodVisitor mv, int access, String name, String desc,String returnClassType) {
        super(ASM7, mv, access, name, desc);
        this.returnClassType = returnClassType;
    }

    /**
     * 方法前置
     */
    @Override
    protected void onMethodEnter() {
        Label l0 = new Label();
        mv.visitLabel(l0);
        mv.visitLineNumber(13, l0);
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/Thread", "currentThread", "()Ljava/lang/Thread;", false);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Thread", "getStackTrace", "()[Ljava/lang/StackTraceElement;", false);
        mv.visitInsn(ICONST_1);
        mv.visitInsn(AALOAD);
        mv.visitMethodInsn(INVOKESTATIC, "top/moxingwang/simplemock/core/api/MockApi", "getMockData", "(Ljava/lang/StackTraceElement;)Ltop/moxingwang/simplemock/core/dto/MethodSpiResponseDTO;", false);
        mv.visitVarInsn(ASTORE, 1);
        Label l1 = new Label();
        mv.visitLabel(l1);
        mv.visitLineNumber(14, l1);
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKEVIRTUAL, "top/moxingwang/simplemock/core/dto/MethodSpiResponseDTO", "isMocked", "()Z", false);
        Label l2 = new Label();
        mv.visitJumpInsn(IFEQ, l2);
        Label l3 = new Label();
        mv.visitLabel(l3);
        mv.visitLineNumber(15, l3);
        mv.visitVarInsn(ALOAD, 1);
        mv.visitInsn(POP);
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKESTATIC, "top/moxingwang/simplemock/core/dto/MethodSpiResponseDTO", "getObject", "(Ltop/moxingwang/simplemock/core/dto/MethodSpiResponseDTO;)Ljava/lang/Object;", false);
        mv.visitTypeInsn(CHECKCAST, returnClassType);
        mv.visitInsn(ARETURN);
        mv.visitLabel(l2);
        mv.visitLineNumber(19, l2);
        mv.visitFrame(F_APPEND, 1, new Object[]{"top/moxingwang/simplemock/core/dto/MethodSpiResponseDTO"}, 0, null);
    }
}