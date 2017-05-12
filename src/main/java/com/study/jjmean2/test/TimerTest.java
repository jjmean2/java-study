package com.study.jjmean2.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by ljw on 2017. 5. 11..
 */
class TimerCount {
    private int index;
    int count;
    TimerCount(int index) {
        this.index = index;
        this.count = 0;
    }
    int getIndex() {
        return index;
    }
}

@Slf4j
public class TimerTest {
    @Test
    public void test() throws Exception {

        int number = 50000;
        long now = new Date().getTime();

        CountDownLatch latch = new CountDownLatch(number);
        Timer timer = new Timer();

        IntStream.range(0, number)
                .mapToObj(i -> new TimerCount(i))
                .map(count ->
                        new TimerTask() {
                            @Override
                            public void run() {
                                count.count += 1;
                                long later = new Date().getTime();
                                log.debug("passed: {},\tthread: {},\tindex: {}\t(count: {})", later - now, Thread.currentThread().getName(), count.getIndex(), count.count);
                            }
                        }
                ).forEach(task -> {
            int delay = (int) (Math.random() * 10000) + 1;
            timer.schedule(task, delay, delay);
        });


//        latch.await(30, TimeUnit.SECONDS);
        latch.await();
    }

    @Test
    public void testThread() throws Exception {

        int number = 2000;
        long now = new Date().getTime();

        CountDownLatch latch = new CountDownLatch(number);

        IntStream.range(0, number).mapToObj(i ->
                new Thread(
                        () -> {
                            int delay = (int) (Math.random() * 10);
                            try {
                                TimeUnit.SECONDS.sleep(delay);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            long later = new Date().getTime();
                            log.debug("passed: {}, thread: {}, index: {}", later - now, Thread.currentThread().getName(), i);
                            latch.countDown();
                        }
                )
        ).forEach(thread -> thread.start());

        latch.await(30, TimeUnit.SECONDS);
    }

    @Test
    public void testScheduledExecutor() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleWithFixedDelay(() -> log.debug("{}", "HiHI"), 3, 3, TimeUnit.SECONDS);
        latch.await(30, TimeUnit.SECONDS);
    }

}

