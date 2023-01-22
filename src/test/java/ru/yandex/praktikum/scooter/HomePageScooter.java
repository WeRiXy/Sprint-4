package ru.yandex.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageScooter {
    private WebDriver driver;

    //Логотип Яндекс
    private By logoYandex = By.xpath("//a[contains(@class,'Header_LogoYandex')]");
    //Логотип Самокат
    private By logoScooter = By.xpath("//a[contains(@class,'Header_LogoScooter')]");
    //Кнопка Заказать в шапке страницы
    private By orderHeaderButton = By.cssSelector(".Header_Nav__AGCXC .Button_Button__ra12g");
    //Кнопка Заказать в контенте сайта
    private By orderFooterButton  = By.cssSelector(".Home_FinishButton__1_cWm .Button_Button__ra12g");

    public HomePageScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Нажать кнопку Заказать в шапке страницы
    public void clickOrderHeaderButton() {
        driver.findElement(orderHeaderButton).click();
    }
    //Нажать кнопку Заказать в контенте сайта
    public void clickOrderFooterButton() {
        driver.findElement(orderFooterButton).click();
    }
    //Нажатие на логотип Яндекс
    public void clickLogoYandex() {
        driver.findElement(logoYandex).click();
    }
    //Нажатие на логотип Самокат
    public void clickLogoScooter() {
        driver.findElement(logoScooter).click();
    }
}