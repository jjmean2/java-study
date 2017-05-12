package com.study.jjmean2.test;

import com.study.jjmean2.task.JavaDaemonTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ljw on 2017. 5. 12..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class JavaDaemonTest {

    @Autowired
    JavaDaemonTask task;

    @Test
    public void prepared() {
        assert task != null;
    }

    @Test
    public void test() throws Exception {
        task.execute();
    }
}
