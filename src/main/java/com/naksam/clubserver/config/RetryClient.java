package com.naksam.clubserver.config;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "retry", url = "http://169.56.174.139/account", configuration = {FeignConfiguration.class, FeignRetryConfiguration.class})
public interface RetryClient extends ExampleClient {

}
