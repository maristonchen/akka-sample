package com.min.akka;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.pattern.Patterns;
import akka.util.Timeout;
import com.min.akka.config.SpringExtension;
import com.min.akka.entity.AkkaMsg;
import org.assertj.core.api.Assert;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.FiniteDuration;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@SpringBootTest
class AkkaSampleApplicationTests {

    @Autowired
    private ActorSystem actorSystem;

    @Test
    void contextLoads() throws InterruptedException {
        List<ActorRef> greeters = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            ActorRef greeter = actorSystem.actorOf(SpringExtension.SPRING_EXTENSION_PROVIDER.get(actorSystem)
                    .props("greetActor").withDispatcher("greet.dispatcher"), "greeter"+i);
            greeters.add(greeter);
        }

//        FiniteDuration duration = FiniteDuration.create(100000, TimeUnit.SECONDS);
//        Timeout timeout = Timeout.durationToTimeout(duration);

//        Future<Object> result = Patterns.ask(greeter, new AkkaMsg(1,"hello world"), timeout);
        for (int i = 0; i < greeters.size(); i++) {
            ActorRef greeter = greeters.get(i);
            greeter.tell(new AkkaMsg(i, "hello world-" + i), greeter);
        }

        Thread.sleep(1000000L);

    }

}
