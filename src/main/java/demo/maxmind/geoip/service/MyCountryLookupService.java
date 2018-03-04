package demo.maxmind.geoip.service;

import com.maxmind.geoip.Country;

public interface MyCountryLookupService {

    /**
     * finds a country based on given IP address
     *
     * @param ip
     */
    Country findCountryByIp(String ip);
}
