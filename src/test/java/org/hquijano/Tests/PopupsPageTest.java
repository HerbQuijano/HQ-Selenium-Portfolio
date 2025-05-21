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
import org.hquijano.listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class PopupsPageTest extends BaseTest {

    @Test
    public void testAcceptAlertPopupText(){
        landingPage.navigateTo().clickOnPopupsLink();
        String popupText = popupsPage.clickAlertPopupButton().getPopupText();
        Assert.assertEquals(popupText, "Hi there, pal!");
    }

    @Test
    public void testAcceptAlertPopupIsClosed_Accept(){
        landingPage.navigateTo().clickOnPopupsLink();
        popupsPage.clickAlertPopupButton().acceptPopupAlert();
        Assert.assertFalse(popupsPage.validateAlertIsClosed(), "Alert is still present after pressing Accept");
    }

    @Test
    public void testConfirmAlertPopupText(){
        landingPage.navigateTo().clickOnPopupsLink();
        String popupText = popupsPage.clickConfirmPopupButton().getPopupText();
        Assert.assertEquals(popupText, "OK or Cancel, which will it be?");
    }

    @Test
    public void testConfirmAlertPopupIsClosed_Accept(){
        landingPage.navigateTo().clickOnPopupsLink();
        popupsPage.clickConfirmPopupButton().acceptPopupAlert();
        Assert.assertFalse(popupsPage.validateAlertIsClosed(), "Alert is still present after pressing Accept");
    }
    @Test
    public void testConfirmAlertPopupIsClosed_Dismiss(){
        landingPage.navigateTo().clickOnPopupsLink();
        popupsPage.clickConfirmPopupButton().dismissPopupAlert();
        Assert.assertFalse(popupsPage.validateAlertIsClosed(), "Alert is still present after pressing Dismiss");
    }

    @Test
    public void testConfirmText_Accept(){
        landingPage.navigateTo().clickOnPopupsLink();
        popupsPage.clickConfirmPopupButton().acceptPopupAlert();
        String confirmText = popupsPage.getConfirmResultText();
        Assert.assertEquals(confirmText, "OK it is!");
    }

    @Test
    public void testConfirmText_Dismiss() {
        landingPage.navigateTo().clickOnPopupsLink();
        popupsPage.clickConfirmPopupButton().dismissPopupAlert();
        String confirmText = popupsPage.getConfirmResultText();
        Assert.assertEquals(confirmText, "Cancel it is!");
    }

    @Test
    public void testPromptAlertText(){
        landingPage.navigateTo().clickOnPopupsLink();
        popupsPage.clickPromptPopupButton();
        String popupText = popupsPage.getPopupText();
        Assert.assertEquals(popupText, "Hi there, what's your name?");
    }

    @Test(dataProvider = "alertInputs")
    public void testPromptAlertInput_Accept(String inputValue, String expectedConfirmText){
        landingPage.navigateTo().clickOnPopupsLink();
        popupsPage.clickPromptPopupButton();
        popupsPage.typeAlertInput(inputValue);
        popupsPage.acceptPopupAlert();
        String promptResult = popupsPage.getPromptResultText();
        Assert.assertEquals(promptResult, expectedConfirmText);
    }

    @DataProvider(name = "alertInputs")
    public Object[][] alertInputs(){
        return new Object[][]{
                {"Spiderman", "Nice to meet you, Spiderman!"},
                {"Black Widow", "Nice to meet you, Black Widow!"},
                {"", "Fine, be that way..."},
                {"1", "Nice to meet you, 1!"}
        };
    }

    @Test
    public void testPromptAlertInput_Dismiss(){
        landingPage.navigateTo().clickOnPopupsLink();
        popupsPage.clickPromptPopupButton().dismissPopupAlert();
        String promptResult = popupsPage.getPromptResultText();
        Assert.assertEquals(promptResult, "Fine, be that way...");
    }
}
