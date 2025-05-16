/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hquijano.Tests;

import org.hquijano.listeners.ScreenshotListener;
import org.hquijano.pages.FormFieldsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
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

