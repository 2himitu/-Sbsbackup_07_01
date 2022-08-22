package com.sbs.exam.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sbs.exam.demo.interceptor.BeforeActionInterceptor;
import com.sbs.exam.demo.interceptor.NeedLoginInterceptor;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer{
	//beforActionInterceptor 인터셉터 불러오기
	@Autowired
	BeforeActionInterceptor beforeActionInterceptor;
	
	@Autowired
	NeedLoginInterceptor needLoginInterceptor;
	//이 함수는 인터셉터를 적용하는 역활
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(beforeActionInterceptor)
		.addPathPatterns("/**")//작동 할범위
		.excludePathPatterns("/resoure/**")//제외 할것 들
		.excludePathPatterns("/error");//제외 할것 들
		
		registry.addInterceptor(needLoginInterceptor)
		.addPathPatterns("/usr/article/write")
		.addPathPatterns("/usr/article/doWrite")
		.addPathPatterns("/usr/article/modify")
		.addPathPatterns("/usr/article/doModify")
		.addPathPatterns("/usr/article/doDelete")
		.addPathPatterns("/usr/article/doGoodReaction")
		.addPathPatterns("/usr/article/doBadReaction");
	}
}
