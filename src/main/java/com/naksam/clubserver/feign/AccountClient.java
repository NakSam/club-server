package com.naksam.clubserver.feign;

import com.naksam.clubserver.dto.JsonWebToken;
import com.naksam.clubserver.dto.MemberPayload;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "example", url="${ACCOUNT_HOST:http://naksam.169.56.174.130.nip.io/account}")
public interface AccountClient {

    @PostMapping(value = "/create")
    Object createToken(@RequestBody MemberPayload memberPayload);

    @PostMapping(value = "/info")
    MemberPayload findInfo(@RequestBody JsonWebToken jsonWebToken);
}
