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

package org.hquijano.tests;

import org.hquijano.listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(TestListener.class)
public class JSDelaysPageTest extends BaseTest {

    @Test
    public void testCountdownEnds() {
        landingPage.navigateTo().clickOnJSDelaysLink();
        jsDelaysPage.clickStartButton();
        String liftoffMessage = jsDelaysPage.waitForLiftoff();
        Assert.assertEquals(liftoffMessage, "Liftoff!");
    }

    @Test(groups = {"smoke"})
    public void testRocketIsNotLaunchedAtPageLoad(){
        landingPage.navigateTo().clickOnJSDelaysLink();
        Assert.assertTrue(jsDelaysPage.isRocketNotLaunched());
    }

    @Test
    public void testRocketLaunchedAfterClick(){
        landingPage.navigateTo().clickOnJSDelaysLink();
        jsDelaysPage.clickStartButton();
        String liftoffMessage = jsDelaysPage.waitForLiftoff();
        Assert.assertTrue(jsDelaysPage.isRocketLaunched());
    }

}
