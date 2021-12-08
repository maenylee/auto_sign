/**
 * FileName: JJSignServiceFactory
 * Author:   Danny
 * Date:     2021/12/7 10:21
 * Description: jj签到服务工厂
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sign.factory;

import com.sign.dto.SignConfigDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import sun.misc.BASE64Encoder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈jj签到服务工厂〉
 *
 * @author Danny
 * @create 2021/12/7
 * @since 1.0.0
 */
public class JJSignServiceFactory extends AbstractSignServiceFactory {

  private Logger logger = LoggerFactory.getLogger(JJSignServiceFactory.class);

  private final static JJSignServiceFactory jjSignServiceFactory = new JJSignServiceFactory();

  private JJSignServiceFactory() {
  }

  public static JJSignServiceFactory getInstance(SignConfigDTO signConfigDTO){
    jjSignServiceFactory.setSignConfigDTO(signConfigDTO);
    return jjSignServiceFactory;
  }

  @Override
  public String sign() {
    if(this.getHasSign()){
      logger.info("{}JJ已签到", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
      return "success";
    }
    SignConfigDTO signConfig = this.getSignConfigDTO();
    String signUrl = signConfig.getSignUrl();
    signUrl = this.buildSignUrl(signUrl);
    String sessionId = signConfig.getSessionId();
    boolean enableCheckSsl = signConfig.getEnableSslCheck();
    RestTemplate restTemplate = BaseServiceUtil.getRestTemplate(enableCheckSsl);
    HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.add(HttpHeaders.COOKIE, "sessionid=" + sessionId);
    HttpEntity<String> requestEntity = new HttpEntity<>(null, requestHeaders);
    ResponseEntity<String> response = restTemplate.exchange(signUrl, HttpMethod.POST, requestEntity, String.class);
    String str = response.getBody();
    logger.info("JJ签到响应内容：{}", str);
    try {
      JSONObject object = new JSONObject(str);
      int errNo = object.getInt("err_no");
      if(errNo == 0){
        logger.info("{}JJ签到成功", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        this.setHasSign(true);
      }
      if(errNo == 15001){
        logger.info("{}JJ已签到", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        this.setHasSign(true);
      }
    }catch (Exception e){
      e.printStackTrace();
      return "error";
    }
    return "success";
  }
  private String buildSignUrl(String url){
    try {
      String signatureOrigin = "E7BC96E7A081E69C89E8AFAF";
      String signature = new BASE64Encoder().encode(signatureOrigin.getBytes("UTF-8"));
      url = url + "?aid=2608&uuid=7035917005983401484&_signature=" + signature;
    }catch (Exception e){
      logger.error("加密异常");
    }
    return url;
  }
}