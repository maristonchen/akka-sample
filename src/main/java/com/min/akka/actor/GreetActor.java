/* ***************************************************
 * 创建人  : @author min
 * 创建时间: 2022/11/2/15:20
 * 项目名称: akka-sample
 * 文件名称: GreetActor
 * 文件描述: @Description: todo(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2022
 *
 ********************************************************/
package com.min.akka.actor;

import akka.actor.AbstractActor;
import com.min.akka.entity.AkkaMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 功能描述：todo <p/>
 * <p>
 * 包名称： com.min.akka.actor <p/>
 * 名称：GreetActor <p/>
 * 创建人：@author min <p/>
 * 创建时间：2022/11/2 15:20 <p/>
 */
@Slf4j
@Component("greetActor")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GreetActor extends AbstractActor {

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(AkkaMsg.class, this::handleMsg)
                .build();
    }

    private void handleMsg(AkkaMsg msg) {
        log.info("received a msg:{},timestamp:{}", msg.toString(),System.currentTimeMillis());
    }
}
