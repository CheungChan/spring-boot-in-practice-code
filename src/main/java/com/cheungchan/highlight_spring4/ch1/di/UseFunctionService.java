package com.cheungchan.highlight_spring4.ch1.di;

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
