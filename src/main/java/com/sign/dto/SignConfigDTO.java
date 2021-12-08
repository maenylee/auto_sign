/**
 * FileName: AutoSignConfig
 * Author:   Danny
 * Date:     2021/12/2 13:27
 * Description: 自动签到配置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sign.dto;

import java.util.Objects;

/**
 * 〈一句话功能简述〉<br> 
 * 〈自动签到配置〉
 *
 * @author Danny
 * @create 2021/12/2
 * @since 1.0.0
 */
public class SignConfigDTO {
  /**
   * http、https请求
   */
  private String signUrl;
  /**
   * sessionId
   */
  private String sessionId;
  /**
   * 是否开启ssl检查
   */
  private Boolean enableSslCheck;
  /**
   * 网站类型
   */
  private String websiteType;

  public String getSignUrl() {
    return signUrl;
  }

  public void setSignUrl(String signUrl) {
    this.signUrl = signUrl;
    if(Objects.isNull(signUrl)){
      throw new RuntimeException("sign url is null");
    }
    if(signUrl.startsWith("https")){
      this.enableSslCheck = true;
    }else {
      this.enableSslCheck = false;
    }
  }

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public Boolean getEnableSslCheck() {
    return enableSslCheck;
  }

  public String getWebsiteType() {
    return websiteType;
  }

  public void setWebsiteType(String websiteType) {
    this.websiteType = websiteType;
  }
}