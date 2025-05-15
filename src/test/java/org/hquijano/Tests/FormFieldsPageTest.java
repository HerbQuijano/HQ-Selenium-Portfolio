package org.hquijano.Tests;

import org.hquijano.pages.FormFieldsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormFieldsPageTest extends BaseTest{
    private String expectedTitle = "Form Fields";
    private String name = "John Doe";

    @Test
    public void validateFormTitle(){
        landingPage.navigateTo().clickOnFormFieldsLink();
        String actualTitle = formFieldsPage.getFormTitleText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test
    public void validateNameInputIsFocused_WhenEmptyAndSubmitIsPressed() throws InterruptedException {
        landingPage.navigateTo().clickOnFormFieldsLink();
        Assert.assertTrue(formFieldsPage.isNameElementFocused());
    }
}

