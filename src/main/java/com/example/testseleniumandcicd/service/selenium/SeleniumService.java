package com.example.testseleniumandcicd.service.selenium;

import com.example.testseleniumandcicd.utils.selenium.Utils;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class SeleniumService {
    private Utils meUtils;
    private ChromeDriver meChromeDriver;
    private WebDriverWait meWebDriverWait;
    public String getInfoAdressWithSelenium(){
        this.meUtils= new Utils();
        String meInitialized= meUtils.initializerChrome();
        String meNavigation= meUtils.navigateInPagina("https://www.adres.gov.co/consulte-su-eps");
        String mePreparing= meUtils.preparingElements();
        String meFillInput= meUtils.fillInputsInWeb("CC", "123234234");
        return "Lol";
    }
    public String getInfoDian(){
        this.meUtils= new Utils();
        String meInitialized= meUtils.initializerChrome();
        String meNavigation= meUtils.navigateInPagina("https://muisca.dian.gov.co/WebIdentidadLogin/?ideRequest=eyJjbGllbnRJZCI6IldvMGFLQWxCN3ZSUF8xNmZyUEkxeDlacGhCRWEiLCJyZWRpcmVjdF91cmkiOiJodHRwOi8vbXVpc2NhLmRpYW4uZ292LmNvL0lkZW50aWRhZFJlc3RfTG9naW5GaWx0cm8vYXBpL3N0cy92MS9hdXRoL2NhbGxiYWNrP3JlZGlyZWN0X3VyaT1odHRwJTNBJTJGJTJGbXVpc2NhLmRpYW4uZ292LmNvJTJGV2ViQXJxdWl0ZWN0dXJhJTJGRGVmTG9naW4uZmFjZXMiLCJyZXNwb25zZVR5cGUiOiIiLCJzY29wZSI6IiIsInN0YXRlIjoiIiwibm9uY2UiOiIiLCJwYXJhbXMiOnsidGlwb1VzdWFyaW8iOiJtdWlzY2EifX0%3D");
        String preparingInfo= meUtils.preparingElementsDian();
        String fillInfoDian= meUtils.fillElementDian();
        return "ReMegaReLol";
    }
}
