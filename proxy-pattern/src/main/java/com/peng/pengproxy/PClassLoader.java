package com.peng.pengproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//类加载器，主要用于读取.class文件
public class PClassLoader extends ClassLoader {
	private File classPathFile;

	public PClassLoader() {
		//获取PClassLoader所在类的目录
		String classPath = PClassLoader.class.getResource("").getPath();
		this.classPathFile = new File(classPath);
	}

	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String className = PClassLoader.class.getPackage().getName() + "." + name;
		if (classPathFile != null) {
			//从PClassLoader所在类的目录中获取 name.class的文件
			File classFile = new File(classPathFile, name.replaceAll("\\.", "/") + ".class");
			if (classFile.exists()) {
				FileInputStream in = null;
				ByteArrayOutputStream out = null;
				try {
					in = new FileInputStream(classFile);
					out = new ByteArrayOutputStream();
					byte[] buff = new byte[1024];
					int len;
					while ((len = in.read(buff)) != -1) {
						out.write(buff, 0, len);
					}
					return defineClass(className, out.toByteArray(), 0, out.size());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (null != in) {
						try {
							in.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					if (out != null) {
						try {
							out.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		return null;
	}
}
