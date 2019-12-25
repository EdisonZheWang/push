package com.chrdw.push.service.redis.init;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Date: 12/25/19
 * @author: <a href="mailto:chrdw.p@gmail.com">Edison Zhe Wang</a>
 */
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
}
