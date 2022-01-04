package io.confluent.developer.springccloud.flux;

import io.confluent.developer.springccloud.util.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

public class Assignment2 {

    public static void main(String[] args) {

        AtomicReference<Subscription> reference = new AtomicReference<>();
        Flux.interval(Duration.ofSeconds(1))
                .map(num -> Util.getFaker().random().nextInt(-150, 150))
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        reference.set(s);
                        s.request(50);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("Received: " + integer);
                        if(integer>120 || integer<-90) {
                            reference.get().cancel();
                            System.out.println("Stock price reached the intended price : " + integer);
                        }

                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("Error : " + t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Completed");
                    }
                });
        Util.sleep(50);
    }
}
