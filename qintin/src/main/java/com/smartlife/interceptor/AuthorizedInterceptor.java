package com.smartlife.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * 判断用户权限的Spring MVC的拦截器
 */
public class AuthorizedInterceptor implements HandlerInterceptor {
	
	String TAG = "AuthorizedInterceptor";

	/** 定义不需要拦截的请求 */
	private static final String[] IGNORE_URI = {"/loginForm", "/login","/404.html"};
	
	 /** 
     * 该方法需要preHandle方法的返回值为true时才会执行。
     * 该方法将在整个请求完成之后执行，主要作用是用于清理资源。
     */  
	@Override
	public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		//System.out.print(TAG+" afterCompletion request="+request+" response="+response+"\n");
		
	}

	 /** 
     * 这个方法在preHandle方法返回值为true的时候才会执行。
     * 执行时间是在处理器进行处理之 后，也就是在Controller的方法调用之后执行。
     */  
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView mv) throws Exception {
		//System.out.print(TAG+" postHandle request="+request+" response="+response+"\n");
	}

	 /** 
     * preHandle方法是进行处理器拦截用的，该方法将在Controller处理之前进行调用，
     * 当preHandle的返回值为false的时候整个请求就结束了。 
     * 如果preHandle的返回值为true，则会继续执行postHandle和afterCompletion。
     */  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
		//System.out.print(TAG+" preHandle request="+request+" response="+response+"\n");
		/** 默认用户没有登录 */
		/*boolean flag = false; 
	
		String servletPath = request.getServletPath();
		
        for (String s : IGNORE_URI) {
            if (servletPath.contains(s)) {
                flag = true;
                break;
            }
        }*/
      
        /*if (!flag){
        	
        	User user = (User) request.getSession().getAttribute(HrmConstants.USER_SESSION);
        	if(user == null){
        		request.setAttribute("message", "请先登录再访问网站!");
        		request.getRequestDispatcher(HrmConstants.LOGIN).forward(request, response);
        		//return flag;
        		return true;
        	}else{
        		 flag = true;
        	}
        }*/
        //return flag;
		return true;
		
	}
		
}
