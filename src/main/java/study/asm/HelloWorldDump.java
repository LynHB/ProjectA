package study.asm;


import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class HelloWorldDump extends ClassLoader implements Opcodes {

    public static byte[] dump() {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);

        cw.visit(V1_8, ACC_PUBLIC | ACC_SUPER, "study/asm/HelloWorldAsm", null, "java/lang/Object", null);

        {
            MethodVisitor mv1 = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv1.visitCode();
            mv1.visitVarInsn(ALOAD, 0);
            mv1.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            mv1.visitInsn(RETURN);
            mv1.visitMaxs(1, 1);
            mv1.visitEnd();
        }
        {
            MethodVisitor mv2 = cw.visitMethod(ACC_PUBLIC, "toString", "()Ljava/lang/String;", null, null);
            mv2.visitCode();
            mv2.visitLdcInsn("This is a HelloWorld object.");
            mv2.visitInsn(ARETURN);
            mv2.visitMaxs(1, 1);
            mv2.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if ("study.asm.HelloWorldAsm".equals(name)) {
            byte[] bytes = HelloWorldDump.dump();
            Class<?> clazz = defineClass(name, bytes, 0, bytes.length);
            return clazz;
        }

        throw new ClassNotFoundException("Class Not Found: " + name);
    }

    public static void main(String[] args) throws Exception {
        HelloWorldDump classLoader = new HelloWorldDump();
        Class<?> clazz = classLoader.loadClass("study.asm.HelloWorldAsm");
        Object instance = clazz.newInstance();
        System.out.println(instance);
    }
}