package ru.yandex.praktikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PageAboutRent {
    private WebDriver driver;

    //Поле - * Когда привезти самокат
    private By dateOfDelivery = By.xpath(".//div[starts-with(@class,'Order_Form')]//input[contains(@placeholder,'Когда')]");
    //Календарь после клика по полю "* Когда привезти самокат"
    private By todayOfCalendar = By.cssSelector(".react-datepicker__day--today");
    //Поле - * Срок аренды
    private By rent  = By.xpath(".//div[starts-with(@class,'Order_Form')]//div[contains(text(),'аренд')]");
    //Список возможных сроков аренды
    private By rentalPeriod  = By.xpath(".//div[starts-with(@class,'Order_Form')]//div[@class='Dropdown-menu']/div");
    //Чекбоксы с выбором цвета самоката
    private By colourBlack  = By.xpath(".//div[starts-with(@class,'Order_Form')]//label[text()='чёрный жемчуг']/input[@type='checkbox']");
    private By colourGray  = By.xpath(".//div[starts-with(@class,'Order_Form')]//label[text()='серая безысходность']/input[@type='checkbox']");
    // private By colour2  = By.xpath(".//div[starts-with(@class,'Order_Form')]//label[2]/input[@type='checkbox']");
    //Поле - Комментарий для курьера
    private By comment  = By.xpath(".//div[starts-with(@class,'Order_Form')]//input[contains(@placeholder,'Комментарий')]");
    //Кнопка Назад
    private By back  = By.xpath(".//div[starts-with(@class,'Order_Buttons')]//button[text()='Назад']");
    //Кнопка Заказать
    private By order  = By.xpath(".//div[starts-with(@class,'Order_Buttons')]//button[text()='Заказать']");
    //private By orderHeader  = By.xpath(".//div[starts-with(@class,'Header_Nav')]//button[text()='Заказать']");

    public PageAboutRent(WebDriver driver) {
        this.driver = driver;
    }

    //Ожидание загрузки страницы
    public void waitForPageUploaded() {
        // здесь нужно дождаться, чтобы текст в элементе «Занятие» стал равен значению из параметра
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(order));
    }

    //Ввод в поле * Когда привезти самокат
    public void setDateOfDelivery(String date) {
        driver.findElement(this.dateOfDelivery).sendKeys(date);
        driver.findElement(this.dateOfDelivery).sendKeys(Keys.RETURN);
    }

    //Выбор из списка срока аренды
    public void setRent(String period) {
        driver.findElement(this.rent).click();
        List<WebElement> webList =  driver.findElements(this.rentalPeriod);
        for(WebElement e:webList) {
            if(period.equals(e.getText())) {
                e.click();
                return;
            }
        }
    }

    //Установка чекбокса с нужным цветом
    public void setColour(String colour) {
        if (colour.equals("чёрный жемчуг")) {
            driver.findElement(this.colourBlack).click();
        }
        else if (colour.equals("серая безысходность")) {
            driver.findElement(this.colourGray).click();
        }
    }

    //Ввод в поле Комментарий для курьера
    public void setComment(String comment) {
        driver.findElement(this.comment).sendKeys(comment);
    }

    //Клик по полю * Когда привезти самокат
    public void clickDateOfCalendar(By date) {
        driver.findElement(date).click();
    }
    //Нажатие кнопки Назад
    public void clickBackButton() {
        driver.findElement(back).click();
    }
    //Нажатие кнопки Заказать
    public void clickOrderButton() {
        driver.findElement(order).click();
    }
    //Заполнение всех данных на странице заказа "Про аренду"
    public void setAboutRent(String date, String rentalPeriod, String colour, String comment){
        setDateOfDelivery(date);
        setRent(rentalPeriod);
        setColour(colour);
        setComment(comment);
    }
}
