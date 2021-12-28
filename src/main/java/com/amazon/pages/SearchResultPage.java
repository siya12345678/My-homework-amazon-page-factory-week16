package com.amazon.pages;

import com.amazon.utility.Utility;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage extends Utility {

   // private static final Logger log = LogManager.getLogger(SearchResultPage.class.getName());


    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    List<WebElement> result;

    @CacheLookup
    @FindBy(id = "quantity")
    WebElement qtyDropdown;
    @CacheLookup
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCartButton;
    @CacheLookup
    @FindBy(xpath = "//div[@id='attachDisplayAddBaseAlert']//h4[@class='a-alert-heading'][normalize-space()='Added to Cart']")
    WebElement verifyAddToCart;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Added to Cart')]")
    WebElement mobileVerify;


    public void searchItemFromList(String text) throws InterruptedException {
        boolean myBreak = true;
        while (myBreak) {
            for (WebElement menu : result) {
                if (menu.getText().equalsIgnoreCase(text)) {
                    System.out.println(menu.getText());
                    clickOnElement(menu);
                    myBreak = false;
                    break;
                }
            }
            if (myBreak) {
                if (!driver.getCurrentUrl().contains("page=20")) {
                    waitUntilVisibilityOfElementLocated(By.linkText("Next"), 100).click();
                } else {
                    myBreak = false;
                }
                PageFactory.initElements(driver, this);
                Thread.sleep(5000);
            }
        }
    }


    public void selectQty(String qty) {
        selectByVisibleTextFromDropDown(qtyDropdown, qty);
    }

    public void clickAddButton() {
        clickOnElement(addToCartButton);
    }

    public String addToCartVerify() throws InterruptedException {
        Thread.sleep(2000);
        return getTextFromElement(verifyAddToCart);

    }

    public String mobileVerify() {
        return getTextFromElement(mobileVerify);
    }


}
