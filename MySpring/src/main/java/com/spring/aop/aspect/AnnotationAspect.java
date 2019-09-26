package com.spring.aop.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;

//声明此类被IOC容器管理,不声明无法自动织入
@Component
//这个类会声明为是一个需要动态织入到虚拟切面中的类
@Aspect
public class AnnotationAspect {
	
	private final static Logger LOG = Logger.getLogger(LogAspect.class);
	
	//声明切点
	//因为要利用反射机制读取切面中的所有的注解信息
	@Pointcut("execution(* com.spring.aop.service..*(..))")
	public void ponintcutConfig() {}
	
	@Before("ponintcutConfig()")
	public void  before(JoinPoint joinPoint) {
		LOG.info("调用方法之前执行 :" + joinPoint);
	}
	
	@After("ponintcutConfig()")
	public void  after(JoinPoint joinPoint) {
		LOG.info("调用方法之后执行 :" + joinPoint);
	}
	
	@AfterReturning("ponintcutConfig()")
	public void  afterReturn(JoinPoint joinPoint) {
		LOG.info("调用方法获得返回值之后执行 :" + joinPoint);
	}
	
	@AfterThrowing("ponintcutConfig()")
	public void  afterThrow(JoinPoint joinPoint) {
		LOG.info("抛出异常后执行 :" + joinPoint);
		//获取切点参数的值
		Object[] args = joinPoint.getArgs();
		//获取切点的方法
		String kind = joinPoint.getKind();
		//获取整个切点
		Signature signature = joinPoint.getSignature();
		//获取生成以后的代理对象
		Object target = joinPoint.getTarget();
		//获取当前类的本身(通过反射去调用)
		Object this1 = joinPoint.getThis();
		SourceLocation sourceLocation = joinPoint.getSourceLocation();
		StaticPart staticPart = joinPoint.getStaticPart();
	}
}
