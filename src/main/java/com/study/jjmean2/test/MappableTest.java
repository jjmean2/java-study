package com.study.jjmean2.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by ljw on 2017. 5. 11..
 */
@Slf4j
public class MappableTest {

    @Test
    public void test() {
        List<Integer> list = IntStream.range(0, 100)
                .mapToObj(i -> i)
                .flatMap(i -> i % 3 == 0 ? Stream.of(i) : Stream.empty())
                .collect(Collectors.toList());

        log.debug("{}", list);

    }

    @Test
    public void testIntStream() {
        List<Integer> list = IntStream.range(0, 10)
                .boxed()
                .flatMap(i -> i % 3 == 0 ? Stream.of(i) : Stream.empty())
                .collect(Collectors.toList());

        log.debug("{}", list);


    }

}
