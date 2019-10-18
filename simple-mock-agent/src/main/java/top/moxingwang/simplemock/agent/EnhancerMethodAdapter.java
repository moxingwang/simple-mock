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

        /*Label L1 = new Label();
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKEVIRTUAL, "top/moxingwang/simplemock/core/dto/MethodSpiResponseDTO", "isMocked", "()Z", false);

        Label L2 = null;
        mv.visitJumpInsn(IFEQ,L2);


        Label L3 = new Label();
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKEVIRTUAL, "top/moxingwang/simplemock/core/dto/MethodSpiResponseDTO", "getResponse", "()Ljava/lang/String;", false);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/String", "getBytes", "()[B", false);
        mv.visitVarInsn(ALOAD, 1);
        mv.visitMethodInsn(INVOKEVIRTUAL, "top/moxingwang/simplemock/core/dto/MethodSpiResponseDTO", "getMethodReturnClass", "()Ljava/lang/Class;", false);
        mv.visitInsn(ICONST_0);
        mv.visitTypeInsn(ANEWARRAY,"com/alibaba/fastjson/parser/Feature");
        mv.visitMethodInsn(INVOKESTATIC, "com/alibaba/fastjson/JSONObject", "parseObject", "([BLjava/lang/reflect/Type;[Lcom/alibaba/fastjson/parser/Feature;)Ljava/lang/Object;", false);
        mv.visitTypeInsn(CHECKCAST,"java/util/Map");
        mv.visitInsn(ARETURN);

        L2 = new Label();
        Object[] F_APPEND_OBJECT = {"top/moxingwang/simplemock/core/dto/MethodSpiResponseDTO"};
        mv.visitFrame(F_APPEND, 0, F_APPEND_OBJECT, 0, null);
        mv.visitInsn(ACONST_NULL);
        mv.visitInsn(ARETURN);

        Label L4 = new Label();
        mv.visitLocalVariable("this","Ltop/moxingwang/simplemock/test/service/ThreadTest;",null,L0,L4,0);
        mv.visitLocalVariable("mockResponse","Ltop/moxingwang/simplemock/core/dto/MethodSpiResponseDTO;",null,L0,L4,1);
*/



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