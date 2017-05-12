package com.study.jjmean2.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Optional;

/**
 * Created by ljw on 2017. 5. 10..
 */
@Slf4j
public class BigDecimalTest {
    @Test
    public void testAdd() {
        BigDecimal a = null;
        BigDecimal b = BigDecimal.valueOf(1.2);
        BigDecimal c = BigDecimal.valueOf(30);
        BigDecimal d = null;

        BigDecimal result = Arrays.asList(a, b, c, d).stream()
                .reduce(BigDecimal.valueOf(0), (before, current) -> {
                    if (current == null) {
                        return before;
                    }

                    return before.add(current);
                });


        log.debug("{}", result);
    }
}
