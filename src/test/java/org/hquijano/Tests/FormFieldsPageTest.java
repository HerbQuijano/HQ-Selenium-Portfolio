package org.hquijano.Tests;

import org.hquijano.pages.FormFieldsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormFieldsPageTest extends BaseTest{
    private FormFieldsPage formFieldsPage;
    private String expectedTitle = "Form Fields";
    private String name = "John Doe";

    @BeforeMethod
    public void navigateToFormFieldsPage(){
        landingPage.clickOnFormFieldsLink();
        formFieldsPage = new FormFieldsPage(driver);
    }

    @Test
    public void validateFormTitle(){
        String actualTitle = formFieldsPage.getFormTitleText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void validateNameInputIsFocused_WhenEmptyAndSubmitIsPressed() throws InterruptedException {
        Assert.assertTrue(formFieldsPage.isNameElementFocused());
    }
}

