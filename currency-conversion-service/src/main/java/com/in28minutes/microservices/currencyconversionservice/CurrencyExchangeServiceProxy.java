
package com.in28minutes.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//name of service which we are going to call
//@FeignClient(name="currency-exchange-service", url="localhost:8000")

//approach two
//calling service direct from application /microservice
//@FeignClient(name="currency-exchange-service")
//call it from Ai Gate way in our case Zuul
@FeignClient(name="netflix-zuul-api-gateway-server")
//@FeignClient(name="netflix-zuul-api-gateway-server")
//name of the service that we are talking to for naming server
@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	//@GetMapping("/currency-exchange/from/{from}/to/{to}")
	//Append the application name for using Api Gateway
	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue
		(@PathVariable("from") String from, @PathVariable("to") String to);
}

