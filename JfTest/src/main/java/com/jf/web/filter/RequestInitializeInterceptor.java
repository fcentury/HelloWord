package com.jf.web.filter;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class RequestInitializeInterceptor extends HandlerInterceptorAdapter {
	
	private List<String> excludedUrls;
	
	public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) {
        try {
        	for(String excludedUrl : excludedUrls){
        		System.out.println("##preHandle-" + excludedUrl);
        	}
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    	System.out.println("##postHandle");
    	if(modelAndView != null){
    		modelAndView.addObject("now",new Date());
    	}
        super.postHandle(request, response, handler, modelAndView);
    }

    public static void main(String[] args) {
    }
}
