package com.study.jjmean2.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ljw on 2017. 4. 28..
 */
@Data
public class User {

    @NotNull
    private String firstName;

    @NotNull
    @Size(min = 2, max = 14)
    private String lastName;

    @Min(2)
    private int age;

}
