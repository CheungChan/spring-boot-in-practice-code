package com.cheungchan.ch2.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent>{// 使用泛型可以只监听泛型指定的事件。

	@Override
	public void onApplicationEvent(DemoEvent event) {
		String msg = event.getMsg();
		System.out.println("我（bean-demoListener)接受到了bean-demoPublisher发布的消息：" + msg);
		
	}
	

}
