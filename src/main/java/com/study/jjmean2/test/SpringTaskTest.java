package com.study.jjmean2.test;

import com.study.jjmean2.service.HelloWorld;
import com.study.jjmean2.service.TaskExecutorExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/**
 * Created by ljw on 2017. 5. 12..
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:Beans.xml")
public class SpringTaskTest {

    @Autowired
    HelloWorld helloWorld;

    @Autowired
    TaskExecutorExample example;

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.printMessage();
    }

    @Test
    public void test2() {
        example.printMessages();
    }


}
