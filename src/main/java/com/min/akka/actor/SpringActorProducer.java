/* ***************************************************
 * 创建人  : @author min
 * 创建时间: 2022/11/2/15:39
 * 项目名称: akka-sample
 * 文件名称: SpringActorProducer
 * 文件描述: @Description: todo(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2022
 *
 ********************************************************/
package com.min.akka.actor;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;
import org.springframework.context.ApplicationContext;

/**
 * 功能描述：todo <p/>
 * <p>
 * 包名称： com.min.akka.actor <p/>
 * 名称：SpringActorProducer <p/>
 * 创建人：@author min <p/>
 * 创建时间：2022/11/2 15:39 <p/>
 */
public class SpringActorProducer implements IndirectActorProducer {

    private ApplicationContext applicationContext;

    private String beanActorName;

    public SpringActorProducer(ApplicationContext applicationContext,
                               String beanActorName) {
        this.applicationContext = applicationContext;
        this.beanActorName = beanActorName;
    }

    @Override
    public Actor produce() {
        return (Actor) applicationContext.getBean(beanActorName);
    }

    @Override
    public Class<? extends Actor> actorClass() {
        return (Class<? extends Actor>) applicationContext.getType(beanActorName);
    }
}
