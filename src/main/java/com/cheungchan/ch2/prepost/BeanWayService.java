package com.cheungchan.ch2.prepost;

public class BeanWayService {

	public void init(){
		System.out.println("@Bean使用initMethod");
	}
	
	public BeanWayService(){
		super();
		System.out.println("构造函数-BeanWayService");
	}
	
	public void destroy(){
		System.out.println("@Bean使用destroyMethod");
	}
}
