package com.testVagrant.Test;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifyNDTVHomePage extends BaseTest {
	
	@Test(priority=1)
	public void checkNDTVHomePage() {
		assertTrue(ndtvHomePage.checkHomePage());
	}
	
}
