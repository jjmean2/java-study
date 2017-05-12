package com.study.jjmean2.service;

import org.springframework.core.task.TaskExecutor;

/**
 * Created by ljw on 2017. 5. 12..
 */
public class TaskExecutorExample {

    private class MessagePrinterTask implements Runnable {
        private String message;

        public MessagePrinterTask(String message) {
            this.message = message;
        }

        public void run() {
            System.out.println("thread: " + Thread.currentThread().getName());
            System.out.println(message);
            System.out.println();
        }
    }

    private TaskExecutor taskExecutor;

    public TaskExecutorExample(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void printMessages() {
        for (int i = 0; i < 25; i++) {
            taskExecutor.execute(new MessagePrinterTask("Message" + i));
        }
    }
}
