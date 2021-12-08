/**
 * FileName: AutoSignConfig
 * Author:   Danny
 * Date:     2021/12/2 13:27
 * Description: 自动签到配置
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sign.config;

import com.sign.dto.SignConfigDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈自动签到配置〉
 *
 * @author Danny
 * @create 2021/12/2
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "sign")
public class SignConfig {

  private List<SignConfigDTO> signConfig;

  public List<SignConfigDTO> getSignConfig() {
    return signConfig;
  }

  public void setSignConfig(List<SignConfigDTO> signConfig) {
    this.signConfig = signConfig;
  }

  public SignConfigDTO getSignConfigDTO(String websiteType){
    if(signConfig == null || websiteType == null){
      throw new RuntimeException("获取签到配置失败");
    }
    for (SignConfigDTO signConfigDTO : signConfig) {
      if(websiteType.equals(signConfigDTO.getWebsiteType())){
        return signConfigDTO;
      }
    }
    throw new RuntimeException(String.format("未找到s%的签到配置",websiteType));
  }
}