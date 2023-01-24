package ru.yandex.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageForWhomScooter {
    private WebDriver driver;

    //Поле ввода - Имя
    private By name = By.xpath(".//div[starts-with(@class,'Order_Form')]//input[contains(@placeholder,'Имя')]");
    //Поле ввода - Фамилия
    private By surname  = By.xpath(".//div[starts-with(@class,'Order_Form')]//input[contains(@placeholder,'Фамилия')]");
    //Поле ввода - Арес
    private By address  = By.xpath(".//div[starts-with(@class,'Order_Form')]//input[contains(@placeholder,'Адрес')]");
    //Поле ввода - Станция метро
    private By metro  = By.xpath(".//div[starts-with(@class,'Order_Form')]//input[contains(@placeholder,'метро')]");
    //Список станций метро
    private String xpathMetroPoint  = ".//div[starts-with(@class,'Order_Form')]//div[@class='select-search__select']//*[text()='МЕТРО']";
    //   private By metroList  = By.xpath(".//div[starts-with(@class,'Order_Form')]//div[@class='select-search__select']/div");
    //Поле ввода - Телефон
    private By telephone  = By.xpath(".//div[starts-with(@class,'Order_Form')]//input[contains(@placeholder,'Телефон')]");
    //Кнопка Далее
    private By next  = By.xpath(".//div[starts-with(@class,'Order_NextButton')]/button");

    public PageForWhomScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Ожидание загрузки страницы
    public void waitForPageUploaded() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(telephone));
    }

    //Ввод имени
    public void setName(String name) {
        driver.findElement(this.name).sendKeys(name);
    }
    //Ввод фамилии
    public void setSurname(String surname) {
        driver.findElement(this.surname).sendKeys(surname);
    }
    //Ввод адреса
    public void setAddress(String address) {
        driver.findElement(this.address).sendKeys(address);
    }
    //Выбор станции метро
    public void setMetro(String metro) {
        clickMetro();
        driver.findElement(By.xpath(xpathMetroPoint.replace("МЕТРО", metro))).click();
    }
    //Ввод телефона
    public void setTelephone(String telephone) {
        driver.findElement(this.telephone).sendKeys(telephone);
    }
    //Нажатие кнопки Далее
    public void clickNextButton() {
        driver.findElement(next).click();
    }
    //Нажатие на поле Метро для вывода списка метро
    public void clickMetro() {
        driver.findElement(metro).click();
    }

    //Заполнение всех данных на странице заказа "Для кого самокат"
    public void setForWhomScooter(String name, String surname, String address, String metro, String telephone){
        setName(name);
        setSurname(surname);
        setAddress(address);
        setMetro(metro);
        setTelephone(telephone);
    }
}
