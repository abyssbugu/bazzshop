package com.abyss.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Abyss on 2018/5/19.
 * description:
 */
@Component("logAspectXml")
@Aspect//表示该类为切面类
public class LogAspectXml {
    @Before("execution(* com.abyss.dao.CategoryDao.save(..))")
    public void writeLog() {
        System.out.println("记录日志...");
    }
    /**
     * 前置通知方法 应用场景： 权限控制 （权限不足，抛出异常）、 记录方法调用信息日志
     * joinPoint:连接点，指的是被增强的那个方法
     */
//    public void before(JoinPoint joinPoint) {
//        String username = "rose";
//        if (!"admin".equals(username)) {
//            // 非admin用户，不具备权限，抛出异常
//            //joinPoint.getTarget().getClass().getName()获取目标类的名字
//            //joinPoint.getSignature().getName()获取被增强方法的名字
//            throw new RuntimeException("对不起！您没有对" + joinPoint.getTarget().getClass().getName() + "类中"
//                    + joinPoint.getSignature().getName() + "方法的访问权限");
//        }
//    }
    /**
     * 后置通知方法
     * 应用场景： ATM取款机取款后，自动下发短信
     * 参数result:被增强那个方法的返回值
     */
    @AfterReturning(value="execution(* com.abyss.dao.CategoryDao.save(..))",returning = "result")
    public void afterReturning(Object result){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        System.out.println("尊敬的用户，您于" + dateStr + "取款" + result + "元");
    }

    /**
     * 环绕通知方法
     * 应用场景：事务处理
     * @param proceedingJoinPoint 正在执行的连接点
     * @return
     */
    @Around("execution(* com.abyss.dao.CategoryDao.findCategoryById(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("开启事务");
        //获取目标方法的参数
        Object[] args = proceedingJoinPoint.getArgs();
        Object result = null;
        try {
            //调用目标方法，获取目标方法的返回值
            result = proceedingJoinPoint.proceed(args);
            System.out.println("提交事务");
        } catch (Throwable e) {
            System.out.println("回滚事务");
        }
        //返回目标方法的返回值
        return result;
    }

    @AfterThrowing(value = "execution(* com.abyss.dao.CategoryDao.error(..))",throwing = "ex")
    public void afterthrowing(JoinPoint joinPoint,Throwable ex) {
        System.out.println("注意了:在" + joinPoint.getTarget().getClass().getName() + "中的"
                + joinPoint.getSignature().getName() + "方法中发生了异常：" + ex.getMessage());
    }

}
