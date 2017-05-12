package com.study.jjmean2.task;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by ljw on 2017. 5. 12..
 */
@Component
public class JavaDaemonTask implements Task {

    static PrintTask printTask = null;

    @Override
    public void execute() throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                printTask = null;
                System.out.println("Cleanup activity: PrintTask instance set to null");
            }
        }));

        printTask = new PrintTask("Hello World!!!! JOngwan");
        printTask.invokeIndefinitePrintTask();
    }
}

class PrintTask {
    String message;

    public PrintTask(String message) {
        this.message = message;
    }

    private void printMessage() {
        System.out.println("Message: " + message);
    }

    public void invokeIndefinitePrintTask() {
        while (true) {
            printMessage();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Caught an exception while sleeping.Description: " + e.getMessage());
            }
        }
    }
}