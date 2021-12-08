/**
 * FileName: SignServiceImpl
 * Author:   Danny
 * Date:     2021/12/2 13:47
 * Description: 签到服务实现类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sign.service;

import com.sign.config.Const;
import com.sign.config.SignConfig;
import com.sign.dto.SignConfigDTO;
import com.sign.factory.JJServiceFactory;
import com.sign.factory.JJSignServiceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 〈一句话功能简述〉<br> 
 * 〈签到服务实现类〉
 *
 * @author Danny
 * @create 2021/12/2
 * @since 1.0.0
 */
@Service
public class SignService {

  @Autowired
  private SignConfig signConfig;

  /**
   * jj签到服务
   */
  public void jjSign(){
    SignConfigDTO signConfigDTO = signConfig.getSignConfigDTO(Const.SignConst.JJ);
    JJSignServiceFactory jjSignServiceFactory = JJSignServiceFactory.getInstance(signConfigDTO);
    JJServiceFactory.builder().signService(jjSignServiceFactory).sign();
  }
}