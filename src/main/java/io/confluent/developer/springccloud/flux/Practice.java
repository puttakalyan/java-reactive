package io.confluent.developer.springccloud.flux;

import io.confluent.developer.springccloud.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.concurrent.atomic.AtomicReference;


public class Practice {

    private static AtomicReference<FluxSink<Object>> sinkAtomicReference = new AtomicReference<>();

    public static void main(String[] args) {

//        Flux.generate(synchronousSink -> {
//            Util.sleep(1);
//            System.out.println("Emitting..");
//            synchronousSink.next("Hello world");
//        }).log().take(3).log().subscribe(Util.subscriber());

        Flux.create(fluxSink -> sinkAtomicReference.set(fluxSink)).subscribe(Util.subscriber());

        sinkAtomicReference.get().next("Hello");
        sinkAtomicReference.get().next("Hello");
        sinkAtomicReference.get().next("Hello").complete();
        sinkAtomicReference.get().next("Hello");

        Util.sleep(1);

    }


}
