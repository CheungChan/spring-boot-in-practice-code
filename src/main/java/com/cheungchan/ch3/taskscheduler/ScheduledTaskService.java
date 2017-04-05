package com.cheungchan.ch3.taskscheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTaskService {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate=5000) // 使用Scheduled声明该方法是定时任务，使用fixedRate属性每隔固定的时间来执行。
	public void reportCurrentTime(){
		System.out.println("每隔五秒执行一次" + dateFormat.format(new Date()));
	}
	
	@Scheduled(cron="0 56 21 ? * *")// 使用cron使方法在指定时间执行
	public void fixTimeExcution(){
		System.out.println("在指定时间  " + dateFormat.format(new Date()) + "执行");
	}
}
