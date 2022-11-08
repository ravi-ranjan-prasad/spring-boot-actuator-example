package com.javatpoint;

import java.util.HashMap;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoMetrics implements InfoContributor {

	@Override
	public void contribute(Builder builder) {
		HashMap<String, String> customMetric = new HashMap<>();
		customMetric.put("total.no.of.transaction",Double.toString(Math.random()));
		customMetric.put("list.properties",System.lineSeparator());
		builder.withDetail("customM", customMetric);
	}

}
