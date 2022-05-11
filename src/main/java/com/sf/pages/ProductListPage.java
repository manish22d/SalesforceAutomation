package com.sf.pages;

import com.sf.constant.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class ProductListPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "div.product-tile div.pdp-link a")
    List<WebElement> products;

    public ProductListPage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT);
        PageFactory.initElements(driver, this);
    }

    public ProductDetailsPage openFirstProduct(){
        wait.until(visibilityOfAllElements(products));
        products.stream().findFirst().orElseThrow(null).click();
        return new ProductDetailsPage(driver);
    }
}
