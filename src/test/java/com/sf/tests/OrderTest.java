package com.sf.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {
    @BeforeMethod
    public void login() throws InterruptedException {
        loginpage = homePage.closeModal().navigateToLogin();
        homePage = loginpage.performLogin(userId, pwd);
        Thread.sleep(5000);

    }

    @Test
    public void verifyOrderNumberGeneratedCorrectly() throws InterruptedException {
        productListPage = homePage.navigateToMens().navigateToAccessories().navigateToTies();
        productDetailsPage = productListPage.openFirstProduct();
        cartPage = productDetailsPage.selectColor().addToCart().navigateToCartPage();
        cartPage.checkOut().submitShipping().updateCVV("123").submitPayment().placeOrder();
        System.out.println("Order Number is : " + cartPage.getOrderNumber());
    }

    @Test
    public void verifyDifferentAddressForDifferentProduct() throws InterruptedException {

        for (int i = 1; i <= 3; i++) {
            productListPage = homePage.navigateToMens().navigateToAccessories().navigateToGloves();
            productDetailsPage = productListPage.viewNthProduct(i);
            productDetailsPage
                    .selectColor()
                    .selectSize()
                    .addToCart();
        }
        cartPage = productDetailsPage.navigateToCartPage();
        cartPage.checkOut().selectDifferentShippingAddress().submitShipping().updateCVV("123").submitPayment().placeOrder();
        System.out.println("Order Number is : " + cartPage.getOrderNumber());
    }
}
