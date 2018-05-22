package com.wj.lottery.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.wj.lottery.service.TimerTestService;

@Component
public class TimerTestResource {
	@Autowired
	private TimerTestService timerTestService;
	
	@Scheduled(fixedDelay = 2 * 60 * 60 * 1000)
	public void setCron() {
		timerTestService.setCron("0/10 * * * * ?");
	}
	
}
