package demo.maxmind.geoip;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.maxmind.geoip.LookupService;

import demo.maxmind.geoip.GeoIpWebServiceApplication;
import demo.maxmind.geoip.repository.DatabaseUtility;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { GeoIpWebServiceApplication.class })
public class GeoIpWebServiceApplicationTests extends TestCase {
	/**
	 * <Country, IP> entries.
	 */
	private static final Map<String, String> TEST_ADDRESSES;
	static {
		TEST_ADDRESSES = new HashMap<>();
		TEST_ADDRESSES.put("South Africa", "41.149.72.132");
		TEST_ADDRESSES.put("Japan", "124.37.32.223");
		TEST_ADDRESSES.put("Germany", "95.116.101.163");
	}
	@Autowired
	private DatabaseUtility databaseUtility;

	@Test
	public void testShouldReturnCorrectCountryNamesForGivenIp() {
		LookupService lookupService = databaseUtility.getMaxmindLookupServiceInstance();
		TEST_ADDRESSES.keySet()
				.forEach(key -> assertEquals(key, lookupService.getCountry(TEST_ADDRESSES.get(key)).getName()));
	}

}
