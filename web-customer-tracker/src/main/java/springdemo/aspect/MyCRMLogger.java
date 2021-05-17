package springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.sun.istack.logging.Logger;

@Component
@Aspect
public class MyCRMLogger {

	private Logger myLogger= Logger.getLogger(getClass());
	
	@Pointcut("execution(* springdemo.CustomerController.*(..))")
	public void forController() {}
	
	@Pointcut("execution(* springdemo.service.*.*(..))")
	public void forService() {}
	 
	@Pointcut("execution(* springdemo.dao.*.*(..))")
	public void forDao() {}
	 
	@Pointcut("forController() || forService() || forDao()")
	public void forApp() {}
	
	@Before("forApp()")
	public void before(JoinPoint theJoin) {
		String name=theJoin.getSignature().toShortString();
		myLogger.info("In @Before->Calling method-"+name);
		Object[] arg=theJoin.getArgs();
		for(Object o:arg) {
			myLogger.info("Argument---->"+o);
		}
	}
	
	@AfterReturning(pointcut="forApp()",returning="result")
	public void after(JoinPoint theJoin,Object result) {
		String name=theJoin.getSignature().toShortString();
		myLogger.info("In @After->Calling method-"+name);
		myLogger.info("Returning---->"+result);
		
	}
	
	
}
