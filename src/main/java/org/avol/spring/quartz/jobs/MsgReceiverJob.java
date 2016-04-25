package org.avol.spring.quartz.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.StopWatch;

/**
 * Created by Durga on 4/25/2016.
 */
public class MsgReceiverJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("MsgReceiverJob.executeInternal");
    }

    public void startJob() {
        Long startTime = System.currentTimeMillis();
        Long threadId = Thread.currentThread().getId();
        System.out.println("Current Thread ID: " + threadId);
        for (int i = 0; i < 10; i++) {
            System.out.println("Receiving msg id: " + i + " by ThreadId: " + threadId);
            try {
                Thread.sleep(1000);//
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total time take by threadId:" + threadId + " is " + (System.currentTimeMillis() - startTime));
    }
}
