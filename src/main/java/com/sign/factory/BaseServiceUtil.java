package com.sign.factory;

import com.sign.util.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

public class BaseServiceUtil {
  public static RestTemplate getRestTemplate(boolean enableCheckSsl){
    return RestTemplateBuilder.builder().enableSslCheck(enableCheckSsl).build();
  }
}
