package com.aqacourses.project.tests;

import com.aqacourses.project.base.BaseTest;
import com.aqacourses.project.pages.HomePage;
import com.aqacourses.project.pages.LoginPage;
import com.aqacourses.project.pages.MyAccountPage;
import org.junit.Test;

public class LoginAndLogoutTest extends BaseTest {

    /**
     * Open site and click on the "Sign in" link, fill in email and password to login form and click on the "Sign in" button
     * Verify name, click on the "Sign out" button and verify LoginPage after logout
     */
    @Test
    public void testLoginAndLogoutTest() {

        // Open site
        HomePage homePage = openSite();

        // Click on the "Sign in" link
        LoginPage loginPage = homePage.clickSignInLink();

        // Fill in email and password to login form and click on the "Sign in" button
        MyAccountPage myAccountPage = loginPage.login();

        // Verify name
        myAccountPage.verifyName();

        // Click on the "Sign out" button
        LoginPage loginPageAfterLogout = myAccountPage.logout();

        // Verify LoginPage after logout
        loginPageAfterLogout.verifyLoginPage();

        // Close site
        closeSite();
    }

}
