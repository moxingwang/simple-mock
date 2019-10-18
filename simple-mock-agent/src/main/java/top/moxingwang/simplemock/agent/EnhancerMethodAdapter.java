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
        // 前置逻辑 => System.out.println("method : " + name + " invoke start...");
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

        Label L2 = new Label();
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
        mv.visitFrame(F_SAME, 0, null, 0, null);




//        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//        mv.visitLocalVariable();
//        mv.visitLdcInsn("method : " + name + " invoke start...");
//        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

//        mv.visitCode();
//        Label l0 = new Label();
//        Label l1 = new Label();
//        Label l2 = new Label();
//        mv.visitTryCatchBlock(l0, l1, l2, "java/lang/Exception");
//
//        mv.visitMethodInsn(INVOKESTATIC, "org/apache/http/impl/client/HttpClients", "createDefault", "()Lorg/apache/http/impl/client/CloseableHttpClient;", false);
//        mv.visitTypeInsn(NEW,"org/apache/http/client/methods/HttpGet");
//        mv.visitInsn(DUP);
//        mv.visitLdcInsn("https://www.baidu.com");
//        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "getProperty", "(Ljava/lang/String;)Ljava/lang/String;", false);
//        mv.visitMethodInsn(INVOKESPECIAL, "org/apache/http/client/methods/HttpGet", "<init>", "(Ljava/lang/String;)V", false);
//        mv.visitMethodInsn(INVOKEVIRTUAL, "org/apache/http/impl/client/CloseableHttpClient", "execute", "(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/client/methods/CloseableHttpResponse;", false);
//        mv.visitMethodInsn(INVOKEINTERFACE, "org/apache/http/client/methods/CloseableHttpResponse", "getEntity", "()Lorg/apache/http/HttpEntity; (itf)", false);
//        mv.visitLdcInsn( "UTF-8");
//        mv.visitMethodInsn(INVOKESTATIC, "java/lang/System", "toString", "(Lorg/apache/http/HttpEntity;Ljava/lang/String;)Ljava/lang/String;", false);
//        mv.visitVarInsn(ASTORE, 1);
//        mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
//        mv.visitVarInsn(ALOAD, 1);
//        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
//        mv.visitInsn(ACONST_NULL);
//        mv.visitVarInsn(ASTORE, 1);
//
//        mv.visitJumpInsn(IFLE, new Label() );
//        mv.visitVarInsn(ALOAD, 1);
//        mv.visitInsn(ARETURN);
//        mv.visitFrame(F_SAME, 0, null, 0, null);
//
//        mv.visitJumpInsn(GOTO, new Label());
//        mv.visitFrame(F_SAME1, 0, null, 1, new Object[] {"java/lang/Exception"});
//        mv.visitVarInsn(ASTORE, 1);
//        mv.visitVarInsn(ASTORE, 1);
//        mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/IOException", "printStackTrace", "()V",false);
//        mv.visitFrame(F_SAME, 0, null, 0, null);


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