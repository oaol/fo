package com.fo.up;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author bryce
 * scanBasePackages= {"com.fo.common"} scan common module configurations
 */
@SpringBootApplication(scanBasePackages= {"com.fo.up", "com.fo.common"})
public class UpApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpApplication.class, args);
	}
	
}
