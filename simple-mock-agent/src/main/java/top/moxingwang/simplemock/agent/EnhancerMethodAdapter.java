package top.moxingwang.simplemock.agent;


import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;

public class EnhancerMethodAdapter extends AdviceAdapter {

    private final String name;


    protected EnhancerMethodAdapter(MethodVisitor mv, int access, String name, String desc) {
        super(ASM7, mv, access, name, desc);
        this.name = name;
    }

    /**
     * 方法前置
     */
    @Override
    protected void onMethodEnter() {
        Label L0 = new Label();
        mv.visitMethodInsn(INVOKESTATIC, "java/lang/Thread","currentThread", "()Ljava/lang/Thread;", false);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Thread", "getStackTrace", "()[Ljava/lang/StackTraceElement;", false);
        mv.visitInsn(ICONST_1);
        mv.visitInsn(AALOAD);
        mv.visitMethodInsn(INVOKESTATIC, "top/moxingwang/simplemock/core/api/MockApi", "getMockData", "(Ljava/lang/StackTraceElement;)Ltop/moxingwang/simplemock/core/dto/MethodSpiResponseDTO;", false);
        mv.visitVarInsn(ASTORE,1);



        Label L1 = new Label();
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKEVIRTUAL, "top/moxingwang/simplemock/core/dto/MethodSpiResponseDTO", "isMocked", "()Z", false);
        Label L2 = null;
        mv.visitJumpInsn(IFEQ,L2);


        Label L3 = new Label();
        mv.visitVarInsn(ALOAD, 1);
        mv.visitInsn(POP);
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKESTATIC, "top/moxingwang/simplemock/core/dto/MethodSpiResponseDTO", "getObject", "(Ltop/moxingwang/simplemock/core/dto/MethodSpiResponseDTO;)Ljava/lang/Object;", false);
        mv.visitTypeInsn(CHECKCAST,"java/util/Map");
        mv.visitInsn(ARETURN);

        L2 = new Label();
        Object[] F_APPEND_OBJECT = {"top/moxingwang/simplemock/core/dto/MethodSpiResponseDTO"};
        mv.visitFrame(F_APPEND, 0, F_APPEND_OBJECT, 0, null);




    }

    /**
     * 方法后置
     *
     * @param opcode
     */
    @Override
    protected void onMethodExit(int opcode) {
        // 后置逻辑 => System.out.println("method : " + name + " invoke end...");
        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("method : " + name + " invoke end...");
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        super.onMethodExit(opcode);
    }
}