package com.cheungchan.ch2.el;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ELconfig.class);
		
		ELconfig resourceService = context.getBean(ELconfig.class);
		resourceService.outputResource();
		
		context.close();

	}

}
