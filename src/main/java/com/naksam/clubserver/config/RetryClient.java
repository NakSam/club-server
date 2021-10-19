package com.naksam.clubserver.config;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "retry", url = "account:8080/", configuration = {FeignConfiguration.class, FeignRetryConfiguration.class})
public interface RetryClient extends ExampleClient {

}
