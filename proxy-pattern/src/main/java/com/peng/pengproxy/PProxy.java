package com.peng.pengproxy;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * 用来生成源代码的工具类
 */
public class PProxy {
	
	//用于拼写代码换行
	public static final String ln = "\r\n";

	public static Object newProxyInstance(PClassLoader classLoader, Class<?>[] interfaces, PInvocationHandler h) {
		try {
			// 1、动态根据反射机制生成java格式的字符串代码
			String src = generateSrc(interfaces);
			// 2、Java 文件输出磁盘
			String filePath = PProxy.class.getResource("").getPath();
			File f = new File(filePath + "$Proxy0.java");
			FileWriter fw = new FileWriter(f);
			fw.write(src);
			fw.flush();
			fw.close();
			// 3、把生成的.java 文件编译成.class 文件
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager manage = compiler.getStandardFileManager(null, null, null);
			Iterable iterable = manage.getJavaFileObjects(f);
			JavaCompiler.CompilationTask task = compiler.getTask(null, manage, null, null, null, iterable);
			task.call();
			manage.close();
			// 4、编译生成的.class 文件加载到 JVM 中来
			Class proxyClass = classLoader.findClass("$Proxy0");
			Constructor c = proxyClass.getConstructor(PInvocationHandler.class);
			f.delete();
			// 5、返回字节码重组以后的新的代理对象
			return c.newInstance(h);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//根据反射拼接java代码
	private static String generateSrc(Class<?>[] interfaces) {
		StringBuffer sb = new StringBuffer();
		sb.append("package com.peng.pengproxy;" + ln);
		for (Class<?> interfacez : interfaces) {
			sb.append("import " + interfacez.getName()+";" + ln);
		}
		sb.append("import java.lang.reflect.*;" + ln);
		sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
		sb.append("PInvocationHandler h;" + ln);
		sb.append("public $Proxy0(PInvocationHandler h) { " + ln);
		sb.append("this.h = h;");
		sb.append("}" + ln);
		for (Method m : interfaces[0].getMethods()) {
			Class<?>[] params = m.getParameterTypes();
			StringBuffer paramNames = new StringBuffer();
			StringBuffer paramValues = new StringBuffer();
			StringBuffer paramClasses = new StringBuffer();
			for (int i = 0; i < params.length; i++) {
				Class clazz = params[i];
				String type = clazz.getName();
				String paramName = toLowerFirstCase(clazz.getSimpleName());
				paramNames.append(type + " " + paramName);
				paramValues.append(paramName);
				paramClasses.append(clazz.getName() + ".class");
				if (i > 0 && i < params.length - 1) {
					paramNames.append(",");
					paramClasses.append(",");
					paramValues.append(",");
				}
			}
			sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames.toString() + ") {"
					+ ln);
			sb.append("try{" + ln);
			sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{"
					+ paramClasses.toString() + "});" + ln);
			sb.append((hasReturnValue(m.getReturnType()) ? "return " : ""));
			if(hasReturnValue(m.getReturnType())){
				sb.append(getCaseCode("this.h.invoke(this,m,new Object[]{" + paramValues + "})", m.getReturnType()) + ";" + ln);
			}else {
				sb.append("this.h.invoke(this,m,new Object[]{" + paramValues + "});" + ln);
			}
			sb.append("}catch(Error _ex) { }");
			sb.append("catch(Throwable e){" + ln);
			sb.append("throw new UndeclaredThrowableException(e);" + ln);
			sb.append("}");
			sb.append(getReturnEmptyCode(m.getReturnType()));
			sb.append("}");
		}
		sb.append("}" + ln);
		return sb.toString();
	}
	
	//处理基本数据类型的返回值，能够将返回值Object转为int
	private static Map<Class, Class> mappings = new HashMap<Class, Class>();
	static {
		mappings.put(int.class, Integer.class);
	}
	
	//用于方法trycatch的外部，处理返回值
	private static String getReturnEmptyCode(Class<?> returnClass) {
		if (mappings.containsKey(returnClass)) {
			return "return 0;";
		} else if (returnClass == void.class) {
			return "";
		} else {
			return "return null;";
		}
	}
	//处理有返回值的方法，拼接返回值
	private static String getCaseCode(String code, Class<?> returnClass) {
		if (mappings.containsKey(returnClass)) {
			return "((" + mappings.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName()
					+ "Value()";
		} else {
			return null;
		}
	}
	
	//判断该方法的返回值是否为void
	private static boolean hasReturnValue(Class<?> clazz) {
		return clazz != void.class;
	}

	private static String toLowerFirstCase(String src) {
		char[] chars = src.toCharArray();
		chars[0] += 32;
		return String.valueOf(chars);
	}
}