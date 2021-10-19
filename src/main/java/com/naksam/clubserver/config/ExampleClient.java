package com.naksam.clubserver.config;

import com.naksam.clubserver.dto.MemberPayload;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "example", url = "http://account:8080/account", configuration = {HeaderConfiguration.class})
public interface ExampleClient {

    @PostMapping(value = "/create")
    Object request(@RequestBody MemberPayload memberPayload);
}
