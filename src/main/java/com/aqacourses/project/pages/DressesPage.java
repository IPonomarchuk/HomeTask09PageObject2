package com.aqacourses.project.pages;

import com.aqacourses.project.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DressesPage extends AbstractPage {

    //Web elements
    @FindBy(xpath = "//div[@class='block_content']//a[@title='Short dress, long dress, silk dress, printed dress, " +
            "you will find the perfect dress for summer.'][contains(text(),'Summer Dresses')]")
    private WebElement summerDressesButton;

    @FindBy(xpath = "//input[@id='layered_id_attribute_group_8'][@style='background: #ffffff;']")
    private WebElement whiteCheckBox;

    @FindBy(xpath = "//span[@class='heading-counter']")
    private WebElement counterOfProducts;

    @FindBy(xpath = "//div[@class='product-container']")
    private List<WebElement> listOfProducts;

    @FindBy(xpath = "//span[@class='cat-name'][contains(text(),'Summer Dresses > Color White')]")
    private WebElement whiteColorFilter;

    /**
     * Constructor
     *
     * @param testClass
     */
    public DressesPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(divPage);
    }

    /**
     * Click on the "Summer Dresses" button
     */
    public void chooseSummerDressesCategory() {
        testClass.waitTillElementIsVisible(summerDressesButton);
        summerDressesButton.click();
    }

    /**
     * Click on the "White" checkbox
     */
    public void chooseWhiteDresses() {
        testClass.waitTillElementIsVisible(whiteCheckBox);
        whiteCheckBox.click();
        testClass.waitTillElementIsVisible(whiteColorFilter);
    }

    /**
     * Verify that quantity of products on the page is the same as in the message
     */
    public void verifyQuantityOfProducts() {
        testClass.waitTillListOfElementsAreVisible(listOfProducts);
        testClass.waitTillElementIsVisible(counterOfProducts);
        Assert.assertEquals("Quantity of products on the page is not the same as in the message"
                , listOfProducts.size(), Integer.parseInt(counterOfProducts.getText().replaceAll("[\\D]", "")));
    }

}