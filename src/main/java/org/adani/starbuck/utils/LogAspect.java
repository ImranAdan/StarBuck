package org.adani.starbuck.utils;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//TODO: Change the log aspect or create other ones
@Aspect
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);


    @Before("execution(* org.adani.starbuck.data.core.sources.queryable.*.*(..))")
    public void onEntry(JoinPoint jp) {
        String args = getJointPointArgs(jp);
        String actionMessage = "ENTRY~>[\n" +
                "DECLARING TYPE: " + jp.getSignature().getDeclaringTypeName() + "\n" +
                        "" + jp.getSignature().getName() +"(..) -> " + args + "]";
        LOGGER.info(actionMessage);
    }

    @After("execution(* org.adani.starbuck.data.core.sources.queryable.*.*(..))")
    public void onExit(JoinPoint jp) {
        String args = getJointPointArgs(jp);
        String actionMessage = "EXIT ~> [ " + jp.getSignature().getDeclaringTypeName() + "::" + jp.getSignature().getName() +"(..) -> " + args + "]";
        LOGGER.info(actionMessage);
    }

    @AfterThrowing(pointcut = "execution(* org.adani.starbuck.data.core.sources.queryable.*.*(..))", throwing = "ex")
    public void onExceptionThrown(JoinPoint jp, Throwable ex) {
        String fault = "EXCEPTION [ " + ex.getMessage() + " ]";
        LOGGER.info(fault);
        String args = getJointPointArgs(jp);
        String actionMessage = fault + " ~> EXIT ~> [ " + jp.getSignature().getDeclaringTypeName() + "::" + jp.getSignature().getName() +"(..) ~> " + args +"]";
        LOGGER.info(actionMessage);
    }

    private String getJointPointArgs(JoinPoint jp) {
        String actionArgs = "ARGS: [";
        for (int i = 0; i < jp.getArgs().length; ++i) {
            if (i == jp.getArgs().length - 1)
                actionArgs += jp.getArgs()[i].toString();
            else
                actionArgs += jp.getArgs()[i].toString() + ",";
        }
        actionArgs += "]";
        return actionArgs;
    }

}
