package com.crud.ideacrm.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
public class AuthAspect {
	
	//세션 로그인 체크 MG
	@Around("execution(* auth*(..))")
	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		

		Object[] args=joinPoint.getArgs();
				
				for(Object tmp:args){
					
					if(tmp instanceof HttpServletRequest){
				
						HttpServletRequest request=(HttpServletRequest)tmp;
				
						String userId = (String)request.getSession().getAttribute("USERID");
						if(userId==null){
							
							ModelAndView mView=new ModelAndView();
												
							String query=request.getQueryString();
							
							//원래 가야할 요청명 
							String url=null;
							if(query==null){
								url=request.getRequestURI();
							}else{
								url=request.getRequestURI()+"?"+query;
							}
							
							mView.setViewName("redirect:/login?url="+url);
							return mView;
						}
					}
				}
				
				return joinPoint.proceed();
			}
		}