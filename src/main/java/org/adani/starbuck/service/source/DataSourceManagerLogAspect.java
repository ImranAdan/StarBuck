package org.adani.starbuck.service.source;

import org.adani.starbuck.utils.LogAspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class DataSourceManagerLogAspect extends LogAspect {


    @Before("execution(* org.adani.starbuck.data..*(..))")
    public void onEntry(JoinPoint jp) {
        super.onEntry(jp);
    }

}
