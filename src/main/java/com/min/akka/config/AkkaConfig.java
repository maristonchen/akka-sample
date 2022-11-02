/* ***************************************************
 * 创建人  : @author min
 * 创建时间: 2022/11/2/15:51
 * 项目名称: akka-sample
 * 文件名称: AkkaConfig
 * 文件描述: @Description: todo(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2022
 *
 ********************************************************/
package com.min.akka.config;

import akka.actor.ActorSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述：todo <p/>
 * <p>
 * 包名称： com.min.akka.config <p/>
 * 名称：AkkaConfig <p/>
 * 创建人：@author min <p/>
 * 创建时间：2022/11/2 15:51 <p/>
 */
@Configuration
public class AkkaConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public ActorSystem actorSystem() {
        ActorSystem system = ActorSystem.create("akka-spring-demo");
        SpringExtension.SPRING_EXTENSION_PROVIDER.get(system).initialize(applicationContext);
        return system;
    }
}
