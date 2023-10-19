import org.objectweb.asm.*;

import java.io.FileOutputStream;
import java.lang.reflect.Method;

public class ASMHelloWorldGenerator {

    public static void main(String[] args) throws Exception {
        // 创建一个ClassWriter对象，用于生成类文件
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

        // 设置类的基本信息
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "ASMHelloWorld", null, "java/lang/Object", null);

        // 创建默认构造函数
        MethodVisitor constructor = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
        constructor.visitCode();
        constructor.visitVarInsn(Opcodes.ALOAD, 0);
        constructor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        constructor.visitInsn(Opcodes.RETURN);
        constructor.visitMaxs(1, 1);
        constructor.visitEnd();

        // 创建打印方法
        MethodVisitor printMethod = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "printHelloWorld", "()V", null, null);
        printMethod.visitCode();
        printMethod.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        printMethod.visitLdcInsn("Hello, World!");
        printMethod.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        printMethod.visitInsn(Opcodes.RETURN);
        printMethod.visitMaxs(2, 0);
        printMethod.visitEnd();

        // 结束类的定义
        cw.visitEnd();

        // 获取生成的字节码
        byte[] bytecode = cw.toByteArray();

        // 将字节码写入文件
        String filename = "ASMHelloWorld.class";
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            fos.write(bytecode);
        }

        System.out.println("ASMHelloWorld class generated successfully!");

        // 加载刚刚创建的类
        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> findClass(String name) throws ClassNotFoundException {
                return defineClass(name, bytecode, 0, bytecode.length);
            }
        };

        // 实例化并调用 printHelloWorld 方法
        Class<?> helloWorldClass = loader.loadClass("ASMHelloWorld");
        Method printHelloWorld = helloWorldClass.getMethod("printHelloWorld");
        printHelloWorld.invoke(null);  // 静态方法不需要对象实例，所以我们传递 null 作为调用目标

    }
}