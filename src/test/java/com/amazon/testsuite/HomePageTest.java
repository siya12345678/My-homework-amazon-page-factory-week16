package com.amazon.testsuite;

import com.amazon.pages.HomePage;
import com.amazon.pages.SearchResultPage;
import com.amazon.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import javax.naming.directory.SearchResult;

public class HomePageTest extends TestBase {

    HomePage homePage;
    SearchResultPage searchResultPage;

    @BeforeMethod
    public void init(){
        homePage=new HomePage();
        searchResultPage=new SearchResultPage();
    }
    @Test
    @Parameters({"search1","description1","quantity1","message1"})
    public void userShouldSearchAndAddLaptopToCartSuccessfully(String lSearch, String lDescription,
                                                               String lQuantity, String Message) throws InterruptedException {
        homePage.sendTextToSearch(lSearch);
        searchResultPage.searchItemFromList(lDescription);
        searchResultPage.selectQty(lQuantity);
        searchResultPage.clickAddButton();
        searchResultPage.addToCartVerify();

    }
    @Test
    @Parameters({"search2", "description2", "quantity2", "message2" })
    public void userShouldSearchAndAddMobilePhonesToCartSuccessfully(String mSearch, String mDescription, String mQuantity, String mMessage) throws InterruptedException{
      homePage.sendTextToSearch(mSearch);
      searchResultPage.searchItemFromList(mDescription);
      searchResultPage.selectQty(mQuantity);
      searchResultPage.clickAddButton();
      searchResultPage.addToCartVerify();
      searchResultPage.mobileVerify();
    }





}
