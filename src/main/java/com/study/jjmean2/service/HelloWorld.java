package com.study.jjmean2.service;

import lombok.Data;

/**
 * Created by ljw on 2017. 5. 12..
 */
@Data
public class HelloWorld {
    private String message;
    public void printMessage() {
        System.out.println("YOur Message : " + message);
    }
}
