package com.cheungchan.ch1.di;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

//@Service
public class UseFunctionService {
	
//	@Resource
	FunctionService functionService;
	
	public String SayHello(String word){
		return functionService.sayHello(word);
	}


	public void setFunctionService(FunctionService functionService) {
		this.functionService = functionService;
	}
}
