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
import java.lang.reflect.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.apache.commons.lang3.time.DateUtils.addDays;

@RunWith(Parameterized.class)
public class OrderScooterTest {
    private WebDriver driver;
    private final Method orderButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String telephone;
    private final String metro;
    private final String dateOfDelivery;
    private final String rent;
    private final String colour;
    private final String comment;

    public OrderScooterTest(Method orderButton, String name, String surname, String address, String metro, String telephone, String dateOfDelivery, String rent, String colour, String comment) {
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
    public static Object[][] getCredentials() throws NoSuchMethodException {
        return new Object[][] {
                {HomePageScooter.class.getDeclaredMethod("clickOrderHeaderButton"), "Петр", "Петров", "Мира 1", "Лубянка", "12345678901", new SimpleDateFormat("dd.MM.yyyy").format(new Date()), "четверо суток", "чёрный жемчуг", "test"},
                {HomePageScooter.class.getDeclaredMethod("clickOrderFooterButton"),"Ив", "Мистер", "Мира 2", "Комсомольская", "12345678901",new SimpleDateFormat("dd.MM.yyyy").format(addDays(new Date(),1)),"сутки","серая безысходность",""},
        };
    }

    @Test
    public void orderScooterTest() throws InvocationTargetException, IllegalAccessException {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomePageScooter objHomePageScooter = new HomePageScooter(driver);
        orderButton.invoke(objHomePageScooter);

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
         driver.quit();
    }
}

