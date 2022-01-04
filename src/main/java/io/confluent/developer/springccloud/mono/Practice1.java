package io.confluent.developer.springccloud.mono;

import io.confluent.developer.springccloud.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Practice1 {

    public static void main(String[] args) {

        Mono<String> message = getMessage();
        Mono<String> message2 = getMessage();
        message.subscribeOn(Schedulers.boundedElastic()).subscribe(Util.onNext(), Util.onError(), Util.onComplete());
        Mono<String> message3 = getMessage();

        Util.sleep(1);
    }

    public static Mono<String> getMessage() {
        System.out.println("Creating Mono......");
        return Mono.fromSupplier(() -> {
                    System.out.println("Generating quote....");
                    return Util.getFaker().hobbit().quote();
                })
                .map(String::toUpperCase)
                .map(s -> s.length()/2)
                .map(String::valueOf);
    }
}
