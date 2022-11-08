package com.javatpoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class DemoRestController 
{
	
	private static final Logger logger = LogManager.getLogger(DemoRestController.class);
	
@GetMapping("/initiatePayment")
public String initiatePayment() 
{
	logger.info("initiatePayment started");
return "InitiatePayment !";
}


@GetMapping("/validatePayment")
public String validatePayment() 
{
 logger.info("validatePayment started");
 logger.info("validatePayment ended");
return "validatePayment !";
}

@GetMapping("/customeEndPoint")
public String customeEndPoint() 
{
	logger.error("customeEndPoint error test");
return "customeEndPoint !";
}


}
