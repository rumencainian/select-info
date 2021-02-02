package com.thistosj.selectinfo.config;

import com.thistosj.selectinfo.business.job.TicketJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 任务调度配置
 *
 * @author lgq
 */
@Configuration
public class ScheduleConfiguration {
    /**
     * 抢票调度
     */
    public static class TicketJobConfiguration {

        @Bean
        public JobDetail ticketJob() {
            return JobBuilder.newJob(TicketJob.class)
                    .withIdentity("ticketJob") // 名字为 ticketJob
                    .storeDurably() // 没有 Trigger 关联的时候任务是否被保留。因为创建 JobDetail 时，还没 Trigger 指向它，所以需要设置为 true ，表示保留。
                    .build();
        }

        @Bean
        public Trigger ticketJobTrigger() {
            // 简单的调度计划的构造器
            SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(5) // 频率。
                    .repeatForever(); // 次数。
            // Trigger 构造器
            return TriggerBuilder.newTrigger()
                    .forJob(ticketJob()) // 对应 Job 为 ticketJob
                    .withIdentity("ticketJobTrigger") // 名字为 demoJob01Trigger
                    .withSchedule(scheduleBuilder) // 对应 Schedule 为 scheduleBuilder
                    .build();
        }

    }

    /**
     * 抢茅台调度
     */
    public static class grabMTJobConfiguration {

        @Bean
        public JobDetail grabMTJob() {
            return JobBuilder.newJob(TicketJob.class)
                    .withIdentity("grabMTJob") // 名字为 ticketJob
                    .storeDurably() // 没有 Trigger 关联的时候任务是否被保留。因为创建 JobDetail 时，还没 Trigger 指向它，所以需要设置为 true ，表示保留。
                    .build();
        }

        @Bean
        public Trigger grabMTTrigger() {
            // 简单的调度计划的构造器
            SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(5) // 频率。
                    .repeatForever(); // 次数。
            // Trigger 构造器
            return TriggerBuilder.newTrigger()
                    .forJob(grabMTJob()) // 对应 Job 为 ticketJob
                    .withIdentity("ticketJobTrigger") // 名字为 demoJob01Trigger
                    .withSchedule(scheduleBuilder) // 对应 Schedule 为 scheduleBuilder
                    .build();
        }

    }
}
