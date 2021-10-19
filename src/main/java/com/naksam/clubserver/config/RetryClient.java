package com.naksam.clubserver.config;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "retry", url = "http://localhost:9000/", configuration = {FeignConfiguration.class, FeignRetryConfiguration.class})
public interface RetryClient extends ExampleClient {

}
