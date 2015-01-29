package com.kga.q.q4;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Q4ClassVisitor extends ClassVisitor {
	public Q4ClassVisitor(int api) {
		super(api);
	}

	public Q4ClassVisitor(int api, ClassVisitor cv) {
		super(api, cv);
	}
	@Override
	public void visitEnd() {
		//这里添加一个public void method(){};
		MethodVisitor mv=cv.visitMethod(Opcodes.ACC_PUBLIC, "method", "()V",null,null);
		if (mv != null) {
			mv.visitCode();//开始访问方法内部的代码
			mv.visitInsn(Opcodes.RETURN);//
			mv.visitMaxs(1, 1);//最大栈，和最大变量
			mv.visitEnd();
		}
		super.visitEnd();
	}

}
