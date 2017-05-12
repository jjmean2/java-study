package com.study.jjmean2.test;

import com.study.jjmean2.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;
import java.util.Set;

/**
 * Created by ljw on 2017. 4. 28..
 */
public class ValidationTest {

    private Validator validator;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void test() {
        User user = new User();
        user.setFirstName("Ace");
//        user.setLastName("Bath");
        user.setAge(3);

        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        System.out.println(constraintViolations);

        Assert.assertEquals(1, constraintViolations.size());
        Assert.assertEquals("반드시 값이 있어야 합니다.", constraintViolations.iterator().next().getMessage());
    }
}
