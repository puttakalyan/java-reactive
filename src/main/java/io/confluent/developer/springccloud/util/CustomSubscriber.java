package io.confluent.developer.springccloud.util;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class CustomSubscriber implements Subscriber {

    @Override
    public void onSubscribe(Subscription s) {
        s.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println("Received: " + o);
    }

    @Override
    public void onError(Throwable t) {
        System.out.println("ERROR: " + t.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("Completed");
    }
}
