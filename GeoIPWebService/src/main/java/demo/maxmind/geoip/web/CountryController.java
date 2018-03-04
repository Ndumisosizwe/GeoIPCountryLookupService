package demo.maxmind.geoip.web;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxmind.geoip.Country;

import demo.maxmind.geoip.service.MyCountryLookupService;

/**
 * Restful API for countries.
 * 
 * @author Ndumiso
 *
 */

@RestController
@RequestMapping(value = "/api/countries", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin("*")
public class CountryController {

	private static Logger logger = LoggerFactory.getLogger(CountryController.class);

	@Autowired
	private MyCountryLookupService lookupService;

	/**
	 * Given an IP address, returns a country. if an invalid IP address is provided, a
	 * country with @null values will be returned to the client.
	 * 
	 * @param ip
	 * @return Country
	 */
	@GetMapping("/{ip}")
	public ResponseEntity<Country> findCountryByIp(@PathVariable("ip") String ip) {
		logger.debug("Request to find Country by IP : " + ip + "\n" + "Date & Time : " + LocalDate.now() + "\n");
		Country result = lookupService.findCountryByIp(ip);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
