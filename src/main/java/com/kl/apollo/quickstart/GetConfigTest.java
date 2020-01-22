package com.kl.apollo.quickstart;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import java.util.concurrent.TimeUnit;

/**
 * @author songhengliang
 * @date 2018/8/23
 */
public class GetConfigTest {
  //

  /**
   * jvm 参数添加：需要指定是哪个appId(即哪个项目的)、哪个环境的、8080为apollo-configservice的端口
   *    -Dapp.id=apollo-quickstart -Denv=DEV -Ddev_meta=http://localhost:8080
   *
   *    ‐Dapp.id=account‐service ‐Denv=DEV ‐Dapollo.cluster=SHAJQ ‐Ddev_meta=http://localhost:8080
   *    -D应用id -D环境 -D集群
   * @param args
   */
  //
  public static void main(String[] args) {
    //读取默认namespace下的配置信息：application
    //Config config = ConfigService.getAppConfig();

    //读取指定namespace下的配置信息：spring-rocketmq
    Config config = ConfigService.getConfig("spring-rocketmq");

    while (true) {
      try {
        TimeUnit.MILLISECONDS.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      String key = "sms.enable";
      String value = config.getProperty(key, null);
      System.out.println("sms.enable: " + value);
    }


  }


}
