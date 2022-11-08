package com.javatpoint;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "custom-endpoint")
@Component
public class CustomEndpoint {
	
	Map<String ,List<String>> customDataMap = new LinkedHashMap<>();
	
	@PostConstruct
	public void initNotes() {
		customDataMap.put("L1_ACK", Arrays.asList("P95","Latency","90"));
		customDataMap.put("L2_ACK", Arrays.asList("P95","Latency","80"));
	}

	@ReadOperation
	public Map<String ,List<String>> getLatencyValue(){
		return customDataMap;
	}
	
}
