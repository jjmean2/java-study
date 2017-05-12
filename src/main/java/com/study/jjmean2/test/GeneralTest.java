package com.study.jjmean2.test;

import io.reactivex.Observable;
import javafx.util.Pair;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * Created by ljw on 2017. 4. 28..
 */
@Slf4j
public class GeneralTest {

    @Test
    public void test() {
        int dan = 3;
        for (int row = 1; row <= 9; ++row) {
            System.out.println(dan + " * " + row + " = " + (dan * row));
        }
    }

    @Test
    public void test2() {
        int dan = 9;
        IntStream.range(0, 9)
                .map(i -> i + 1)
                .forEach(i -> System.out.println(dan + " * " + i + " = " + dan * i));
    }

    @Test
    public void testSplit() {
        String material = "[courier]order@courier-id#01";
        String[] result = material.split("[\\[\\]@#]");
        System.out.println(result);
        for (String component : result) {
            log.debug(component);
        }

    }

    @Test
    public void testExtract() {
        String material = "courier=order@courier-id#01";
        Matcher m = Pattern.compile("\\[([^]]*)]").matcher(material);
        while(m.find()) {
            log.debug(m.group(1));
        }

    }
}
