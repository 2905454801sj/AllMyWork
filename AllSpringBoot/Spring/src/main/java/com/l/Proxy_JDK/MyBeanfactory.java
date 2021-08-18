package com.l.Proxy_JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyBeanfactory {
	
	public static UserService createUser() {
		//目标类
		final UserService userService =new UserServiceImpl();
		//切面类
		final MyAspect myAspect=new MyAspect();
		/*代理类:将目标类（切入点）和切面类（通知）结合--》切面
		Proxy.newProxyInstance
		参数1：loader，类加载器，动态代理类，运行时创建，任何类都需要类加载器才能加载到
		内存，一般用   当前类.class.getClassLoader()
		参数2：class[]  interfaces，代理类需要实现所有的接口
		 1.目标类实例。getclass。getinterfaces（） 只能获得当前类接口，不能获得父元素接口
		 2.new class[]{UserService.class}
		参数3：InvokeHandler 处理类，接口，必须进行实现类，一般采用匿名内部类的方式
		提供invoke方法，代理类的每一个方法执行时，都将调用一次invoke
		参数1：proxy 代理对象
		参数2：method 代理对象当前执行方法的描述对象（反射）
		执行方法名：method.getname（）
		执行方法:method.invoke（对象，实际参数）
		参数3：args 方法的实际参数		
		*/
		UserService proxyuserse=(UserService)Proxy.newProxyInstance(
				UserService.class.getClassLoader(), 
				userService.getClass().getInterfaces(), 
				new InvocationHandler() {
					
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						//执行目标方法
						myAspect.before();;
						Object object=method.invoke(userService, args);
						myAspect.after();
						return object;
					}
				});
		return proxyuserse;
	}

}
