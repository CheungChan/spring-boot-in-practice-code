package com.cheungchan.highlight_spring4.ch2.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {

	@Bean
	@Profile("dev")// Profile为dev时实例化devDemoBean
	public DemoBean devDemoBean(){
		return new DemoBean("from development profile");
	}
	
	@Bean
	@Profile("prod")// Profile为prod时实例化prodDemoBean
	public DemoBean prodDemoBean(){
		return new DemoBean("from projuction profile");
	}
}
