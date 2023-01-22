package ru.yandex.praktikum.scooter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.jetbrains.annotations.NotNull;

public class HomeFAQ {

    private WebDriver driver;

    //Строка xpath для блока Вопросы о важном
    private String pathHomeFAQ = ".//*[@class='Home_FAQ__3uVm4']//*[@class='accordion__item']";
    //Строка xpath для поиска блока с вопросом
    private String xpathQuestion = "//*[text()='QUESTION']";
    //Строка xpath для поиска ответа на выбранный вопрос
    private String xpathAnswer = xpathQuestion + "/parent::*/parent::*/*[@class='accordion__panel']/p";

    public HomeFAQ(WebDriver driver) {
        this.driver = driver;
    }

    //Получение локатора xpath для кнопки с необходимым вопросом

    //Получение локатора xpath для тест с необходимым вопросом
    private By getXpathQuestion(String question) {
        return By.xpath(pathHomeFAQ + xpathQuestion.replace("QUESTION",question));
    }
    //Получение локатора xpath для тест с ответом на выбранный вопрос
    private By getXpathAnswer(String question) {
        return By.xpath(pathHomeFAQ + xpathAnswer.replace("QUESTION",question));
    }
    //Нажатие на вопрос
    public void clickQuestion(String question) {
        driver.findElement(getXpathQuestion(question)).click();
    }
    //Получение текста вопроса
    public String getQuestion(@NotNull String question) {
        return driver.findElement(getXpathQuestion(question)).getText();
    }
    //Получение текста ответа
    public String getAnswer(@NotNull String question) {
        return driver.findElement(getXpathAnswer(question)).getText();
    }
    //Получение состояния видимости ответа
    public boolean isDisplayedAnswer(@NotNull String question) {
        return driver.findElement(getXpathAnswer(question)).isDisplayed();
    }
    //Прокрутка до вопроса
    public void scrollToQuestion(String question) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(getXpathQuestion(question)));

    }
}