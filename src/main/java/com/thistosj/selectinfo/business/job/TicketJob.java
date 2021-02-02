package com.thistosj.selectinfo.business.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 抢票任务
 *
 * @author lgq
 */
@DisallowConcurrentExecution
@Slf4j
public class TicketJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {


    }
}
