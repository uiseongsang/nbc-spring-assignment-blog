//package com.sparta.springlv2.aop;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//
//@Slf4j
//@Aspect
//@Component
//@RequiredArgsConstructor
//public class CheckExceptionAop {
//    @Pointcut("execution(* com.sparta.springlv2.controller.PostController.*(..))")
//    private void post() {}
//
//    @Before("post()")
//    public Object excute(ProceedingJoinPoint joinPoint) throws Throwable {
//        try {
//            Object output = joinPoint.proceed();
//            return output;
//        }finally {
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            if(auth == null) {
//                log.info("토큰 없음");
//            }
//            else {
//                log.info("토큰 있음");
//            }
//        }
//    }
//}
