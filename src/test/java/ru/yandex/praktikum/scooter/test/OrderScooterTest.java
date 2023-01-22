package ru.yandex.praktikum.scooter.test;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.yandex.praktikum.scooter.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RunWith(Parameterized.class)
public class OrderScooterTest {
    private WebDriver driver;

    private final String orderButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String telephone;
    private final String metro;
    private final String dateOfDelivery;
    private final String rent;
    private final String colour;
    private final String comment;


    public OrderScooterTest(String orderButton, String name, String surname, String address, String metro, String telephone, String dateOfDelivery, String rent, String colour, String comment) {
        this.orderButton = orderButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.telephone = telephone;
        this.dateOfDelivery = dateOfDelivery;
        this.rent = rent;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                {"Кнопка Заказать - в шапке","Петр", "Петров", "Мира 1", "Лубянка", "12345678901",new SimpleDateFormat("dd.MM.yyyy").format(new Date()),"четверо суток","чёрный жемчуг","test"},
        };
          //      {"Светлана", "Света", "Светлая", "Лубянка", "12345678901"},
        }

    @Test
    public void HomeFAQTest() {
        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        //driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePageScooter objHomePageScooter = new HomePageScooter(driver);

        if (orderButton.equals("Кнопка Заказать - в шапке")) {
            objHomePageScooter.clickOrderHeaderButton();
        }
        else if (orderButton.equals("Кнопка Заказать - в контексте")) {
            objHomePageScooter.clickOrderFooterButton();
        }

        PageForWhomScooter objPageForWhomScooter = new PageForWhomScooter(driver);
        objPageForWhomScooter.waitForPageUploaded();
        objPageForWhomScooter.setForWhomScooter(name, surname, address, metro, telephone);
        objPageForWhomScooter.clickNextButton();

        PageAboutRent objPageAboutRent = new PageAboutRent(driver);
        objPageAboutRent.waitForPageUploaded();
        objPageAboutRent.setAboutRent(dateOfDelivery,rent,colour,comment);
        objPageAboutRent.clickOrderButton();

        WindowConfirmationOrder objwindowConfirmationOrder = new WindowConfirmationOrder(driver);
        objwindowConfirmationOrder.waitForWindowUploaded();
        objwindowConfirmationOrder.clickYesButton();

        WindowOrderNumber objWindowOrderNumber = new WindowOrderNumber(driver);
        objWindowOrderNumber.waitForWindowUploaded();
     }
    @After
    public void teardown() {
  //      driver.quit();
    }
}

