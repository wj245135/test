package com.wj.lottery.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class TimerTestService  implements SchedulingConfigurer  {
	
	private static final String DEFAULT_CRON = "0/5 * * * * ?";
	private String cron = DEFAULT_CRON;
	
	private static final Logger logger = LoggerFactory.getLogger(TimerTestService.class);

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		 taskRegistrar.addTriggerTask(new Runnable() {  
	            @Override  
	            public void run() {  
	                // 任务逻辑  
	                logger.error("dynamicCronTask is running..." + new Date());  
	            }  
	        }, new Trigger() {  
	            @Override  
	            public Date nextExecutionTime(TriggerContext triggerContext) {  
	                // 任务触发，可修改任务的执行周期  
	                CronTrigger trigger = new CronTrigger(cron);  
	                Date nextExec = trigger.nextExecutionTime(triggerContext);  
	                return nextExec;  
	            }  
	        });  
	}
	
	/**
	 * 动态设置定时任务的时间
	 */
	public void setCron(String cron) {
		this.cron = cron;
	}
}
