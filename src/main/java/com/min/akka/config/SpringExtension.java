/* ***************************************************
 * 创建人  : @author min
 * 创建时间: 2022/11/2/15:28
 * 项目名称: akka-sample
 * 文件名称: SpringExtension
 * 文件描述: @Description: todo(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2022
 *
 ********************************************************/
package com.min.akka.config;

import akka.actor.AbstractExtensionId;
import akka.actor.ExtendedActorSystem;
import akka.actor.Extension;
import akka.actor.Props;
import com.min.akka.actor.SpringActorProducer;
import org.springframework.context.ApplicationContext;

/**
 * 功能描述：todo <p/>
 * <p>
 * 包名称： com.min.akka.config <p/>
 * 名称：SpringExtension <p/>
 * 创建人：@author min <p/>
 * 创建时间：2022/11/2 15:28 <p/>
 */
public class SpringExtension extends AbstractExtensionId<SpringExtension.SpringExt> {

    public static final SpringExtension SPRING_EXTENSION_PROVIDER = new SpringExtension();

    @Override
    public SpringExt createExtension(ExtendedActorSystem system) {
        return new SpringExt();
    }

    public static class SpringExt implements Extension {
        private volatile ApplicationContext applicationContext;

        public void initialize(ApplicationContext applicationContext) {
            this.applicationContext = applicationContext;
        }

        public Props props(String actorBeanName) {
            return Props.create(SpringActorProducer.class, applicationContext, actorBeanName);
        }
    }
}
