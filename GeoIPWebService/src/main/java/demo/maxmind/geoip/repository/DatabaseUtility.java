package demo.maxmind.geoip.repository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.maxmind.geoip.LookupService;

/**
 * Singleton spring bean that holds the maxmind lookup service, to be used
 * Across the entire application.
 * 
 * @author Ndumiso
 */
@Component
@Scope("")
public class DatabaseUtility {

	private static Logger logger = LoggerFactory.getLogger(DatabaseUtility.class);
	private static final String DATABASE_FILE_PATH;
	private static LookupService lookupService;

	static {
		DATABASE_FILE_PATH = DatabaseUtility.class.getClassLoader().getResource("static/GeoIP.dat").getFile();
		try {
			lookupService = new LookupService(new File(DATABASE_FILE_PATH));
			logger.debug("Database successfully loaded...." + "\n" + "Date : " + LocalDate.now());
		} catch (IOException e) {
			logger.debug(e.getMessage() + "\n" + "Date : " + LocalDate.now(), e);
			throw new RuntimeException(e);
		}
	}

	// return the same instance of the lookup service.
	public LookupService getMaxmindLookupServiceInstance() {
		return lookupService;
	}
}
