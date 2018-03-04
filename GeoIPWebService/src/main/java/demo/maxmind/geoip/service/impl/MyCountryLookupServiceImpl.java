package demo.maxmind.geoip.service.impl;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxmind.geoip.Country;

import demo.maxmind.geoip.repository.DatabaseUtility;
import demo.maxmind.geoip.service.MyCountryLookupService;

/**
 * Service performs operations from given ip address
 * per request.
 *
 * @author Ndumiso
 */

@Service
public class MyCountryLookupServiceImpl implements MyCountryLookupService {

    private static Logger logger = LoggerFactory.getLogger(MyCountryLookupServiceImpl.class);
    
    @Autowired
	private DatabaseUtility databaseUtility;

    @Override
    public Country findCountryByIp(String ip) {
        logger.debug("Request for service to fetch country by IP : " + ip + "\n" + "Date : " + LocalDate.now());
        return databaseUtility.getMaxmindLookupServiceInstance().getCountry(ip);
    }
}
