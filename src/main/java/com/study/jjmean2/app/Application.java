package com.study.jjmean2.app;

import com.study.jjmean2.task.JavaDaemonTask;
import com.study.jjmean2.task.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.Introspector;

/**
 * Created by ljw on 2017. 4. 28..
 */
@Slf4j
public class Application {

    Task mainTask;

    Application() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

        Class taskClass = JavaDaemonTask.class;

        String beanName = Introspector.decapitalize(taskClass.getSimpleName());
        log.debug("Bean Name: {}", beanName);

        Object bean = context.getBean(beanName);
        if (bean instanceof Task) {
            mainTask = (Task) bean;
        }
    }

    private void start() throws Exception {
        if (mainTask != null) {
            mainTask.execute();
        } else {
            log.error("Main Task is emtpy!!");
        }
    }

    public static void main(String[] args) throws Exception {
       new Application().start();
    }
}
