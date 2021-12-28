package com.amazon.pages;

import com.amazon.utility.Utility;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    //private static final Logger log = LogManager.getLogger(HomePage.class.getName());


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//span[@id='aee-xop-dismiss']//input[@type='submit']")
    WebElement alertok;

    @CacheLookup
    @FindBy (id = "twotabsearchtextbox")
    WebElement searchBar;

    //public void clickOkToAlert(){        clickOnElement(alertok);    }

    public void sendTextToSearch(String searchText){
        sendTextToElement(searchBar,searchText);

    }

}
