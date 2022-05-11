package com.sf.pages;

import com.sf.constant.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class ProductDetailsPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "button.color-attribute")
    List<WebElement> colors;

    @FindBy(css = "button.add-to-cart")
    WebElement addToCartButton;

    @FindBy(css = "a.minicart-link")
    WebElement cartButton;
    public ProductDetailsPage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        PageFactory.initElements(driver, this);
    }

    public ProductDetailsPage selectColor(){
        wait.until(visibilityOfAllElements(colors));
        colors.stream().findAny().orElseThrow(null).click();
        return this;
    }

    public ProductDetailsPage addToCart(){
        wait.until(elementToBeClickable(addToCartButton));
        addToCartButton.click();
        return this;
    }

    public CartPage navigateToCartPage(){
        wait.until(elementToBeClickable(cartButton));
        cartButton.click();
        return new CartPage(driver);
    }

}
