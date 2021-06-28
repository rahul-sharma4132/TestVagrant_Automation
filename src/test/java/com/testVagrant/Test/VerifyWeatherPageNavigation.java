package com.testVagrant.Test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.testvagrant.ndtvPageObjects.NDTVWeatherPage;

public class VerifyWeatherPageNavigation extends BaseTest {
	
	@Test(priority=2)
	public static void verifyWeatherPage() throws InterruptedException {
		ndtvHomePage.navigateToWeatherPage();
		assertTrue(NDTVWeatherPage.checkWeatherPage());
	}
	
}
