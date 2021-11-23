package com.fajardo.currencyconversionservice;

import com.netflix.client.config.CommonClientConfigKey;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000" )
//Enabling feign
@FeignClient(name = "currency-exchange-service")
//Enabling ribbon
@RibbonClient(name = "currency-exchange-service", configuration = RibbonClientConfiguration.class)
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
                                                        @PathVariable("to") String to);
}
