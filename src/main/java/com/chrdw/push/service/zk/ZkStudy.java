package com.chrdw.push.service.zk;

import java.io.IOException;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

/**
 * @Date: 12/25/19
 * @author: <a href="mailto:chrdw.p@gmail.com">Edison Zhe Wang</a>
 */
public class ZkStudy {
  private static final String ZKHOST = "localhost:2181";
  private static int TIMEOUT = 30 * 1000;

  public static void main(String[] args) {
    ZooKeeper zk = null;
    try {
      zk = new ZooKeeper(ZKHOST, TIMEOUT, new Watcher() {
        @Override
        public void process(WatchedEvent event) {
          System.out.println("Something Happening...");
        }
      });
      String s = zk.create("/ZkStudy", "Study Of ZK".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
        CreateMode.PERSISTENT);
      Stat stat = new Stat();
      zk.getACL("/ZkStudy", stat);
      System.out.println(stat);
      System.out.println(s);
      zk.delete(s, stat.getVersion());
    } catch (IOException | KeeperException | InterruptedException e) {
      e.printStackTrace();
    } finally {
      try {
        zk.close();
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        zk = null;
      }
    }
  }
}
