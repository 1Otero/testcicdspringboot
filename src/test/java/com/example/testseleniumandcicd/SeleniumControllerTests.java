package com.example.testseleniumandcicd;

import com.example.testseleniumandcicd.controller.selenium.SeleniumController;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeleniumControllerTests {
    @Autowired
    private SeleniumController meSeleniumController;
    @Test
    public void fistTest(){
        Assert.assertEquals(meSeleniumController.getInfoAdressWithSelenium(), "Lol");
    }
    @Test
    public void secondTest(){
        Assert.assertEquals(meSeleniumController.getInfoDianWithSelenium(), "ReMegaReLol");
    }
}
