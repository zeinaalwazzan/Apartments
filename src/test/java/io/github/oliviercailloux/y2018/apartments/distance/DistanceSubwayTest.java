package io.github.oliviercailloux.y2018.apartments.distance;

import org.junit.Assert;
import org.junit.jupiter.api.Test;


import io.github.oliviercailloux.y2018.apartments.utils.KeyManager;
import io.github.oliviercailloux.y2018.apartments.valuefunction.DistanceMode;

/**
 * Inspiration for reading .txt file : https://www.ukonline.be/programmation/java/tutoriel/chapitre12/page3.php
 *
 */
class DistanceSubwayTest {
	
	/**
	 * The test check if the distance (in second) between Ville d'Avray and 
	 * Paris is below 2h (6300 seconds) and above 30 minutes (1800 seconds)
	 * This test fail in unnatural conditions of circulation (strike, etc...)
	 * @throws Exception 
	 */
	@Test
	void calculateDistanceAddressTest() throws Exception {

		DistanceSubway dist = new DistanceSubway("Paris","Ville d'Avray",KeyManager.getApiKey());
		double time = dist.calculateDistanceAddress(DistanceMode.ADDRESS);
		Assert.assertTrue(7200 > time &&  1800 < time);
	}

}
