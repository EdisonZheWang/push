package com.chrdw.push.service.init;

import java.util.concurrent.ThreadPoolExecutor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Date: 2019/12/1
 * @author: <a href="mailto:chrdw.p@gmail.com">Edison Zhe Wang</a>
 */
@Configuration
public class InitSupport {

  @Bean
  @ConfigurationProperties(prefix = "config.appconfig.pushexecutor")
  public ThreadPoolTaskExecutor pushExecutor() {
    return new ThreadPoolTaskExecutor();
  };
}
