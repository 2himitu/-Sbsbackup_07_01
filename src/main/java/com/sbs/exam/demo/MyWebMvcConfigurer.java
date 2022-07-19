package com.sbs.exam.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sbs.exam.demo.interceptor.BeforeActionInterceptor;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer{
	//beforActionInterceptor 인터셉터 불러오기
	@Autowired
	BeforeActionInterceptor beforeActionInterceptor;
	//이 함수는 인터셉터를 적용하는 역활
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(beforeActionInterceptor)
		.addPathPatterns("/**")//작동 할범위
		.excludePathPatterns("/resoure/**")//제외 할것 들
		.excludePathPatterns("/error");//제외 할것 들
	}
}
