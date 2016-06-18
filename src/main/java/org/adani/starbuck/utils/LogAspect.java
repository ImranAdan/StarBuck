package org.adani.starbuck.utils;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * TODO: Currently this advices no one need to advice as follows: @Before("execution(* org.adani.starbuck.data.core.sources.{CLASS_NAME}.*.*(..))")
 *
 *
 *
 */
@Aspect
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);


    protected void onEntry(JoinPoint jp) {
        String args = getJointPointArgs(jp);
        String actionMessage = "ENTRY:[" + jp.getSignature().getDeclaringTypeName() + "," + jp.getSignature().getName() + "(..) -> " + args + "]";
        LOGGER.info(actionMessage);
    }

    @After("execution(* org.adani.starbuck.data.core.sources.queryable.*.*(..))")
    protected void onExit(JoinPoint jp) {
        String args = getJointPointArgs(jp);
        String actionMessage = "EXIT:[" + jp.getSignature().getDeclaringTypeName() + "::" + jp.getSignature().getName() +"(..) -> " + args + "]";
        LOGGER.info(actionMessage);
    }

    @AfterThrowing(pointcut = "execution(* org.adani.starbuck.data.core.sources.queryable.*.*(..))", throwing = "ex")
    protected void onExceptionThrown(JoinPoint jp, Throwable ex) {
        String fault = "EXCEPTION [ " + ex.getMessage() + " ]";
        LOGGER.info(fault);
        String args = getJointPointArgs(jp);
        String actionMessage = fault + " ~> EXIT ~> [ " + jp.getSignature().getDeclaringTypeName() + "::" + jp.getSignature().getName() +"(..) ~> " + args +"]";
        LOGGER.info(actionMessage);
    }

    private String getJointPointArgs(JoinPoint jp) {
        String actionArgs = "[";

        for (Object o: jp.getArgs())
            actionArgs += o.toString();

        actionArgs = actionArgs.substring(actionArgs.length() - 1) +  "]";

        return actionArgs;
    }

}
