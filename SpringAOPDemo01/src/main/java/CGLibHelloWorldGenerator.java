import net.sf.cglib.core.ClassEmitter;
import net.sf.cglib.core.CodeEmitter;
import net.sf.cglib.core.Signature;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

import java.io.FileOutputStream;
import java.lang.reflect.Method;

public class CGLibHelloWorldGenerator {
    public static void main(String[] args) throws Exception {
        // 创建 ClassWriter 用于生成类的字节码
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);

        // 创建 ClassEmitter 对象
        ClassEmitter ce = new ClassEmitter(cw);

        // 正确地将新类定义为 java.lang.Object 的子类，而不是实现它
        ce.begin_class(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "CGLibHelloWorld", Type.getType(Object.class), null, null);

        // 创建默认构造函数
        CodeEmitter constructor = ce.begin_method(Opcodes.ACC_PUBLIC, new Signature("<init>", "()V"), null);
        constructor.load_this();
        constructor.super_invoke_constructor();
        constructor.return_value();
        constructor.end_method();

        // 创建 printHelloWorld 方法
        CodeEmitter printMethodEmitter = ce.begin_method(Opcodes.ACC_PUBLIC | Opcodes.ACC_STATIC, new Signature("printHelloWorld", "()V"), null);
        printMethodEmitter.getstatic(Type.getType(System.class), "out", Type.getType(java.io.PrintStream.class));
        printMethodEmitter.push("Hello, World!");
        printMethodEmitter.invoke_virtual(Type.getType(java.io.PrintStream.class), new Signature("println", "(Ljava/lang/String;)V"));
        printMethodEmitter.return_value();
        printMethodEmitter.end_method();

        // 结束类的创建
        ce.end_class();

        // 获取生成的类的字节码
        byte[] bytecode = cw.toByteArray();

        // 写入文件（可选，如果你想看生成的文件）
        try (FileOutputStream fos = new FileOutputStream("CGLibHelloWorld.class")) {
            fos.write(bytecode);
        }
        System.out.println("HelloWorld class generated successfully!");


        // 加载刚刚创建的类
        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> findClass(String name) throws ClassNotFoundException {
                return defineClass(name, bytecode, 0, bytecode.length);
            }
        };

        // 实例化并调用 printHelloWorld 方法
        Class<?> helloWorldClass = loader.loadClass("CGLibHelloWorld");
        Method printHelloWorld = helloWorldClass.getMethod("printHelloWorld");
        printHelloWorld.invoke(null);  // 静态方法不需要对象实例，所以我们传递 null 作为调用目标
    }
}
