package com.javatpoint;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
public class CustomMetricController {

    @Autowired
    MeterRegistry meterRegistry;

    @GetMapping("/customMetric")
    public  String createCustomMetric(){
        meterRegistry.counter("L1_traffic_counter").increment();
        meterRegistry.timer("L1_traffic_Latency_timer").record((new Random().nextInt(100) +1), TimeUnit.SECONDS); // random timer
        meterRegistry.gauge("L1_traffic_gauge",((new Random().nextInt(100) +1)) );
        return "success";
    }
}
