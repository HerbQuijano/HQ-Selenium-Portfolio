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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hquijano.core.DriverFactory;
import org.hquijano.listeners.ExtentTestListener;
import org.hquijano.listeners.ScreenshotListener;
import org.hquijano.listeners.TestListener;
import org.hquijano.pages.LandingPage;
import org.hquijano.utils.LoggerHelper;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import java.util.List;

@Listeners({TestListener.class})
public class LandingPageTest extends BaseTest {
    private int numberOfButtons = 19;

    @Test
    public void testTitle() {
        String title = landingPage.navigateTo().getTitle();
        Assert.assertEquals(title, "Learn and Practice Authomation | automateNow");
    }

    @Test
    public void testNumberOfButtons(){
        List<WebElement> buttonElements = landingPage.navigateTo().getButtonElements();
        Assert.assertEquals(buttonElements.size(), numberOfButtons, "The number of buttons on the landing page is incorrect");
    }

    @Test
    public void testHeadingText(){
        String headingText = landingPage.navigateTo().getHeadingTitle();
        Assert.assertEquals(headingText, "Welcome to your software automation practice website!");
    }

}
