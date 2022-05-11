package com.sf.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {
    @BeforeMethod
    public void login() throws InterruptedException {
        loginpage = homePage.closeModal().navigateToLogin();
        homePage = loginpage.performLogin(userId,pwd);
        Thread.sleep(5000);

    }

    @Test
    public void verifyOrderNumberGeneratedCorrectly(){
        productListPage = homePage.navigateToMens().navigateToAccessories().navigateToTies();
        productDetailsPage=productListPage.openFirstProduct();
        cartPage = productDetailsPage.selectColor().addToCart().navigateToCartPage();
        cartPage.checkOut().submitShipping().updateCVV("123").submitPayment().placeOrder();
        System.out.println("Order Number is : "+cartPage.getOrderNumber());
    }
}
