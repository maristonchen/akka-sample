/* ***************************************************
 * 创建人  : @author min
 * 创建时间: 2022/11/2/16:27
 * 项目名称: akka-sample
 * 文件名称: AkkaController
 * 文件描述: @Description: todo(用一句话描述该文件做什么)
 *
 * All rights Reserved, Designed By 深圳市赢和信息技术有限公司
 * @Copyright:2016-2022
 *
 ********************************************************/
package com.min.akka.controller;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.google.common.collect.Lists;
import com.min.akka.config.SpringExtension;
import com.min.akka.entity.AkkaMsg;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 功能描述：todo <p/>
 * <p>
 * 包名称： com.min.akka.controller <p/>
 * 名称：AkkaController <p/>
 * 创建人：@author min <p/>
 * 创建时间：2022/11/2 16:27 <p/>
 */
@RestController
@RequestMapping("akka")
public class AkkaController implements InitializingBean {
    private final ActorSystem actorSystem;

    private final List<ActorRef> greeters = Lists.newArrayList();

    public AkkaController(ActorSystem actorSystem) {
        this.actorSystem = actorSystem;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (int i = 0; i < 100; i++) {
            ActorRef greeter = actorSystem.actorOf(SpringExtension.SPRING_EXTENSION_PROVIDER.get(actorSystem)
                    .props("greetActor").withDispatcher("greet.dispatcher"), "greeter"+i);
            greeters.add(greeter);
        }
    }

    @GetMapping("greet")
    public String greet() {
        for (int i = 0; i < greeters.size(); i++) {
            ActorRef greeter = greeters.get(i);
            greeter.tell(new AkkaMsg(i, "hello world-" + i), greeter);
        }
        return "success";
    }
}
