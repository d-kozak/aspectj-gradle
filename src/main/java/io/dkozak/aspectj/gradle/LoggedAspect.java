package io.dkozak.aspectj.gradle;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@org.aspectj.lang.annotation.Aspect
public class LoggedAspect {

    @Pointcut("@annotation(logged)")
    public void callAt(Logged logged) {
    }

    @Around("callAt(logged)")
    public Object around(ProceedingJoinPoint pjp, Logged logged) throws Throwable {
        Object[] args = pjp.getArgs();
        System.out.println(pjp.getSignature() + " call at with args " + Arrays.toString(args));
        return pjp.proceed();
    }

}
