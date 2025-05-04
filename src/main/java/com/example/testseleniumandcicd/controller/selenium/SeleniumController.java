package com.example.testseleniumandcicd.controller.selenium;

import com.example.testseleniumandcicd.service.selenium.SeleniumService;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.Duration;

@RestController
@RequestMapping("/api/selenium")
public class SeleniumController {
    @Autowired
    private SeleniumService meSeleniumService;
    @GetMapping("/")
    public String getInfoAdressWithSelenium(){
        String meLol= meSeleniumService.getInfoAdressWithSelenium();
        System.out.println("meLol: ");
        System.out.println(meLol);
        return "Lol";
    }
    @GetMapping("/dian")
    public String getInfoDianWithSelenium(){
        String meInfoDian= meSeleniumService.getInfoDian();
        return meInfoDian;
    }
}
