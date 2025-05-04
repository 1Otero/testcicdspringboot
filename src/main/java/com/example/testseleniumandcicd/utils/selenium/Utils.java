package com.example.testseleniumandcicd.utils.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Utils {
    private ChromeDriver meChromeDriver;
    private WebDriverWait meWebDriverWait;
    public String initializerChrome(){
        ChromeOptions meChromeOptions= new ChromeOptions();
        meChromeOptions.addArguments("--headless");
//********************************************
//        meChromeOptions.addArguments("--new");
//      meChromeOptions.addArguments("--disable-gpu");
//      meChromeOptions.addArguments("--window-size=1920,1080");
//        meChromeOptions.addArguments("--no-sandbox");
//      meChromeOptions.addArguments("--disable-dev-shm-usage");
//        meChromeOptions.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/136.0.0.0 Safari/537.36");
//********************************************
//        // Si es necesario, usar un referrer de ADRES
//        //meChromeOptions.addArguments("--disable-blink-features=AutomationControlled");
//        //meChromeOptions.addArguments("--referer=https://www.adres.gov.co/");
////        meChromeOptions.addArguments("--disable-blink-features=AutomationControlled");
//        meChromeOptions.addArguments("--start-maximized");
//       meChromeOptions.addArguments("--disable-notifications");
//        meChromeOptions.addArguments("--ignore-certificate-errors");
//        meChromeOptions.addArguments("--disable-popup-blocking");
////        meChromeOptions.addArguments("--disable-extensions");
        meChromeDriver= new ChromeDriver(meChromeOptions);
        //meChromeDriver= new ChromeDriver();
        meWebDriverWait= new WebDriverWait(meChromeDriver, Duration.ofSeconds(10));
        meWebDriverWait.until(webDriver -> ((JavascriptExecutor) webDriver)
            .executeScript("return document.readyState").equals("complete"));
        return "Lol";
    }
    public String navigateInPagina(String pathWeb){
        System.out.println("wait element....");
        System.out.println(pathWeb);
        meChromeDriver.get(pathWeb);
        return "ReLol";
    }
    public String preparingElements(){
        WebElement iframeElement = meWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("MSOPageViewerWebPart_WebPartWPQ3"))); // Reemplaza con el id real del iframe
        meChromeDriver.switchTo().frame(iframeElement);
        meWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("tipoDoc")));
        //meWebDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("tipoDoc")));
        //meWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/div[@id='content']/form[@id='afiliado']/div/input[@id='tipoDoc']")));
        //meWebDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//html/body/div[@id='content']/form[@id='afiliado']/div/input[@id='tipoDoc']")));
        //meWebDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*/div[@id='content']/form[@id='afiliado']/div/input[@id='tipoDoc']")));
        //meWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='content']/form[@id='afiliado']/div/input[@id='tipoDoc']")));
        //meWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tipoDoc']")));
        //meWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tipoDoc']")));
        //meWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='tipoDoc']")));
        //meWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tipoDoc")));
        System.out.println("finally wait element!");
        return "superReLol";
    }
    public String fillInputsInWeb(String tipoDocumento, String numDocumento){
        // Esperar a que el iframe esté presente
        Select selectInput= new Select(meChromeDriver.findElement(By.id("tipoDoc")));
        //Select selectInput= new Select(meChromeDriver.findElement(By.xpath("//*[@id='tipoDoc']")));
        //selectInput.selectByIndex(0); //Seleciona segun el index del selectEnInput
        System.out.println("*************************************************");
        System.out.println("SelectInput:");
        System.out.println(selectInput.getOptions());
        System.out.println(selectInput.getFirstSelectedOption().getTagName());
        System.out.println(selectInput.getFirstSelectedOption().getText());
        //selectInput.
        selectInput.selectByValue(tipoDocumento);
        WebElement meWebElementInput= meChromeDriver.findElement(By.id("txtNumDoc"));
        String textInfoInput= meWebElementInput.getText();
        System.out.println(textInfoInput);
        meWebElementInput.clear();
        meWebElementInput.sendKeys(numDocumento);
        System.out.println("*************************************************");
        return "ReLolll";
    }
    public String preparingElementsDian(){
        //WebElement elementLoad= meWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("form.ng-valid[action='https://muisca.dian.gov.co/IdentidadRest_Acceso/api/sts/v1/auth/weblogin']")));
        WebElement elementLoad= meWebDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("form-container")));
        System.out.println(elementLoad.getText());
        return "ReMegaLol";
    }
    public String fillElementDian(){
        // 1. Hacer clic en el mat-select para abrir las opciones
        WebElement tipoDocumentoSelect = meWebDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("mat-select-0")));
        tipoDocumentoSelect.click();
        // 2. Esperar a que el panel de opciones sea visible
        WebElement panelOpciones = meWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mat-select-panel")));
        List<WebElement> listElementSelect= panelOpciones.findElements(By.tagName("mat-option"));
        System.out.println(listElementSelect.stream().count());
        for(WebElement w: listElementSelect){
            System.out.println("w.getText(): ");
            System.out.println(w.getText());
            System.out.println(".......");
            if(w.getText().trim().equals("Tarjeta de identidad")){
                System.out.println("me");
                System.out.println(w.getText());
                w.click();
                break;
            }
//            System.out.println("w.getText().trim(): ");
//            System.out.println(w.getText().trim());
//            if (w.getText().trim().equals("Tarjeta de identidad")) {
//                w.click();
//                System.out.println("w.click(): ");
//                break;
//            }
        }
        WebElement elementInput= meChromeDriver.findElement(By.name("numDocumento"));
        System.out.println("ElementInputNumDocumento: ");
        elementInput.sendKeys("1213213111");
        WebElement elementPasswInput= meChromeDriver.findElement(By.name("password"));
        System.out.println("elementPassw");
        elementPasswInput.sendKeys("remegalol");
        System.out.println(elementPasswInput.getText().trim());
        System.out.println("elementTypeCC");
        System.out.println(elementInput.getText().trim());
        return "ReMegaaaReLol";
    }
}
