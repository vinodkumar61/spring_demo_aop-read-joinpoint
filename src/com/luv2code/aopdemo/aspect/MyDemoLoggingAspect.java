package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	

    @Before("com.luv2code.aopdemo.aspect.LuvAOPExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n=====>>> Executing @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSign = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: "+methodSign);
		
		// display the method arguments
		
		// get args 
		Object[] args= theJoinPoint.getArgs();
		
		// loop through args
		for(Object tempArgs : args) {
			System.out.println(tempArgs);
			
			if(tempArgs instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArgs;
				
				System.out.println("account name:"+ theAccount.getName());
				System.out.println("account level:"+ theAccount.getLevel());
			}
		}
	}
	

    
}
