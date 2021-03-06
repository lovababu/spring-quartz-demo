package org.avol.spring.quartz.jobs;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.StopWatch;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Durga on 4/25/2016.
 */
public class MsgSenderJob extends QuartzJobBean {

    private BlockingDeque<String> blockingDeque;

    public BlockingDeque<String> getBlockingDeque() {
        return blockingDeque;
    }

    public void setBlockingDeque(BlockingDeque<String> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        System.out.println("MsgSenderJob.executeInternal");

    }

    public void startJob() {
        long startTime = System.currentTimeMillis();
        Long threadId = Thread.currentThread().getId();
        System.out.println("Current Thread ID: " + threadId);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("Sender");
        /*for (int i = 0; i < 10; i++) {*/
            /*System.out.println("Sending msg id: " + i + " by Thread: " + threadId);*/
            try {
                blockingDeque.put(threadId + " Says Hello");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        /*}*/
        System.out.println("Total time take by threadId:" + threadId + " is " + (System.currentTimeMillis() - startTime));
    }
}
