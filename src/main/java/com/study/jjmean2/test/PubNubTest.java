package com.study.jjmean2.test;

import com.pubnub.api.PNConfiguration;
import com.pubnub.api.PubNub;
import com.pubnub.api.callbacks.PNCallback;
import com.pubnub.api.models.consumer.PNPublishResult;
import com.pubnub.api.models.consumer.PNStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by ljw on 2017. 5. 4..
 */
@Slf4j
public class PubNubTest {
    private PubNub pubnub;
    @Before
    public void prepare() {
        PNConfiguration config = new PNConfiguration()
                .setPublishKey("pub-c-51bd7435-48b0-412b-a928-8ce793a16e61")
                .setSubscribeKey("sub-c-e33728a2-a4bf-11e6-a756-02ee2ddab7fe")
                .setSecretKey("sec-c-MTMxY2ViMTctMDc2OS00NjQ3LTk4OTgtNTQ5NjZmOWE4Njc5")
                .setUuid("java-study-instance");

        pubnub = new PubNub(config);
    }

    @Test
    public void test() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
        pubnub.publish()
                .channel("[courier]order@login-user")
                .message("Hi, it's Java")
                .async(new PNCallback<PNPublishResult>() {
                    @Override
                    public void onResponse(PNPublishResult result, PNStatus status) {
                        log.debug(result.toString());
                        log.debug(status.toString());
                        latch.countDown();
                    }
                });
        latch.await(5, TimeUnit.SECONDS);
    }
}
