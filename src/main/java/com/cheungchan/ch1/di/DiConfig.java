package com.cheungchan.ch1.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan("com.cheungchan.chi.di")
public class DiConfig {

	@Bean
	public FunctionService functionService(){//方法名就是注入的bean的名字
		return new FunctionService();
	}
	
//	@Bean
//	public UseFunctionService useFunctionService(){
//		UseFunctionService useFunctionService = new UseFunctionService();
//		useFunctionService.setFunctionService(functionService());//注入已经注入过的直接调用属性名的方法
//		return useFunctionService;
//	}
	
	@Bean
	public UseFunctionService useFunctionService(FunctionService functionService){//注入已经注入过的也可以用参数直接传入
		UseFunctionService useFunctionService = new UseFunctionService();
		useFunctionService.setFunctionService(functionService);
		return useFunctionService;
	}
}
