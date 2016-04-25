package org.avol.spring.quartz;

import org.quartz.CronExpression;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Durga on 4/25/2016.
 */
public class JobLauncher
{
    public static void main(String[] args) throws ParseException {
        System.out.println("************* Starting Application context****************");
        new ClassPathXmlApplicationContext("quartz-config.xml");
        /*CronExpression cronExpression = new CronExpression("0 0 10 ? * *");
        Date date = cronExpression.getNextValidTimeAfter(new Date());
        System.out.println(date);*/
    }
}
