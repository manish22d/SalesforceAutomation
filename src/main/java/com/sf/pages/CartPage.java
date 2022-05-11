package com.sf.pages;

import com.sf.constant.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "saved-payment-security-code")
    WebElement cvvTextBox;

    @FindBy(css = ".checkout-btn")
    WebElement checkoutBtn;

    @FindBy(css = ".submit-shipping")
    WebElement submitShippingBtn;

    @FindBy(css = ".submit-payment")
    WebElement submitPaymentBtn;

    @FindBy(css = ".place-order")
    WebElement placeOrderBtn;

    @FindBy(css = "span.order-number")
    WebElement orderNumber;
    public CartPage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        PageFactory.initElements(driver, this);
    }

    public CartPage checkOut(){
        wait.until(elementToBeClickable(checkoutBtn));
        checkoutBtn.click();
        return this;
    }

    public CartPage submitShipping(){
        wait.until(elementToBeClickable(submitShippingBtn));
        submitShippingBtn.click();
        return this;
    }

    public CartPage updateCVV(String cvv){
        wait.until(elementToBeClickable(cvvTextBox));
        cvvTextBox.sendKeys(cvv);
        return this;
    }

    public CartPage submitPayment(){
        wait.until(elementToBeClickable(submitPaymentBtn));
        submitPaymentBtn.click();
        return this;
    }

    public CartPage placeOrder(){
        wait.until(elementToBeClickable(placeOrderBtn));
        placeOrderBtn.click();
        return this;
    }

    public String getOrderNumber(){
        wait.until(visibilityOf(orderNumber));
        return orderNumber.getText();
    }
}
