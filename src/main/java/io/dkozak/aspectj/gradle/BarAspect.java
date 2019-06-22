package io.dkozak.aspectj.gradle;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Arrays;

@Aspect
public class BarAspect {
    @Pointcut(value = "execution(* Main.bar(String))")
    public void callAt() {
    }

    @Around("callAt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("BAR Aspect - " + pjp.getSignature() + " called with " + Arrays.toString(pjp.getArgs()));
        Object retVal = pjp.proceed();
        System.out.println("BAR Aspect  - Return value is " + retVal);
        return retVal;
    }
}
