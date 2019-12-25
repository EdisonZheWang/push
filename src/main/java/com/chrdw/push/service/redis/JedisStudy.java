package com.chrdw.push.service.redis;

import redis.clients.jedis.Jedis;

/**
 * @Date: 12/25/19
 * @author: <a href="mailto:chrdw.p@gmail.com">Edison Zhe Wang</a>
 */
public class JedisStudy {

  public static void main(String[] args) {
    Jedis jedis = new Jedis("localhost");
    try {
      jedis.set("name", "list");
      String name = jedis.get("name");
      System.out.println(name);

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      jedis.close();
    }

  }
}
