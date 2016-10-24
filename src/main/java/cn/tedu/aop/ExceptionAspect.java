package cn.tedu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import cn.tedu.note.util.JsonResult;

@Component
@Aspect
public class ExceptionAspect {

	@Around("within(cn.tedu.note.web.*Controller)")
	public Object process(ProceedingJoinPoint target) throws Throwable{
		try {
			//login() listNotes()
			System.out.println("开始");
			Object s = target.getTarget();
//			System.out.println(s.toString());
			Object obj = target.proceed();
			System.out.println("结束");
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("有异常");
			return new JsonResult<Object>(e.getMessage());
		}
	}
}
