package com.cheungchan.ch2.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {

	@PostConstruct
	public void init(){
		System.out.println("jsr250方式使用@PostConstruct");
	}
	public JSR250WayService(){
		System.out.println("构造函数-JSR250WayService");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("jsr250销毁使用@PreDestroy");
	}
}
