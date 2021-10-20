package com.naksam.clubserver.feign;

import com.naksam.clubserver.config.FeignConfiguration;
import com.naksam.clubserver.config.FeignRetryConfiguration;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "retry", url="${ACCOUNT_HOST:http://naksam.169.56.174.130.nip.io/account}", configuration = {FeignConfiguration.class, FeignRetryConfiguration.class})
public interface AccountRetryClient extends AccountClient {

}
