package ru.yandex.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowOrderNumber {
    private WebDriver driver;

    //Текст - Заказ оформлен
    private By orderPlaced = By.xpath(".//div[starts-with(@class,'Order_Modal')]//div[text()='Заказ оформлен']");
    private By orderNumber = By.xpath(".//div[starts-with(@class,'Order_Modal')]//div[text()='Номер заказа']");
    //Кнопка Посмотреть статус
    private By statusButton = By.xpath(".//div[starts-with(@class,'Order_Modal')]//button[text()='Посмотреть статус']");

    public WindowOrderNumber(WebDriver driver) {
        this.driver = driver;
    }

    public void clickStatusButton() {
        driver.findElement(statusButton).click();
    }
    public void waitForWindowUploaded() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(orderPlaced));
    }
}