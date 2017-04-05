package com.cheungchan.ch2.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoPublisher {

	@Autowired// 注入applicationContext来发布事件
	ApplicationContext applicationContext;
	
	public void publish(String msg){
		applicationContext.publishEvent(new DemoEvent(this, msg));// 使用applicationContext的publishEvent方法来发布事件。
	}
}
