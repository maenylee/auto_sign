/**
 * FileName: JJServiceFactory
 * Author:   Danny
 * Date:     2021/12/2 20:27
 * Description: 签到服务工厂类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sign.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 〈一句话功能简述〉<br> 
 * 〈签到服务工厂类〉
 *
 * @author Danny
 * @create 2021/12/2
 * @since 1.0.0
 */
public class JJServiceFactory implements IJJServiceFactory {

  private Logger logger = LoggerFactory.getLogger(JJServiceFactory.class);

  private JJSignServiceFactory jjSignServiceFactory;

  public static JJServiceFactory builder(){
    return new JJServiceFactory();
  }

  public JJServiceFactory signService(JJSignServiceFactory signServiceFactory){
    this.jjSignServiceFactory = signServiceFactory;
    return this;
  }

  @Override
  public void sign() {
    jjSignServiceFactory.sign();
  }
}