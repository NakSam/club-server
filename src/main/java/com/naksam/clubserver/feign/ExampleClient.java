package com.naksam.clubserver.feign;

import com.naksam.clubserver.dto.JsonWebToken;
import com.naksam.clubserver.dto.MemberPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "example", url = "http://169.56.174.139/account")
public interface ExampleClient {

    @PostMapping(value = "/create")
    Object request(@RequestBody MemberPayload memberPayload);

    @PostMapping(value = "/validate")
    Object request(@RequestBody JsonWebToken jsonWebToken);
}
