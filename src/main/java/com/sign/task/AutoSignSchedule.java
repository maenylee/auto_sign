/**
 * FileName: AutoSignSchedule
 * Author:   Danny
 * Date:     2021/12/1 15:01
 * Description: 自动签到定时任务
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sign.task;

import com.sign.service.SignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈自动签到定时任务〉
 *
 * @author Danny
 * @create 2021/12/1
 * @since 1.0.0
 */
@Component
public class AutoSignSchedule {

  private Logger logger = LoggerFactory.getLogger(AutoSignSchedule.class);

  @Autowired
  private SignService signService;

  @Scheduled(cron = "0/2 * * * * ?")
  public void autoSign(){
    logger.info("{}签到定时任务开始", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
    signService.jjSign();
    logger.info("{}签到定时任务结束", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
  }
}