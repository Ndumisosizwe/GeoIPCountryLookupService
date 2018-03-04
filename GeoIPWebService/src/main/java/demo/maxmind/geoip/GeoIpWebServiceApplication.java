package demo.maxmind.geoip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = { BasePackageInterface.class })
public class GeoIpWebServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(GeoIpWebServiceApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(GeoIpWebServiceApplication.class);
	}

}
