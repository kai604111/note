package cn.tedu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import cn.tedu.note.util.JsonResult;

@Component
@Aspect
public class DemoAspect {
	
	
	public DemoAspect() {
		System.out.println("DemoAspect");
	}

	//通知（切入点） 通知点+切入点==织入位置
//	@Before("within(* cn.tedu.note.service..*(..))")
//	@Before("bean(userService)")
	@Before("execution(* cn.tedu.note.service.*Service.add*(..))")
	public void hello(){
//		System.out.println("Hello World!");
	}
	
	@Around("bean(userService)")
	public Object testArount(ProceedingJoinPoint target) throws Throwable{
		//执行目标方法
//		System.out.println("调用开始");
		Object obj = target.proceed();
//		System.out.println("调用结束");
		return obj;
	}

}
