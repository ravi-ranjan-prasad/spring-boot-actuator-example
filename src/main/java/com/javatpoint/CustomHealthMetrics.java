package com.javatpoint;

import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthMetrics implements HealthIndicator{

	@Override
	public Health health() {
		String urlString = "http://localhost:8080/initiatePayment";
		if(checkHealth(urlString)) {
			return Health.up().withDetail("http://localhost:8080/initiatePayment", "UP and running").build();
		}else {
			return Health.down().withDetail("http://localhost:8080/initiatePayment", "Down").build();
		}
	}

	private boolean checkHealth(String urlString) {
		boolean flag = false;
		try {
			URL url = new URL(urlString);
			URLConnection con = url.openConnection();
			con.connect();
			flag = true;
		}catch(Exception e) {
			flag = Boolean.FALSE;
		}
		return flag;
	}
	
}
