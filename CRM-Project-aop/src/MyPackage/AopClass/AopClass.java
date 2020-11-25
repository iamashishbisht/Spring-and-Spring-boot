package MyPackage.AopClass;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import MyPackage.MyEntityClass.Customer;

@Aspect
@Component
public class AopClass {

	@Pointcut("execution(public * getCustomerList())")
	public void getCustomerListPointcut() {
	}

	@Pointcut("execution(public * addCustomer(*))")
	public void addCustomerPointcut() {
	}

	@Pointcut("execution(public * getCustomerById(*))")
	public void getCustomerByIdPointcut() {
	}

	@Pointcut("execution(public * deleteCustomer(*))")
	public void deleteCustomerPointcut() {
	}

	@Before("getCustomerListPointcut()")
	public void getCustomerListBefore(JoinPoint theJoinPoint) {
		System.out.println("Before getCustomerList");

		Signature sign = theJoinPoint.getSignature();
		System.out.println("Signature : " + sign);

		/*
		 * MethodSignature sign1 = (MethodSignature) theJoinPoint.getSignature();
		 * System.out.println("Signature : " + sign1);
		 */

		MethodSignature sign1 = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Signature : " + sign1);

		Object[] args = theJoinPoint.getArgs();

		for (Object arg : args) {
			System.out.println("args : " + arg);

		}
	}

	@Before("addCustomerPointcut()")
	public void addCustomerBefore(JoinPoint theJoinPoint) {
		System.out.println("Before addCustomer");

		System.out.println("Before getCustomerList");

		Signature sign = theJoinPoint.getSignature();
		System.out.println("Signature : " + sign);

		/*
		 * MethodSignature sign1 = (MethodSignature) theJoinPoint.getSignature();
		 * System.out.println("Signature : " + sign1);
		 */

		Object[] args = theJoinPoint.getArgs();

		for (Object arg : args) {
			System.out.println("args : " + arg);

		}

	}

	@Before("getCustomerByIdPointcut()")
	public void getCustomerByIdBefore() {
		System.out.println("Before getCustomerById");

	}

	@Before("deleteCustomerPointcut()")
	public void deleteCustomerBefore() {
		System.out.println("Before deleteCustomer");

	}

	// after returning

	@AfterReturning(pointcut = "getCustomerListPointcut()" , returning = "result")
	public void getCustomerListAfterReturning(JoinPoint theJoinPoint, List<Customer> result) {
		System.out.println("After getCustomerList");
         
		System.out.println("Result :" + result);
		
		if(result != null) {
			result.get(0).setEmail("hi@gmail");
			
		}
		/*
		 * Signature sign = theJoinPoint.getSignature();
		 * System.out.println("Signature : " + sign);
		 * 
		 * 
		 * MethodSignature sign1 = (MethodSignature) theJoinPoint.getSignature();
		 * System.out.println("Signature : " + sign1);
		 * 
		 * 
		 * MethodSignature sign1 = (MethodSignature) theJoinPoint.getSignature();
		 * System.out.println("Signature : " + sign1);
		 * 
		 * Object []args = theJoinPoint.getArgs();
		 * 
		 * for(Object arg : args) { System.out.println("args : "+ arg);
		 * 
		 * }
		 */
	}

	@AfterReturning("addCustomerPointcut()")
	public void addCustomerAfterReturning(JoinPoint theJoinPoint) {
		System.out.println("Before addCustomer");

		System.out.println("Before getCustomerList");

		Signature sign = theJoinPoint.getSignature();
		System.out.println("Signature : " + sign);

		/*
		 * MethodSignature sign1 = (MethodSignature) theJoinPoint.getSignature();
		 * System.out.println("Signature : " + sign1);
		 */

		Object[] args = theJoinPoint.getArgs();

		for (Object arg : args) {
			System.out.println("args : " + arg);

		}

	}

	@AfterReturning("getCustomerByIdPointcut()")
	public void AfterReturning() {
		System.out.println("Before getCustomerById");

	}

	@AfterReturning("deleteCustomerPointcut()")
	public void deleteCustomerAfterReturning() {
		System.out.println("Before deleteCustomer");

	}

	/*
	 * public List<Customer> getCustomerList();
	 * 
	 * public void addCustomer(Customer theCustomer);
	 * 
	 * public Customer getCustomerById(int id);
	 * 
	 * public void deleteCustomer(int id);
	 */

}
