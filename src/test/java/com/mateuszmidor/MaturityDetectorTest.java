package com.mateuszmidor;

import org.junit.Assert;
import org.junit.Test;


public class MaturityDetectorTest {
// run as mvn clean test pitest:mutationCoverage site, result in target/pitreports
	@Test
	public void testIsMature() {
		MaturityDetector detector = new MaturityDetector();
		Assert.assertFalse(detector.isMature(17));
		
		// boundary check not run - pitest will spot that!
		//Assert.assertTrue(detector.isMature(18));
		
		Assert.assertTrue(detector.isMature(19));
	}

}
