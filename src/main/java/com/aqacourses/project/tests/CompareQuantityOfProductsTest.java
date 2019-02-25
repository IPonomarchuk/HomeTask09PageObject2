package com.aqacourses.project.tests;

import com.aqacourses.project.base.BaseTest;
import com.aqacourses.project.pages.DressesPage;
import com.aqacourses.project.pages.HomePage;
import com.aqacourses.project.pages.LoginPage;
import com.aqacourses.project.pages.MyAccountPage;
import org.junit.Test;

public class CompareQuantityOfProductsTest extends BaseTest {

    /**
     * Open site and click on the "Sign in" link, fill in email and password to login form and click on the "Sign in" button
     * Verify that quantity of products on the page is the same as in the message
     * Choose white dresses and verify that quantity of products on the page is the same as in the message
     */
    @Test
    public void testCompareQuantityOfProductsTest() {

        // Open site
        HomePage homePage = openSite();

        // Click on the "Sign in" link
        LoginPage loginPage = homePage.clickSignInLink();

        // Fill in email and password to login form and click on the "Sign in" button
        MyAccountPage myAccountPage = loginPage.login();

        // Open DressesPage
        DressesPage dressesPage = myAccountPage.openDressesPage();

        // Choose Summer Dresses Category
        dressesPage.chooseSummerDressesCategory();

        // Verify that quantity of products on the page is the same as in the message
        dressesPage.verifyQuantityOfProducts();

        // Choose white dresses
        dressesPage.chooseWhiteDresses();

        // Verify that quantity of products on the page is the same as in the message
        dressesPage.verifyQuantityOfProducts();

        // Close site
        closeSite();
    }

}
