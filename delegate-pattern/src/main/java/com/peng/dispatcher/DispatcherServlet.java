package com.peng.dispatcher;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Handler> handlers = new ArrayList<Handler>();
	
	public void init() throws ServletException {
		//这里获取每个controller的class类，通过反射获取其所有的方法以及自定义注解(requestMapping)上value值
		setHandler(MemberController.class);
		setHandler(OrderController.class);
		setHandler(LoginController.class);
	}
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		this.route(req,resp);
	}
	
	//放入容器list中
	private void setHandler(Class<?> clazz) {
		Map<String, Method> methodMappingLogin = new ConcurrentHashMap<String, Method>();
		for (Method method : clazz.getMethods()) {
			if(method.isAnnotationPresent(RequestMapping.class)) {
				RequestMapping annotation = method.getAnnotation(RequestMapping.class);
				methodMappingLogin.put(annotation.value(), method);
			}
		}
		try {
			handlers.add(new Handler(methodMappingLogin, clazz.newInstance()));
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private void route(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String requestURI = req.getRequestURI();
		Map parameterMap = req.getParameterMap();
		//通过用户请求的url去匹配对应的handler
		Handler handlerInstance = null;
		for (Handler handler : handlers) {
			if(handler.getMethodMapping().containsKey(requestURI)) {
				handlerInstance = handler;
				break;
			}
		}
		if(handlerInstance == null) {
			throw new RuntimeException("404 not found");
		}
		//从handler中取出对应的方法进行反射执行
		Object object = null;
		try {
			object = handlerInstance.getMethodMapping().get(requestURI).invoke(handlerInstance.getController(), parameterMap);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	class Handler{
		//定义handler容器类， 将controller传入，将requestMapping与method做关联存入map中
		private Map<String,Method> methodMapping = new ConcurrentHashMap<String,Method>();
		
		private Object controller;

		public Map<String, Method> getMethodMapping() {
			return methodMapping;
		}

		public void setMethodMapping(Map<String, Method> methodMapping) {
			this.methodMapping = methodMapping;
		}

		public Object getController() {
			return controller;
		}

		public void setController(Object controller) {
			this.controller = controller;
		}

		public Handler(Map<String, Method> methodMapping, Object controller) {
			super();
			this.methodMapping = methodMapping;
			this.controller = controller;
		}

		public Handler() {
			super();
		}
		
	}
}
