package ru.yandex.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowConfirmationOrder {
    private WebDriver driver;

    //Кнопка Да
    private By yesButton = By.xpath(".//div[starts-with(@class,'Order_Modal')]//button[text()='Да']");
    //Кнопка Нет
    private By noButton  = By.xpath(".//div[starts-with(@class,'Order_Modal')]//button[text()='Нет']");

    public void waitForWindowUploaded() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(yesButton));
    }
    public WindowConfirmationOrder(WebDriver driver) {
        this.driver = driver;
    }
    //Нажатие кнопки Да
    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    //Нажатие кнопки Нет
    public void clickNoButton() {
        driver.findElement(noButton).click();
    }
}
